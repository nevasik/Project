package ru.poplaukhin.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.poplaukhin.spring.dto.BookDto;
import ru.poplaukhin.spring.models.Book;
import ru.poplaukhin.spring.models.Person;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void save(@Valid BookDto book) throws IOException {
        jdbcTemplate.update("INSERT INTO Book(title, author, year, avatar) VALUES (?, ?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getYear(), encode(book.getAvatar()));
    }

    public void update(int id, BookDto book) throws IOException {
        if (book.getAvatar().isEmpty()) {
            jdbcTemplate.update("UPDATE Book SET title=?, author=?, year=? WHERE id=?",
                    book.getTitle(), book.getAuthor(), book.getYear(), id);
        } else {
            jdbcTemplate.update("UPDATE Book SET title=?, author=?, year=?, avatar=? WHERE id=?",
                    book.getTitle(), book.getAuthor(), book.getYear(), encode(book.getAvatar()), id);
        }
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.id " + "WHERE Book.id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void release(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=NULL WHERE id=?", id);
    }

    public void assign(int id, Person selectedPerson) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", selectedPerson.getId(), id);
    }

    private String encode(MultipartFile avatar) throws IOException {
        if (avatar != null) {
            return Base64.getEncoder().encodeToString(avatar.getBytes());
        }
        return null;
    }
}
package ru.poplaukhin.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.poplaukhin.spring.dto.PersonDto;
import ru.poplaukhin.spring.models.Book;
import ru.poplaukhin.spring.models.Person;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> fullPeople() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(@Valid PersonDto person) throws IOException {
        jdbcTemplate.update("INSERT INTO Person(full_name, year_of_birth, avatar) VALUES (?, ?, ?)",
                person.getFull_name(), person.getYear_of_birth(), encode(person.getAvatar()));
    }

    public void update(int id, PersonDto person) throws IOException {
        if (person.getAvatar().isEmpty()) {
            jdbcTemplate.update("UPDATE Person SET full_name=?, year_of_birth=? WHERE id=?", person.getFull_name(), person.getYear_of_birth(), id);
        } else {
            jdbcTemplate.update("UPDATE Person SET full_name=?, year_of_birth=?, avatar=? WHERE id=?",
                    person.getFull_name(), person.getYear_of_birth(), encode(person.getAvatar()), id);
        }
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    // Для Валидации ФИО
    public Optional<Person> getPersonByFullName(String fullName) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE full_name=?", new Object[]{fullName},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public List<Book> getBookByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

    public String encode(MultipartFile avatar) throws IOException {
        if (avatar != null) {
            return Base64.getEncoder().encodeToString(avatar.getBytes());
        }
        return null;
    }
}

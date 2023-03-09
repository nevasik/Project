package ru.poplaukhin.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class Personal_Accounts {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Personal_Accounts(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Personal_Accounts> getAll() {
        return jdbcTemplate.query("SELECT * FROM Personal_Accounts", new BeanPropertyRowMapper<>(Personal_Accounts.class));
    }


}
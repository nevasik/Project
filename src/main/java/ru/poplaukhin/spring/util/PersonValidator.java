package ru.poplaukhin.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.poplaukhin.spring.dao.PersonDAO;
import ru.poplaukhin.spring.dto.PersonDto;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PersonDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PersonDto person = (PersonDto) o;

        if (personDAO.getPersonByFullName(person.getFull_name()).isPresent()) {
            errors.rejectValue("fullName", "", "Человек с таким ФИО уже существует");
        }
    }
}

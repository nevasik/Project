//package ru.poplaukhin.spring.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import ru.poplaukhin.spring.dao.PersonDAO;
//import ru.poplaukhin.spring.util.PersonValidator;
//import javax.validation.Valid;
//import java.io.IOException;
//
//@Controller
//@RequestMapping("/people")
//public class PersonController {
//    private final PersonDAO personDAO;
//    private final PersonValidator personValidator;
//
//    @Autowired
//    public PersonController(PersonDAO personDAO, PersonValidator personValidator) {
//        this.personDAO = personDAO;
//        this.personValidator = personValidator;
//    }
//
//    @GetMapping()
//    public String getAll(Model model) {
//        model.addAttribute("fullPeople", personDAO.getAll());
//
//        return "people/fullPeople";
//    }
//
//    @GetMapping("/{id}")
//    public String getById(@PathVariable("id") int id, Model model) {
//        model.addAttribute("person", personDAO.getById(id));
//        model.addAttribute("books",  personDAO.getBookByPersonId(id));
//
//        return "people/show";
//    }
//
//    @GetMapping("/new")
//    public String add(@ModelAttribute("person") PersonDto person) {
//        return "people/new";
//    }
//
//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String create(@Valid @ModelAttribute("person") PersonDto person, BindingResult bindingResult) throws IOException {
//        personValidator.validate(person, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "people/new";
//        }
//
//        personDAO.save(person);
//
//        return "redirect:/people";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable("id") int id, Model model) {
//        model.addAttribute("peopleEdit", personDAO.getById(id));
//
//        return "people/edit";
//    }
//
//    @PostMapping("/{id}")
//    public String update(@PathVariable("id") int id, @ModelAttribute("person") @Valid PersonDto person,
//                               BindingResult bindingResult) throws IOException {
//        if (bindingResult.hasErrors()) {
//            return "people/edit";
//        }
//
//        personDAO.update(id, person);
//
//        return "redirect:/people";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        personDAO.delete(id);
//
//        return "redirect:/people";
//    }
//}

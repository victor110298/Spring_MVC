package com.mateacademy.springmvc.controller;

import com.mateacademy.springmvc.entity.User;
import com.mateacademy.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service){
        this.service=service;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<User> listStudents = service.getAllUsers();
        model.addAttribute("listStudents", listStudents);
        return "index";
    }

    @PostMapping("/new")
    public String createNewUser(@Valid Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        service.saveUser(user);
        return "redirect:/";
    }

    @PutMapping("/edit/{id}")
    public ModelAndView editStudentForm(@Valid @PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_user");
        User user = service.getUserById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        service.deleteUser(id);
        return "redirect:/";
    }
}

package com.mateacademy.springmvc.controller;

import com.mateacademy.springmvc.entity.User;
import com.mateacademy.springmvc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<User> users = service.getAllUsers();
        model.addAttribute("users", users);
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
    public ModelAndView editUsersForm(@Valid @PathVariable(name = "id") Long id) throws Throwable {
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

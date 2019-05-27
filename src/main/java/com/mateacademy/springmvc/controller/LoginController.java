package com.mateacademy.springmvc.controller;
import com.mateacademy.springmvc.entity.User;
import com.mateacademy.springmvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {
    private static final String SUCCESS_MESSAGE = "User has been registered successfully";
    private static final String ERROR_MESSAGE = "There is already a user registered with the name";

    private final UserService userService;

    @GetMapping(value = {"/login"})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user)
                .setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView createNewUser(@NotNull User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findByUserName(user.getName());
        if (Objects.nonNull(userExists)) {
            bindingResult.rejectValue("userName", "error.user", ERROR_MESSAGE);
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.createUser(user);
            modelAndView.addObject("successMessage", SUCCESS_MESSAGE)
                    .addObject("user", new User())
                    .setViewName("registration");
        }
        return modelAndView;
    }
}

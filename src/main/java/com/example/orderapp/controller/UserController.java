package com.example.orderapp.controller;

import com.example.orderapp.model.UserAddDTO;
import com.example.orderapp.service.UserService;
import com.example.orderapp.validator.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final RegisterValidator registerValidator;


    @Autowired
    public UserController(UserService userService, RegisterValidator registerValidator) {
        this.userService = userService;
        this.registerValidator = registerValidator;
    }

    /**@InitBinder()
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(registerValidator);
    }*/

    @RequestMapping("/register")
    public ModelAndView getRegisterPage() {

        return new ModelAndView("register", "userForm", new UserAddDTO());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleRegisterForm(@Valid @ModelAttribute("userForm") UserAddDTO form, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "register";
        userService.addUser(form);
        return "redirect:/users";
    }

    @RequestMapping("/users")
    public ModelAndView getUsersPage() {

        return new ModelAndView("users", "users", userService.getUsers());
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String handleItemDelete(@PathVariable Long id) {
        userService.deleteItemById(id);
        return "redirect:/users";
    }
}

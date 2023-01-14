package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.ServiceUser;

@Controller
public class UserController {

    private final ServiceUser serviceUser;

    @Autowired
    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping(value = "/")
    public String allUsers(Model model) {
        model.addAttribute("allUsers", serviceUser.allUsers());
        return "users";
    }

    @GetMapping(value = "/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        serviceUser.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/user-update/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = serviceUser.findById(id).get();
        model.addAttribute("user", new User(id, user.getName(), user.getSurname()));
        return "user-update";
    }

    @PostMapping(value = "/user-update")
    public String getEditUser(User user) {
        serviceUser.updateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/user-create")
    public String getCreateUser(User user) {
        return "user-create";
    }

    @PostMapping(value = "/user-create")
    public String createUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        serviceUser.createUser(user);
        return "redirect:/";
    }
}
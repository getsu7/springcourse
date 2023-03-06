package com.destin.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;

@Controller
public class WebController {

    private final ArrayList<User> userList = new ArrayList<>();

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping(value = "/index")
    public String userFormSubmit(@ModelAttribute User user, Model model) {
        for (User cursor : userList) {
            if (user.getEmail().equals(cursor.getEmail())){
                model.addAttribute("message", "This email is already used");
                return "index";
            }
            if (user.getUsername().equals(cursor.getUsername())){
                model.addAttribute("message", "This username is already used");
                return "index";
            }
        }
        user.setId(userList.size());
        userList.add(user);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("userList", userList);
        return "result";
    }
}


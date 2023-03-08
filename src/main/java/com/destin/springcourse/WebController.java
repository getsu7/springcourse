package com.destin.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class WebController {

    private ArrayList<User> userList = new ArrayList<>();

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping(value = "/index")
    public String userFormSubmit(@ModelAttribute User user, Model model) throws IOException {
        System.out.println(user);
        if (UserVerification.userFormVerification(user, userList, model)){
            user.setId(userList.size());
            userList.add(user);
            return "result";
        }
        return "index";
    }

    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("userList", userList);
        return "result";
    }
}


package com.destin.springcourse;

import org.springframework.ui.Model;

import java.io.IOException;
import java.util.ArrayList;

public class UserVerification {

    public static boolean userFormVerification(User user, ArrayList<User> userList, Model model) throws IOException {

        System.out.println("userList1");

        if(RequestManager.mailValidityVerification(user.getEmail())) {
            for (User cursor : userList) {
                if (user.getEmail().equals(cursor.getEmail())) {
                    model.addAttribute("message", "This email is already used");
                    System.out.println("userList2");

                    return false;
                }
                if (user.getUsername().equals(cursor.getUsername())) {
                    model.addAttribute("message", "This username is already used");
                    System.out.println("3");

                    return false;
                }
            }
            return true;
        }
        model.addAttribute("message", "This email is invalid");
        System.out.println("5");

        return false;
    }
}

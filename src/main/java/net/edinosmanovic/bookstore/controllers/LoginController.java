package net.edinosmanovic.bookstore.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Created by eo on 6/7/17.
 */

@Controller
public class LoginController {


    @RequestMapping(value="login", method = RequestMethod.GET)
    public String showLogin(Model model, @PathVariable int bookId) {


        model.addAttribute("naslov", "Sign in");
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String verifyLoginForm(){


        return "redirect:/books";
    }
}




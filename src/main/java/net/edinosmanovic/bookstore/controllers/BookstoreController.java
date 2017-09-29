package net.edinosmanovic.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by eo on 6/2/17.
 */
@Controller
//@RequestMapping(value = "welcome")
public class BookstoreController {
    //root url path
    @RequestMapping(value = "hi")
    @ResponseBody
    public String indeks(HttpServletRequest request){

        String name = request.getParameter("name");
        if (name == null){
            name = "";
        }
        return "Welcome to our bookstore "+ name +" !";
    }
    //welcome method that GETs form
    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    @ResponseBody
    public String welcomeForm(){
        String html = " <form method='post' action = 'welcome'>"+
                "<input type = 'text' name = 'name'>"+
                "<input type = 'submit' value='Submit'/>"+
                "</form>";
        return html;
    }
    //welcome method that processes form
    @RequestMapping(value="welcome", method = RequestMethod.POST)
    @ResponseBody
    public String welcomePost(HttpServletRequest request){
        String name = request.getParameter("name");
        return "Welcome "+name +" !";
    }
    //adding a name in url
    @RequestMapping(value = "welcome/{name}")
    @ResponseBody
    public String welcomeUrl(@PathVariable String name){
        return "Welcome "+name;
    }
    //redirecting to root url path
    @RequestMapping(value = "goodbye")
    public String bye(){
        return "redirect:hi/";

    }
}

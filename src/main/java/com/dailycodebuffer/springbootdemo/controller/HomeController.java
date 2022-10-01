package com.dailycodebuffer.springbootdemo.controller;

import com.dailycodebuffer.springbootdemo.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * The Controller class for this project
 * Defines this class as the main communicator with
 * the Tomcat server through Json data
 */
@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Hello World";
    }

    //@RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setId("1");
        user.setName("Andrew");
        user.setEmailId("asoto24@gmu.edu");

        return user;
    }

    @GetMapping("/{id}/{id2}")
    public String pathVariable(@PathVariable String id, @PathVariable("id2") String name){
        return "The path Variable is: " + id + " : " + name;
    }

    @GetMapping("/requestParam")
    public String requestParams(@RequestParam String name, @RequestParam(required = false) String emailId){
        if(emailId == null) return "your name is: " + name;
        return "Your name is : " + name + " email ID: " + emailId;
    }
}

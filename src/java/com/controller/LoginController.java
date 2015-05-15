/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;

import com.service.UserService;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vladimir
 */

@Controller
@RequestMapping(value="/login", method=RequestMethod.POST)
public class LoginController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/verify", method=RequestMethod.POST)
    public String verify(
        @RequestParam(value = "username", required = true) String username,
        @RequestParam(value = "password", required = true) String password,
        Model model
    ) throws SQLException   
    {
        boolean valid = userService.isValidUser(username, password);        
        String message = valid? "Welcome " + username : "Invalid log-in";
        model.addAttribute("message",message);
        return "welcome";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model)
    {
         model.addAttribute("message", "hello world");
         return "login";
    }
}

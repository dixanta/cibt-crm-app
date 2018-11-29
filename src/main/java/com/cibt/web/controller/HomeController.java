/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.controller;

import com.cibt.web.entity.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping(value="/")
public class HomeController {
    
    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    @GetMapping("/contact")
    public String contact(){
        return "contact/index";
    }
    
    @PostMapping("/contact")
    @ResponseBody
    public String contactPost(@ModelAttribute(value = "contact")
        Contact contact){
        return contact.toString();
    }
}

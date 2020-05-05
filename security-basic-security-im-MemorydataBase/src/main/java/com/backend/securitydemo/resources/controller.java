package com.backend.securitydemo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
   // un authenticated home page
    @RequestMapping("/")
    public String homeEndboint(){
        return  new String("<h1>WELCOME HOME</h1>");
    }
  // user pages
    @RequestMapping("/user")
    public String profileEndboint(){
        return  new String("<h1>WELCOME USER AREA !!!!!!!!</h1>");
    }
   // admin pages
    @RequestMapping("/setting")
    public String settingEndboint(){
        return  new String("<h1>WELCOME SETTING EREA !!!!</h1>");
    }

    @RequestMapping("/admin")
    public String adminEndboint(){
        return  new String("<h1>WELCOME ADMIN AREA !!!!</h1>");
    }

}

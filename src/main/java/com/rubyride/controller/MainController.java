package com.rubyride.controller;

import com.rubyride.services.CsvService;
import com.rubyride.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Aman Mahato
 */

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private CsvService csvService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping
    public String home(){
       return "test";
    }


}

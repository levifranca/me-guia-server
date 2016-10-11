package edu.metrocamp.meguia.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String root() {
    	
        return "Greetings from Me Guia API!";
    }

    @RequestMapping(path="/index", method = RequestMethod.GET)
    public String index() {
    	
        return "INDEX";
    }
}
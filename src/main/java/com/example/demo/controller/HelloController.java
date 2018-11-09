package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/aplikacja")
public class HelloController {
    //    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//wskazanie strony oraz danej metody(get, post, delete..);
    @GetMapping("/hello")
    @ResponseBody
    //nie trzeba okreslac metody tylko sam adres
    public void hello() {
        System.out.println("Wykonanie metody hello");
    }

    @GetMapping("/example")
    @ResponseBody
    public void example() {
        System.out.println("Metoda example");
    }


}

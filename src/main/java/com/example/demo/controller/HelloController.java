package com.example.demo.controller;

import com.example.demo.service.RandomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/aplikacja")
public class HelloController {

    private RandomService randomService;

    public HelloController(RandomService randomService) {
        this.randomService = randomService;
    }


    //    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//wskazanie strony oraz danej metody(get, post, delete..);


    @GetMapping("/hello")
    @ResponseBody
    //nie trzeba okreslac metody tylko sam adres
    public String hello() {
        System.out.println("Wykonanie metody hello");
        return "Wykonanie metody hello" + " " + randomService.getSmallInt();
    }

    @GetMapping("/example")
    @ResponseBody
    public String example() {
        System.out.println("Metoda example");
        return "Metoda example";
    }


}

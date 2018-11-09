package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomNumberController {

    @GetMapping("/small")
    @ResponseBody
    public String smallRandom() {
        int smallInt = new Random().nextInt(100);
        return "Losowa liczba " + smallInt;
    }

    @GetMapping("/big")
    @ResponseBody
    public String bigRandom() {
        int bitInt = new Random().nextInt(100000);
        return "Duża losowa liczba " + bitInt;
    }
}

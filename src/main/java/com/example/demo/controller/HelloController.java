package com.example.demo.controller;

import com.example.demo.service.RandomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@Controller
//@RequestMapping("/aplikacja")
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

    @GetMapping("/form")
    public String showForm() {
        //obliczenia wyswietlenia formularza
        return "formularz.html";
    }

    @GetMapping("/info")
    @ResponseBody
    public void showInfo(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            System.out.println(name + ": " + header);
        }
    }
   // @ResponseBody
    @GetMapping("/login")
    public String getInfo(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if("abc".equals(name) && "xyz".equals(password))
            return "redirect:success.html";
        else
            return "redirect:error.html";
    }

}


//
//            Enumeration<String> headerNames = request.getHeaderNames();
//            String ip = request.getLocalAddr();
//            return "Cześć tu Damian. Wszystko działa" + ip;


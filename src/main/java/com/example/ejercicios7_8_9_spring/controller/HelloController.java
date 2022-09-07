package com.example.ejercicios7_8_9_spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Value("${app.message}")
    String message;

        @GetMapping("/holalaptop")
        public String holaMundo(){

            System.out.println(message);
            return "Hola mundo desde laptop";
        }


}

package com.example.ejercicios7_8_9_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

        @GetMapping("/holalaptop")
        public String holaMundo(){
            return "Hola mundo desde laptop";
        }
}

package com.exercicio2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetivo")
public class HelloControllers {
    @GetMapping
    public String objetivosSemana(){
        return "Meus objetivos de aprendizagem para" +
                " esta semana é aprender mais sobre spring boot ,\n redes de computadores e " +
                "testes de software...";
    }
}

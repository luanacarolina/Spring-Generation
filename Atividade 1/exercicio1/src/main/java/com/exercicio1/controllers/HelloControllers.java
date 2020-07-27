package com.exercicio1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidade")
public class HelloControllers {
    @GetMapping
    public String habilidades(){
        return "Habilidades: Persistência,Atenção aos detalhes,Proatividade!!!";
    }
}

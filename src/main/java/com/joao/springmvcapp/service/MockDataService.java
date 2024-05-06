package com.joao.springmvcapp.service;

import org.springframework.stereotype.Component;

@Component
public class MockDataService {

    private final String[] cursos = {
        "BTI", "EngSoft", "EngComp", "CienComp"
    };
    private final String[] sistemasOperacionais = {
        "OSX", "Windows", "Linux"
    };
    private final String[] Linguagem = { 
        "Java", "C", "Python","Javascript"
    };
    public String[] getCursos() {
        return cursos;
    }
    public String[] getSistemasOperacionais() {
        return sistemasOperacionais;
    }
    public String[] getLinguagem() {
        return Linguagem;
    }
    
}

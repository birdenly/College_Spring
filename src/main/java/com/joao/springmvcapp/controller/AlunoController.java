package com.joao.springmvcapp.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joao.springmvcapp.model.Aluno;
import com.joao.springmvcapp.service.AlunoService;
import com.joao.springmvcapp.service.MockDataService;


@Controller
@RequestMapping("/aluno")
public class AlunoController {


    @Autowired
    @Qualifier("alunoServiceImpl")
    AlunoService alunoService;

    @Autowired
    MockDataService mockDataService;


    @RequestMapping("/showForm")
    public String showFormAluno(Model model){

        model.addAttribute("aluno", new Aluno());
        model.addAttribute("cursos", mockDataService.getCursos());
        model.addAttribute("sistemasOperacionais", mockDataService.getSistemasOperacionais());

        return "aluno/formAluno";
    }

    @RequestMapping("/addAluno")
    public String showFormAluno(@ModelAttribute("aluno") Aluno aluno,  Model model){
 
        alunoService.salvarAluno(aluno);
        model.addAttribute("aluno", aluno);
        model.addAttribute("cursos", mockDataService.getCursos());
        model.addAttribute("linguagem", mockDataService.getLinguagem());
        model.addAttribute("sistemasOperacionais", mockDataService.getSistemasOperacionais());
        
        return "aluno/paginaAluno";
    }

    @RequestMapping("/getListaAlunos")
    public String showListaAluno(Model model){

        List<Aluno> alunos = alunoService.getListaAluno();
        model.addAttribute("alunos",alunos);
        return "aluno/listaAlunos";

    }

    @RequestMapping("/getListaAlunosCurso")
    public String showListaAlunoCurso(@ModelAttribute("curso") String curso,Model model){

        List<Aluno> alunos = alunoService.getListaAlunoCurso(curso);
        model.addAttribute("alunos",alunos);
        return "aluno/listaAlunos";
    }

    @RequestMapping("/getListaAlunosLinguagem")
    public String showListaAlunoLinguagem(@ModelAttribute("linguagem") String linguagem,Model model){

        List<Aluno> alunos = alunoService.getListaAlunosLinguagem(linguagem);
        model.addAttribute("alunos",alunos);
        return "aluno/listaAlunos";
    }

    @RequestMapping("/getListaAlunosSistema")
    public String showListaAlunosSistema(@ModelAttribute("sistemasOperacionas") String sistema,Model model){

        List<Aluno> alunos = alunoService.getListaAlunosSistema(sistema);
        model.addAttribute("alunos",alunos);
        return "aluno/listaAlunos";
    }


    
    
}

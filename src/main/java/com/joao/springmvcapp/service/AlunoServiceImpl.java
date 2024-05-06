package com.joao.springmvcapp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.joao.springmvcapp.model.Aluno;

@Component
public class AlunoServiceImpl implements  AlunoService{

    public List<Aluno> alunos = new ArrayList<Aluno>();  

    @Override
    public void salvarAluno(Aluno aluno) {
        System.out.println(aluno.toString());
        try{
            this.alunos.add(aluno);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
        
        
    }

    @Override
    public void deletarAluno(Aluno aluno) {
       this.alunos.remove(aluno);
    }

    @Override
    public Aluno getAlunoById(Integer id) {
        for (Aluno aluno : alunos) {
            if(aluno.getId() == id){
                return aluno;
            }
        }
        return null;
    }

    @Override
    public List<Aluno> getListaAluno() {
        return this.alunos;
    }

    @Override
    public List<Aluno> getListaAlunoCurso(String curso) {
        
        List<Aluno> alunosCurso = new ArrayList<Aluno>(); 
        try {
            for (Aluno aluno : alunos) {
                if(aluno.getCurso().equals(curso)){
                    alunosCurso.add(aluno);
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        

        return alunosCurso;
    }

    @Override
    public List<Aluno> getListaAlunosLinguagem(String linguagem) {
        
        List<Aluno> alunosLinguagem = new ArrayList<Aluno>(); 
        try {
            for (Aluno aluno : alunos) {
                if(aluno.getLinguagem().equals(linguagem)){
                    alunosLinguagem.add(aluno);
                }
            } 
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        return alunosLinguagem;
    }

    @Override
    public List<Aluno> getListaAlunosSistema(String sistema) {
        
        List<Aluno>  alunosSistema= new ArrayList<Aluno>(); 
        try {
            for (Aluno aluno : alunos) {
                if(aluno.getSistemasOperacionas().contains(sistema)){
                    alunosSistema.add(aluno);
                }
            } 
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return alunosSistema;
    }
    
}

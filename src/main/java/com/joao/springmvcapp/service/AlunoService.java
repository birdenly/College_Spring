package com.joao.springmvcapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joao.springmvcapp.model.Aluno;

@Service
public interface AlunoService {

    public void salvarAluno(Aluno aluno);
    public void deletarAluno(Aluno aluno);
    public Aluno getAlunoById(Integer id);
    public List<Aluno> getListaAluno();  
    public List<Aluno> getListaAlunoCurso(String curso);
    public List<Aluno> getListaAlunosLinguagem(String linguagem);
    public List<Aluno> getListaAlunosSistema(String sistema);

}

package com.turma.controllers;

import com.turma.models.Aluno;
import com.turma.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        return ResponseEntity.ok(alunoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable long id){
        return alunoRepository.findById(id)
                .map(resp ->ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aluno> post(@RequestBody  Aluno aluno ){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));
    }

    @PutMapping
    public ResponseEntity<Aluno> put(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(aluno));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        alunoRepository.deleteById(id);
    }
}

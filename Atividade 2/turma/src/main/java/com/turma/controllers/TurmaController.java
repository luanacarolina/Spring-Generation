package com.turma.controllers;

import com.turma.models.TurmaModel;
import com.turma.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @GetMapping
    public ResponseEntity<List<TurmaModel>> findAllTurma(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaModel> findById(@PathVariable  long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TurmaModel> post(@RequestBody TurmaModel turma){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));
    }

    @PutMapping
    public ResponseEntity<TurmaModel> put(@RequestBody TurmaModel turma){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(turma));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }

}

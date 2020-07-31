package com.turma.controllers;

import com.turma.models.Turma;
import com.turma.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TurmaController {
    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping
    public ResponseEntity<List<Turma>> getAll(){
        return ResponseEntity.ok(turmaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getById(@PathVariable long id){
        return turmaRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Turma> post(@RequestBody Turma turma) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaRepository.save(turma));
    }
    @PutMapping
    public ResponseEntity<Turma> put(@RequestBody Turma turma){
        return ResponseEntity.status(HttpStatus.OK).body(turmaRepository.save(turma));
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        turmaRepository.deleteById(id);
    }

}

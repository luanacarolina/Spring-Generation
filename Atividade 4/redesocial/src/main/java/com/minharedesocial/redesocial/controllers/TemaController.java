package com.minharedesocial.redesocial.controllers;

import com.minharedesocial.redesocial.models.Tema;
import com.minharedesocial.redesocial.repositories.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController {
    @Autowired
    private TemaRepository temaRepository;

    @GetMapping
    public ResponseEntity<List<Tema>> getAll(){
        return ResponseEntity.ok(temaRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable long id){
        return temaRepository.findById(id)
                .map(resp->ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Tema>> getByDescription(@PathVariable String descricao){
        return ResponseEntity.ok(temaRepository.findAllByDescricaoContainsIgnoreCase(descricao));
    }
    @PostMapping
    public ResponseEntity<Tema> post(@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
    }
    @PutMapping
    public ResponseEntity<Tema> put (@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        temaRepository.deleteById(id);
    }

}

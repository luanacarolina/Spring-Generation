package com.minharedesocial.redesocial.controllers;

import com.minharedesocial.redesocial.models.Postagem;
import com.minharedesocial.redesocial.repositories.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll(){
        return  ResponseEntity.ok(postagemRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable long id){
        return postagemRepository.findById(id)
                .map(resp->ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Postagem>> getByDescription(@PathVariable String descricao){
        return ResponseEntity.ok(postagemRepository.findAllByDescricaoContainsIgnoreCase(descricao));
    }

    @PostMapping
    public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
    }
    @PutMapping
    public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        postagemRepository.deleteById(id);
    }
}

package com.farmacia10.controllers;

import com.farmacia10.models.Produtos;
import com.farmacia10.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController  {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produtos>> getAll(){
        return ResponseEntity.ok(produtoRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produtos> getById(@PathVariable long id){
        return produtoRepository.findById(id)
                .map(resp->ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Produtos> post(@RequestBody Produtos produtos){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtos));
    }
    @PutMapping
    public ResponseEntity<Produtos> put(@RequestBody Produtos produtos){
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produtos));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        produtoRepository.deleteById(id);
    }
}

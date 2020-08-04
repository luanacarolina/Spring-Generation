package com.minharedesocial.redesocial.controllers;

import com.minharedesocial.redesocial.models.Usuario;
import com.minharedesocial.redesocial.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable long id){
        return usuarioRepository.findById(id)
                .map(resp->ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Usuario>> getByName(@PathVariable String nome){
        return ResponseEntity.ok(usuarioRepository.findAllByNomeContainsIgnoreCase(nome));
    }
    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }
    @PutMapping
    public ResponseEntity<Usuario> put(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        usuarioRepository.deleteById(id);
    }
}

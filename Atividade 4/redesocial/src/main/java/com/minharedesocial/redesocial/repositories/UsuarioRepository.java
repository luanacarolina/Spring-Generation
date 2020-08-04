package com.minharedesocial.redesocial.repositories;

import com.minharedesocial.redesocial.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public List<Usuario> findAllByNomeContainsIgnoreCase(String nome);
}

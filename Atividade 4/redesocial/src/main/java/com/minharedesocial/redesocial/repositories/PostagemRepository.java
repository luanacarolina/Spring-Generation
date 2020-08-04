package com.minharedesocial.redesocial.repositories;

import com.minharedesocial.redesocial.models.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long> {
 public List<Postagem> findAllByDescricaoContainsIgnoreCase(String descricao);
}

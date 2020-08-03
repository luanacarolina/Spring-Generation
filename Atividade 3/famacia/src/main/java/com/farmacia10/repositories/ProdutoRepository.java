package com.farmacia10.repositories;

import com.farmacia10.models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produtos,Long> {
}

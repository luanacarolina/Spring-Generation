package com.turma.repositories;

import com.turma.models.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel,Long> {

}

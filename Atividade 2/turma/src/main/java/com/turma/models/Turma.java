package com.turma.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min=5,max = 100)
    private String turma;

    @NotNull
    private boolean ativo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

package com.thom.cinetrack.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Avaliacao
{
    private Usuario usuario;
    private Filme filme;
    private double nota;
    private String resenha;

    public Avaliacao(Usuario usuario, Filme filme, double nota, String resenha)
    {
        this.usuario = usuario;
        this.filme = filme;
        this.nota = nota;
        this.resenha = resenha;
    }
    
    @Override
    public String toString()
    {
        return "Filme: " + filme.getTitulo() +
               "\nNota: " + nota +
               "\nNota: " + resenha +
               "\n------------------------------";
    }
}

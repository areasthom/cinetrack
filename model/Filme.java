package com.thom.cinetrack.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filme
{
    private String titulo;
    private String genero;
    private int ano;

    public Filme(String titulo, String genero, int ano)
    {
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
    }
    
    @Override
    public String toString()
    {
        return "-------------------" +
               "\nTitulo: " + titulo +
               "\nGenero: " + genero +
               "\nAno: " + ano +
               "\n--------------------"; 
    }
}

package com.thom.cinetrack.model;

import com.thom.cinetrack.model.Filme;
import java.util.ArrayList;
import java.util.Comparator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario
{
    private String nome;
    private ArrayList<Avaliacao> avaliacoes;

    public Usuario(String nome)
    {
        this.nome = nome;
        this.avaliacoes = new ArrayList<>();
    }
    
    public void adicionarAvaliacao(Avaliacao avaliacao)
    {
        avaliacoes.add(avaliacao);
    }
    
    public void mostrarAvaliacoes()
    {
        if(avaliacoes.isEmpty())
        {
            System.out.println("Nenhuma avaliação ainda ");
        }
        else
        {
            for(Avaliacao a : avaliacoes)
            {
                System.out.println(a);
            }
        }
    }
    
    public int quantidadeDeFilmes()
    {
        return avaliacoes.size();
    }
    
    public String calcularNivel()
    {
        int quantidade = avaliacoes.size();
        
        if(quantidade >= 50)
        {
            return "Mestre do Cinema";
        }
        else if(quantidade >= 20)
        {
            return "Cinéfilo";
        }
        else if(quantidade >= 5)
        {
            return "Explorador de Filmes";
        }
        else
        {
            return "Iniciante";
        }        
    }
    
    public double calcularNotaMedia()
    {
        if(avaliacoes.isEmpty()) return 0;
        
        double soma = 0;
        
        for(Avaliacao a : avaliacoes)
        {
            soma+= a.getNota();
        }
        
        return soma / avaliacoes.size();
    }
    
    public void mostrarTop3Filmes()
    {
        if(avaliacoes.isEmpty())
        {
            System.out.println("Nenhuma avaliação cadastrada.");
        }
        
        ArrayList<Avaliacao> copia = new ArrayList<>(avaliacoes);
        
        copia.sort(Comparator.comparing(Avaliacao::getNota).reversed());
        
        System.out.println("\n=== TOP 3 FILMES ===");
        
        int limite = Math.min(3, copia.size());
        
        for (int i = 0; i < limite; i++)
        {
            Avaliacao a = copia.get(i);
            System.out.println((i + 1) + " - " + a.getFilme().getTitulo() + " (" + a.getNota() + ")");
        }
    }
    
}

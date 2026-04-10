package com.thom.cinetrack.service;

import com.thom.cinetrack.model.Avaliacao;
import com.thom.cinetrack.model.Usuario;
import com.thom.cinetrack.model.Filme;
import java.util.ArrayList;

public class SistemaCineTrack
{
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioAtual;

    public ArrayList<Usuario> getUsuarios()
    {
        return usuarios;
    }
    
    public Usuario getUsuarioAtual()
    {
        return usuarioAtual;
    }

    public void setUsuarioAtual(Usuario usuarioAtual)
    {
        this.usuarioAtual = usuarioAtual;
    }

    public SistemaCineTrack()
    {
        usuarios = new ArrayList<>();
    }
    
    public void criarUsuario(String nome)
    {
        Usuario novoUsuario = new Usuario(nome);
        usuarios.add(novoUsuario);
        
        System.out.println("Usuário " + nome + " criado com sucesso!");
    }
    
    public void mostrarUsuarios()
    {
        if(usuarios.isEmpty())
        {
            System.out.println("Ainda não existem usuários cadastrados. ");
            return;
        }
        else
        {
            for (int i = 0; i < usuarios.size(); i++)
            {
                Usuario u = usuarios.get(i);
                System.out.println((i + 1) + " - " + u.getNome());
            }
        }
    }
    
    public void selecionarUsuario(int indice)
    {
        if(indice < 1 || indice > usuarios.size())
        {
            System.out.println("Usuário inválido. ");
            return;
        }
        
        usuarioAtual = usuarios.get(indice - 1);        
        System.out.println("Usuário selecionado: " + usuarioAtual.getNome());        
    }
    
    public void adicionarAvaliacao(String titulo, String genero, int ano, String resenha, double nota)
    {
        if(usuarioAtual == null)
        {
            System.out.println("Selecione um usuario primeiro");
            return;
        }
        
        Filme filme = new Filme(titulo, genero, ano);
        Avaliacao avaliacao = new Avaliacao(usuarioAtual, filme, nota, resenha);
        
        usuarioAtual.adicionarAvaliacao(avaliacao);
        
        System.out.println("Avaliação adicionada com sucesso! ");        
                
    }
    
    public void mostrarResumoUsuario()
    {
        if(usuarioAtual == null)
        {
            System.out.println("Selecione um usuário primeiro. ");
            return;
        }
        
        System.out.println("Usuario: " + usuarioAtual.getNome());
        
        usuarioAtual.mostrarAvaliacoes();
        
        System.out.println("Nivel: " + usuarioAtual.calcularNivel());
        System.out.println("Nota média: " + usuarioAtual.calcularNotaMedia());
        
        usuarioAtual.mostrarTop3Filmes();
    }
        
}

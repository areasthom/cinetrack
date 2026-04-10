package com.thom.cinetrack.app;

import com.thom.cinetrack.service.SistemaCineTrack;
import com.thom.cinetrack.model.Usuario;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        SistemaCineTrack sistema = new SistemaCineTrack();
        
        int opcao;
        
        do
        {
            System.out.println("\n=== CINE TRACK ===");
            System.out.println("1 - Criar usuario");
            System.out.println("2 - Listar usuarios");
            System.out.println("3 - Selecionar usuario");
            System.out.println("4 - Adicionar filme");
            System.out.println("5 - Ver filmes do usuario");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            
            opcao = teclado.nextInt();
            teclado.nextLine();
            
            if(opcao == 1)
            {
                System.out.println("Digite o nome do seu usuário: ");
                String nome = teclado.nextLine();
                sistema.criarUsuario(nome);
            }
            else if(opcao == 2)
            {
                sistema.mostrarUsuarios();
            }
            else if(opcao == 3)
            {
                if(sistema.getUsuarios().isEmpty())
                {
                    System.out.println("Ainda não existem usuários cadastrados. ");   
                }
                else
                {
                    for (int i = 0; i < sistema.getUsuarios().size(); i++)
                    {
                        Usuario u = sistema.getUsuarios().get(i);
                        System.out.println((i + 1) + " - " + u.getNome());
                    }
                    
                    System.out.println("Digite o número do usuário: ");
                    int indice = teclado.nextInt();
                    sistema.selecionarUsuario(indice);
                }
            }
            else if(opcao == 4)
            {
                if(sistema.getUsuarioAtual() == null)
                {
                    System.out.println("Selecione um usuário primeiro. ");   
                }
                else
                {
                    System.out.println("Titulo: ");
                    String titulo = teclado.nextLine();
                    
                    System.out.println("Genero: ");
                    String genero = teclado.nextLine();
                    
                    System.out.println("Ano: ");
                    int ano = teclado.nextInt();
                    teclado.nextLine();
                    
                    System.out.println("Resenha: ");
                    String resenha = teclado.nextLine();
                    
                    double nota;                    
                    do
                    {                        
                        System.out.println("Nota (0 a 10): ");
                        nota = teclado.nextDouble();
                        teclado.nextLine();

                        if(nota < 0 || nota > 10)
                        {
                            System.out.println("Valor inválido! Digite uma nota entre 0 e 10.");
                        }
                        
                    } while (nota < 0 || nota > 10);
                    
                    sistema.adicionarAvaliacao(titulo, genero, ano, resenha, nota);
                }
            }
            else if(opcao == 5)
            {
                sistema.mostrarResumoUsuario();
            }
            else if(opcao == 0)
            {
                System.out.println("Até a próxima!");
                break;
            }
            else
            {
                System.out.println("Opção não encontrada. Tente novamente");
            }
            
        } while (opcao != 0);
        teclado.close();
    }
}

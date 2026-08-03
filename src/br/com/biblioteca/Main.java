package br.com.biblioteca;

import br.com.biblioteca.model.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<ItemBiblioteca> acervos = new ArrayList<>();
        List<User> usuarios = new ArrayList<>();
        List<Emprestimo> emprestimos = new ArrayList<>();

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=================================");
            System.out.println("     SISTEMA DE BIBLIOTECA       ");
            System.out.println("=================================");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Revista");
            System.out.println("3. Cadastrar Usuário");
            System.out.println("4. Realizar Empréstimo");
            System.out.println("5. Devolver Item");
            System.out.println("6. Listar Acervo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("\n---CADASTRO DE LIVROS---");

                    System.out.println("Digite o ID do livro: ");
                    int idLivro = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite o nome do livro: ");
                    String nomeLivro = sc.nextLine();
                    System.out.println("Digite o nome do Autor: ");
                    String autorLivro = sc.nextLine();
                    System.out.println("Digite o Nº de Paginas: ");
                    int numeroPaginasLivro = sc.nextInt();
                    sc.nextLine();

                    Livro novoLivro = new Livro(idLivro, nomeLivro, autorLivro, numeroPaginasLivro);
                    acervos.add(novoLivro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("\n---CADASTRO DE REVISTA---");

                    System.out.println("Digite o ID da Revista: ");
                    int idRevista = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome do Revista: ");
                    String nomeRevista = sc.nextLine();
                    System.out.println("Digite o Nº do Edição: ");
                    int numeroEdicao = sc.nextInt();
                    sc.nextLine();

                    Revista novaRevista = new Revista(idRevista, nomeRevista, numeroEdicao);
                    acervos.add(novaRevista);
                    System.out.println("Revista adicionada com sucesso! ");
                    break;
                case 3:
                    System.out.println("\n---CADASTRO DE USUÁRIOS---");

                    System.out.print("Digite o ID do Usuario: ");
                    int idUser = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o Nome do Usuario: ");
                    String nomeUser = sc.nextLine();
                    System.out.print("Digite o Email do Usuario: ");
                    String emailUser = sc.nextLine();

                    User novoUser = new User(idUser, nomeUser, emailUser);
                    usuarios.add(novoUser);
                    System.out.println("Usuario cadastrado com sucesso!");
                    break;
                case 4:
                    System.out.println("\n---REALIZAR EMPRÉSTIMO---");

                    System.out.println("Digite o ID do User: ");
                    int idUsuarioEmp = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite o ID do Item (Livro/Revista: ");
                    int  idItemEmp = sc.nextInt();
                    sc.nextLine();

                    User usuarioEncontrado = null;
                    for (User u : usuarios) {
                        if (u.getId() == idUsuarioEmp) {
                            usuarioEncontrado = u;
                            break;
                        }
                    }
                    ItemBiblioteca itemEncontrado = null;
                    for (ItemBiblioteca item : acervos) {
                        if (item.getId() == idItemEmp) {
                            itemEncontrado = item;
                            break;
                        }
                    }
                    if (usuarioEncontrado == null) {
                        System.out.println("Usuário não encontrado!");
                    } else if (itemEncontrado == null) {
                        System.out.println("Item não encontrado no acervo!");
                    } else if (!itemEncontrado.isDisponivel()) {
                        System.out.println("Item indisponivel no momento (Já esta emprestado");
                    } else {
                        Emprestimo novoEmprestimo = new Emprestimo(usuarioEncontrado, itemEncontrado);
                        emprestimos.add(novoEmprestimo);
                        System.out.println("Emprestimo realizado com sucesso!");
                    }
                    break;
                case 5:
                    System.out.println("\n---DEVOLVER ITEM---");

                    System.out.println("Digite o ID do Item que vai ser devolvido: ");
                    int idItemDevol = sc.nextInt();
                    sc.nextLine();

                    Emprestimo emprestimoEncontrado = null;

                    for(Emprestimo e : emprestimos){
                        if (e.getItem().getId() == idItemDevol && !e.isDevolvido()) {
                            emprestimoEncontrado = e;
                            break;
                        }
                    }
                    if (emprestimoEncontrado != null) {
                        emprestimoEncontrado.devolverItem();
                        System.out.println("Emprestimo devolvido com sucesso!");
                    } else {
                        System.out.println("Nenhum empréstimo foi encontrado para este ID!");
                    }
                    break;
                case 6:
                    System.out.println("\n---ACERVO---");

                    if (acervos.isEmpty()){
                        System.out.println("Nenhum Livro ou Revista encontrado.");
                    } else {
                        for(ItemBiblioteca item : acervos){
                            System.out.println(item);
                        }
                    }
                    break;
                case 0:
                    rodando = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}

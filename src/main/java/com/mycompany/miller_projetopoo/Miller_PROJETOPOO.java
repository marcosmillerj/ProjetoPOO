/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.miller_projetopoo;

/**
 *
 * @author marcos_miller
 */

import utils.JsonHandler;
import models.Cliente;

import java.util.List;
import java.util.Scanner;

public class Miller_PROJETOPOO {

    public static void main(String[] args) {
        // Criando um Scanner para ler entradas do usuário
        Scanner scanner = new Scanner(System.in);

        // Exibindo o menu para o usuário
        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a linha de nova linha restante

            switch (opcao) {
                case 1:
                    // Solicitar dados do cliente
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Digite o e-mail do cliente: ");
                    String email = scanner.nextLine();

                    // Criar objeto Cliente e salvar no arquivo JSON
                    Cliente cliente = new Cliente(cpf, nome, telefone, email);
                    List<Cliente> clientes = JsonHandler.carregarClientes();
                    clientes.add(cliente);
                    JsonHandler.salvarClientes(clientes);

                    System.out.println("Cliente adicionado com sucesso!");
                    break;

                case 2:
                    // Listar clientes salvos
                    List<Cliente> clientesListados = JsonHandler.carregarClientes();
                    if (clientesListados.isEmpty()) {
                        System.out.println("Nenhum cliente encontrado.");
                    } else {
                        System.out.println("Clientes cadastrados:");
                        for (Cliente c : clientesListados) {
                            System.out.println("CPF: " + c.getCpf() + ", Nome: " + c.getNome() + ", Telefone: " + c.getTelefone() + ", E-mail: " + c.getEmail());
                        }
                    }
                    break;

                case 3:
                    // Sair do programa
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}


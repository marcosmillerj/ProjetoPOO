/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miller_projetopoo;

/**
 *
 * @author marcos_miller
 */

import controller.ClienteController;
import controller.FuncionarioController;
import models.Cliente;
import models.Funcionario;
import utils.JsonHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAdmin {

    public static void main(String[] args) {
        // Carregar clientes do arquivo JSON
        List<Cliente> clientes = JsonHandler.carregarClientes();
        if (clientes == null) {
            clientes = new ArrayList<>();
        }

        // Carregar funcionários do arquivo JSON
        List<Funcionario> funcionarios = JsonHandler.carregarFuncionarios();
        if (funcionarios == null) {
            funcionarios = new ArrayList<>();
        }

        ClienteController clienteController = new ClienteController(clientes);
        FuncionarioController funcionarioController = new FuncionarioController(funcionarios);

        Scanner scanner = new Scanner(System.in);
        
        boolean sair = false;
        while (!sair) {
            System.out.println("==================================");
            System.out.println("======= Menu Administrador =======");
            System.out.println("==================================");
            System.out.println("1. GERIR Cliente");
            System.out.println("2. GERIR Funcionário");
            System.out.println("3. GERIR Reserva");
            System.out.println("4. GERIR Despesas");
            System.out.println("5. Efetuar Venda");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    submenuCliente(scanner, clienteController);
                    break;
                case 2:
                    submenuFuncionario(scanner, funcionarioController);
                    break;
                case 3:
                    // Implementar menu de Reserva
                    break;
                case 4:
                    // Implementar menu de Despesas
                    break;
                case 5:
                    // Implementar funcionalidade de venda
                    break;
                case 0:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public static void submenuCliente(Scanner scanner, ClienteController clienteController) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("==================================");
            System.out.println("\n==== Gerenciamento de Cliente ====");
            System.out.println("==================================");
            System.out.println("1. Criar Novo Cliente");
            System.out.println("2. Editar Cliente");
            System.out.println("3. Visualizar Clientes");
            System.out.println("4. Deletar Cliente");
            System.out.println("0. Voltar");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    criarCliente(scanner, clienteController);
                    break;
                case 2:
                    editarCliente(scanner, clienteController);
                    break;
                case 3:
                    visualizarClientes(clienteController);
                    break;
                case 4:
                    deletarCliente(scanner, clienteController);
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public static void submenuFuncionario(Scanner scanner, FuncionarioController funcionarioController) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("==================================");
            System.out.println("\n==== Gerenciamento de Funcionário ====");
            System.out.println("==================================");
            System.out.println("1. Criar Novo Funcionário");
            System.out.println("2. Editar Funcionário");
            System.out.println("3. Visualizar Funcionários");
            System.out.println("4. Deletar Funcionário");
            System.out.println("0. Voltar");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    criarFuncionario(scanner, funcionarioController);
                    break;
                case 2:
                    editarFuncionario(scanner, funcionarioController);
                    break;
                case 3:
                    visualizarFuncionarios(funcionarioController);
                    break;
                case 4:
                    deletarFuncionario(scanner, funcionarioController);
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public static void criarFuncionario(Scanner scanner, FuncionarioController funcionarioController) {
        System.out.println("\n==== Criar Novo Funcionário ====");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        funcionarioController.cadastrarFuncionario(nome, cpf, cargo, salario, telefone, email);
        System.out.println("Funcionário criado com sucesso.");
    }

    public static void editarFuncionario(Scanner scanner, FuncionarioController funcionarioController) {
        System.out.println("\n==== Editar Funcionário ====");
        visualizarFuncionarios(funcionarioController);

        System.out.print("Digite o CPF do funcionário a ser editado: ");
        String cpf = scanner.nextLine();

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo Cargo: ");
        String cargo = scanner.nextLine();

        System.out.print("Novo Salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        System.out.print("Novo Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Novo E-mail: ");
        String email = scanner.nextLine();

        boolean sucesso = funcionarioController.atualizarFuncionario(cpf, nome, cargo, salario, telefone, email);
        if (sucesso) {
            System.out.println("Funcionário atualizado com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public static void visualizarFuncionarios(FuncionarioController funcionarioController) {
        System.out.println("\n==== Funcionários ====");
        for (Funcionario f : funcionarioController.getFuncionarios()) {
            System.out.println(f);
        }
    }

    public static void deletarFuncionario(Scanner scanner, FuncionarioController funcionarioController) {
        System.out.println("\n==== Deletar Funcionário ====");
        visualizarFuncionarios(funcionarioController);

        System.out.print("Digite o CPF do funcionário a ser removido: ");
        String cpf = scanner.nextLine();

        boolean sucesso = funcionarioController.removerFuncionario(cpf);
        if (sucesso) {
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public static void criarCliente(Scanner scanner, ClienteController clienteController) {
        System.out.println("\n==== Criar Novo Cliente ====");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        clienteController.cadastrarCliente(nome, cpf, telefone, email);
        System.out.println("Cliente criado com sucesso.");
    }

    public static void editarCliente(Scanner scanner, ClienteController clienteController) {
        System.out.println("\n==== Editar Cliente ====");
        // Implementar edição de cliente
    }

    public static void visualizarClientes(ClienteController clienteController) {
        System.out.println("\n==== Clientes ====");
        for (Cliente c : clienteController.getClientes()) {
            System.out.println(c);
        }
    }

    public static void deletarCliente(Scanner scanner, ClienteController clienteController) {
        System.out.println("\n==== Deletar Cliente ====");
        visualizarClientes(clienteController);

        System.out.print("Digite o CPF do cliente a ser removido: ");
        String cpf = scanner.nextLine();

        boolean sucesso = clienteController.removerCliente(cpf);
        if (sucesso) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}

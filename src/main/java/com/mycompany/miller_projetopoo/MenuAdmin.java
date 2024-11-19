/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miller_projetopoo;

/**
 *
 * @author marcos_miller
 */

import java.util.Scanner;

public class MenuAdmin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        // Menu principal do administrador
        while (!sair) {
            System.out.println("==================================");
            System.out.println("=======Menu Administrador:========");
            System.out.println("==================================");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Efetuar Reserva");
            System.out.println("4. Efetuar Venda");
            System.out.println("5. Gerenciamento");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    efetuarReserva();
                    break;
                case 4:
                    efetuarVenda();
                    break;
                case 5:
                    submenuGerenciamento(scanner);
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

    // Funções do menu
    public static void cadastrarCliente() {
        System.out.println("Opção Cadastrar Cliente selecionada.");
        // Lógica para cadastrar cliente
        voltarMenu();
    }

    public static void cadastrarFuncionario() {
        System.out.println("Opção Cadastrar Funcionário selecionada.");
        // Lógica para cadastrar funcionário
        voltarMenu();
    }

    public static void efetuarReserva() {
        System.out.println("Opção Efetuar Reserva selecionada.");
        // Lógica para efetuar reserva
        voltarMenu();
    }

    public static void efetuarVenda() {
        System.out.println("Opção Efetuar Venda selecionada.");
        // Lógica para efetuar a venda
        System.out.println("Venda realizada com sucesso.");
        voltarMenu();
    }

    // Submenu de Gerenciamento
    public static void submenuGerenciamento(Scanner scanner) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\nSubmenu Gerenciamento:");
            System.out.println("1. GERIR Despesas Diárias");
            System.out.println("2. GERIR Despesas Funcionários");
            System.out.println("3. GERIR Estoque");
            System.out.println("4. GERIR Cliente");
            System.out.println("5. GERIR Funcionário");
            System.out.println("0. Voltar");

            System.out.print("Escolha uma opção: ");
            int opcaoGerenciamento = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcaoGerenciamento) {
                case 1:
                    gerenciarDespesasDiarias();
                    break;
                case 2:
                    gerenciarDespesasFuncionarios();
                    break;
                case 3:
                    gerenciarEstoque();
                    break;
                case 4:
                    gerenciarClientes();
                    break;
                case 5:
                    gerenciarFuncionarios();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    // Funções do submenu de gerenciamento
    public static void gerenciarDespesasDiarias() {
        System.out.println("Gerenciar despesas diárias.");
        voltarMenu();
    }

    public static void gerenciarDespesasFuncionarios() {
        System.out.println("Gerenciar despesas de funcionários.");
        voltarMenu();
    }

    public static void gerenciarEstoque() {
        System.out.println("Gerenciar estoque.");
        voltarMenu();
    }

    public static void gerenciarClientes() {
        System.out.println("Gerenciar clientes.");
        voltarMenu();
    }

    public static void gerenciarFuncionarios() {
        System.out.println("Gerenciar funcionários.");
        voltarMenu();
    }

    // Função de "voltar para o menu anterior"
    public static void voltarMenu() {
        System.out.println("\nPressione Enter para voltar ao menu...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();  // Espera o usuário pressionar Enter
    }
}



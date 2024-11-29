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

public class MenuFuncionario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        // Menu principal do funcionário
        while (!sair) {
            System.out.println("==================================");
            System.out.println("=========Menu Funcionário:========");
            System.out.println("==================================");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Efetuar Reserva");
            System.out.println("3. Efetuar Venda");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    agendarReserva(scanner);
                    break;
                case 3:
                    caixaVendaProduto(scanner);
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

    // Função para cadastrar cliente
    public static void cadastrarCliente(Scanner scanner) {
        System.out.println("Cadastrar Cliente");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        // Lógica de cadastro (guardar em banco de dados ou lista, dependendo da sua implementação)
        System.out.println("Cliente " + nome + " cadastrado com sucesso!");
        voltarMenu(scanner);
    }

    // Função para agendar reserva
    public static void agendarReserva(Scanner scanner) {
        System.out.println("Agendar Reserva");
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite a data da reserva (dd/mm/aaaa): ");
        String dataReserva = scanner.nextLine();
        System.out.print("Digite o horário da reserva: ");
        String horarioReserva = scanner.nextLine();
        // Lógica para agendamento (validar a data/hora e confirmar a reserva)
        System.out.println("Reserva agendada para " + nomeCliente + " em " + dataReserva + " às " + horarioReserva);
        voltarMenu(scanner);
    }

    // Função para realizar caixa (venda de produto ou mensalidade)
    public static void caixaVendaProduto(Scanner scanner) {
        System.out.println("Caixa (Venda de Produto ou Mensalidade)");
        System.out.print("Digite o valor da venda ou mensalidade: R$ ");
        double valor = scanner.nextDouble();
        System.out.print("Forma de pagamento (1 para dinheiro, 2 para cartão): ");
        int pagamento = scanner.nextInt();
        // Lógica de pagamento (registrar a transação, gerar comprovante, etc.)
        String formaPagamento = (pagamento == 1) ? "Dinheiro" : "Cartão";
        System.out.println("Pagamento de R$" + valor + " realizado com sucesso através de " + formaPagamento);
        voltarMenu(scanner);
    }

    // Função de "voltar para o menu anterior"
    public static void voltarMenu(Scanner scanner) {
        System.out.println("\nPressione Enter para voltar ao menu...");
        scanner.nextLine();  // Espera o usuário pressionar Enter
    }
}



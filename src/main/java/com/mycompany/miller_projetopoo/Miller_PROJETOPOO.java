/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.miller_projetopoo;

/**
 *
 * @author marcos_miller
 */

import java.util.Scanner;

public class Miller_PROJETOPOO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Perguntar o tipo de usuário (Admin ou Funcionário)
        System.out.println("==================================");
        System.out.println("====Escolha o tipo de usuário:====");
        System.out.println("==================================");
        System.out.println("1. Administrador");
        System.out.println("2. Funcionário");
        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt();

        // Chamar o menu correspondente
        if (opcao == 1) {
            MenuAdmin.main(args);  // Chama o menu do administrador
        } else if (opcao == 2) {
            MenuFuncionario.main(args);  // Chama o menu do funcionário
        } else {
            System.out.println("Opção inválida. Programa encerrado.");
        }
    }
}

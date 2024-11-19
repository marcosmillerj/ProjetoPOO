/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author marcos_miller
 */

import models.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaController {
    private static List<Pessoa> pessoas = new ArrayList<>(); // Armazenamento estático

    // Criar nova Pessoa
    public void cadastrarPessoa(String nome, String cpf, String telefone, String email) {
        Pessoa novaPessoa = new Pessoa(nome, cpf, telefone, email);
        pessoas.add(novaPessoa);
        System.out.println("Pessoa cadastrada com sucesso!");
    }

    // Listar todas as Pessoas
    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }

    // Editar uma Pessoa pelo CPF
    public void editarPessoa(String cpf, String novoNome, String novoTelefone, String novoEmail) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                pessoa.setNome(novoNome);
                pessoa.setTelefone(novoTelefone);
                pessoa.setEmail(novoEmail);
                System.out.println("Pessoa atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Pessoa com o CPF informado não encontrada.");
    }

    // Remover uma Pessoa pelo CPF
    public void removerPessoa(String cpf) {
        pessoas.removeIf(pessoa -> pessoa.getCpf().equals(cpf));
        System.out.println("Pessoa removida com sucesso!");
    }
}


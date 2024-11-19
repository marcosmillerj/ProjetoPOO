/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author marcos_miller
 */

import models.Instrutor;

import java.util.ArrayList;
import java.util.List;

public class InstrutorController {
    private List<Instrutor> instrutores;

    public InstrutorController() {
        this.instrutores = new ArrayList<>();
    }

    // Adicionar um novo instrutor
    public boolean adicionarInstrutor(String nome, String cpf, String telefone, String email, String especialidade) {
        if (nome == null || cpf == null || telefone == null || email == null || especialidade == null) {
            return false; // Validação básica
        }
        Instrutor novoInstrutor = new Instrutor(nome, cpf, telefone, email, especialidade);
        instrutores.add(novoInstrutor);
        return true;
    }

    // Listar todos os instrutores
    public List<Instrutor> listarInstrutores() {
        return new ArrayList<>(instrutores); // Retorna uma cópia da lista
    }

    // Buscar instrutor pelo CPF
    public Instrutor buscarInstrutorPorCpf(String cpf) {
        for (Instrutor instrutor : instrutores) {
            if (instrutor.getCpf().equals(cpf)) {
                return instrutor;
            }
        }
        return null; // Não encontrou
    }

    // Atualizar dados de um instrutor
    public boolean atualizarInstrutor(String cpf, String novoNome, String novoTelefone, String novoEmail, String novaEspecialidade) {
    Instrutor instrutor = buscarInstrutorPorCpf(cpf);
    if (instrutor != null) {
        if (novoNome != null && !novoNome.isEmpty()) {
            instrutor.setNome(novoNome);
        }
        if (novoTelefone != null && !novoTelefone.isEmpty()) {
            instrutor.setTelefone(novoTelefone);
        }
        if (novoEmail != null && !novoEmail.isEmpty()) {
            instrutor.setEmail(novoEmail);
        }
        if (novaEspecialidade != null && !novaEspecialidade.isEmpty()) {
            instrutor.setEspecialidade(novaEspecialidade);
        }
        return true;
    }
    return false; // Instrutor não encontrado
}

    // Remover um instrutor
    public boolean removerInstrutor(String cpf) {
        Instrutor instrutor = buscarInstrutorPorCpf(cpf);
        if (instrutor != null) {
            instrutores.remove(instrutor);
            return true;
        }
        return false; // Instrutor não encontrado
    }
}


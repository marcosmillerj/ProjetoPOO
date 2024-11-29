/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author marcos_miller
 */

import models.Funcionario;
import java.util.List;
import java.util.ArrayList;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    // Construtor padrão (inicializa lista vazia)
    public FuncionarioController() {
        this.funcionarios = new ArrayList<>();
    }

    // Construtor que aceita uma lista de funcionários
    public FuncionarioController(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void cadastrarFuncionario(String nome, String cpf, String cargo, double salario, String telefone, String email) {
        Funcionario novoFuncionario = new Funcionario(nome, cpf, cargo, salario, telefone, email);
        funcionarios.add(novoFuncionario);
    }

    public boolean atualizarFuncionario(String cpf, String nome, String cargo, double salario, String telefone, String email) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                funcionario.setNome(nome);
                funcionario.setCargo(cargo);
                funcionario.setSalario(salario);
                funcionario.setTelefone(telefone);
                funcionario.setEmail(email);
                return true;
            }
        }
        return false;
    }

    public boolean removerFuncionario(String cpf) {
        return funcionarios.removeIf(funcionario -> funcionario.getCpf().equals(cpf));
    }
}





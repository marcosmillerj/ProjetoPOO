/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author marcos_miller
 */

import models.Cliente;

import java.util.List;

public class ClienteController {
    private List<Cliente> clientes; // Lista de clientes (pode ser substituída por um banco de dados futuramente)

    // Construtor
    public ClienteController(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    // Método para buscar cliente por CPF
    private Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    // Método para atualizar dados de um cliente
    public boolean atualizarCliente(String cpf, String novoNome, String novoTelefone, String novoEmail) {
        Cliente cliente = buscarClientePorCpf(cpf);
        if (cliente != null) {
            // Atualizando os atributos do cliente
            if (novoNome != null && !novoNome.isEmpty()) cliente.setNome(novoNome);
            if (novoTelefone != null && !novoTelefone.isEmpty()) cliente.setTelefone(novoTelefone);
            if (novoEmail != null && !novoEmail.isEmpty()) cliente.setEmail(novoEmail);

            return true; // Cliente atualizado com sucesso
        }
        return false; // Cliente não encontrado
    }

    // Método para remover um cliente
    public boolean removerCliente(String cpf) {
        Cliente cliente = buscarClientePorCpf(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }
        return false; // Cliente não encontrado
    }
}


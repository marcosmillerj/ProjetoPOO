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
import utils.JsonHandler;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes; // Lista de clientes

    // Construtor
    public ClienteController(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    // Buscar cliente por CPF
    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    // Cadastrar cliente
    public void cadastrarCliente(String nome, String cpf, String telefone, String email) {
        Cliente novoCliente = new Cliente(nome, cpf, telefone, email);
        clientes.add(novoCliente);
        JsonHandler.salvarClientes(clientes); // Salvar alterações no arquivo JSON
    }

    // Atualizar cliente
    public boolean atualizarCliente(String cpf, String nome, String telefone, String email) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente != null) {
            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            JsonHandler.salvarClientes(clientes); // Salvar alterações no arquivo JSON
            return true;
        }
        return false; // Cliente não encontrado
    }

    // Remover cliente
    public boolean removerCliente(String cpf) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
            JsonHandler.salvarClientes(clientes); // Salvar alterações no arquivo JSON
            return true;
        }
        return false; // Cliente não encontrado
    }

    // Getter para a lista de clientes
    public List<Cliente> getClientes() {
        return clientes;
    }
}


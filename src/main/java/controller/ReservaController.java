/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author marcos_miller
 */

import java.util.Date;
import models.Reserva;
import java.util.List;
import models.Cliente;
import models.Produto;

public class ReservaController {
    private List<Reserva> reservas; // Lista de reservas (pode ser substituída por banco de dados futuramente)

    // Construtor
    public ReservaController(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    // Método para buscar reserva por cliente e produto
    private Reserva buscarReserva(Cliente cliente, Produto produto) {
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente) && reserva.getProduto().equals(produto)) {
                return reserva;
            }
        }
        return null; // Reserva não encontrada
    }

    // Método para atualizar dados de uma reserva
    public boolean atualizarReserva(Cliente cliente, Produto produto, Date novaDataReserva) {
        Reserva reserva = buscarReserva(cliente, produto);
        if (reserva != null) {
            if (novaDataReserva != null) {
                reserva.setDataReserva(novaDataReserva);
            }
            return true; // Reserva atualizada com sucesso
        }
        return false; // Reserva não encontrada
    }

    // Método para remover uma reserva
    public boolean removerReserva(Cliente cliente, Produto produto) {
        Reserva reserva = buscarReserva(cliente, produto);
        if (reserva != null) {
            reservas.remove(reserva);
            return true;
        }
        return false; // Reserva não encontrada
    }
}


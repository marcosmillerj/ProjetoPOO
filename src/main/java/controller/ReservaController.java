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

public class ReservaController {
    private List<Reserva> reservas; // Lista de reservas (pode ser substituída por banco de dados futuramente)

    // Construtor
    public ReservaController(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    // Método para buscar reserva por código de reserva (id único gerado)
    private Reserva buscarReservaPorCodigo(String codigo) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigo)) {
                return reserva;
            }
        }
        return null; // Reserva não encontrada
    }

    // Método para buscar reserva por cliente
    private Reserva buscarReservaPorCliente(Cliente cliente) {
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente)) {
                return reserva;
            }
        }
        return null; // Reserva não encontrada
    }

    // Método para criar uma nova reserva
    public boolean criarReserva(Cliente cliente, Date dataReserva) {
        // Verifica se já existe uma reserva para o mesmo cliente
        if (buscarReservaPorCliente(cliente) != null) {
            return false; // Não pode criar reserva duplicada para o mesmo cliente
        }

        // Criação da nova reserva
        Reserva novaReserva = new Reserva(cliente, dataReserva);
        reservas.add(novaReserva); // Adiciona a nova reserva à lista
        return true; // Reserva criada com sucesso
    }

    // Método para atualizar dados de uma reserva
    public boolean atualizarReservaPorCodigo(String codigo, Date novaDataReserva) {
        Reserva reserva = buscarReservaPorCodigo(codigo);
        if (reserva != null) {
            if (novaDataReserva != null) {
                reserva.setDataReserva(novaDataReserva);
            }
            return true; // Reserva atualizada com sucesso
        }
        return false; // Reserva não encontrada
    }

    // Método para atualizar dados de uma reserva por cliente
    public boolean atualizarReserva(Cliente cliente, Date novaDataReserva) {
        Reserva reserva = buscarReservaPorCliente(cliente);
        if (reserva != null) {
            if (novaDataReserva != null) {
                reserva.setDataReserva(novaDataReserva);
            }
            return true; // Reserva atualizada com sucesso
        }
        return false; // Reserva não encontrada
    }

    // Método para remover uma reserva por código
    public boolean removerReservaPorCodigo(String codigo) {
        Reserva reserva = buscarReservaPorCodigo(codigo);
        if (reserva != null) {
            reservas.remove(reserva);
            return true; // Reserva removida com sucesso
        }
        return false; // Reserva não encontrada
    }

    // Método para remover uma reserva por cliente
    public boolean removerReserva(Cliente cliente) {
        Reserva reserva = buscarReservaPorCliente(cliente);
        if (reserva != null) {
            reservas.remove(reserva);
            return true; // Reserva removida com sucesso
        }
        return false; // Reserva não encontrada
    }
}


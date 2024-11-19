/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author marcos_miller
 */

import java.util.Date;

public class Reserva {
    private Cliente cliente;
    private Produto produto;
    private Date dataReserva;

    // Construtor
    public Reserva(Cliente cliente, Produto produto, Date dataReserva) {
        this.cliente = cliente;
        this.produto = produto;
        this.dataReserva = dataReserva;
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    // Método toString
    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente.getNome() +
                ", produto=" + produto.getNome() +
                ", dataReserva=" + dataReserva +
                '}';
    }
}


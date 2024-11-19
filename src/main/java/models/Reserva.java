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
import java.util.UUID;  // Importando UUID para gerar um identificador único

public class Reserva {
    private String codigo;  // Código identificador único
    private Cliente cliente;
    private Date dataReserva;

    // Construtor
    public Reserva(Cliente cliente, Date dataReserva) {
        this.codigo = gerarCodigoUnico();  // Gerando um código único para a reserva
        this.cliente = cliente;
        this.dataReserva = dataReserva;
    }

    // Método para gerar um código único usando UUID
    private String gerarCodigoUnico() {
        return UUID.randomUUID().toString();  // Gera um código único baseado em UUID
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
                "codigo='" + codigo + '\'' +
                ", cliente=" + cliente.getNome() +
                ", dataReserva=" + dataReserva +
                '}';
    }
}


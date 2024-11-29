/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author marcos_miller
 */

import java.time.LocalDateTime;

public class Aula {
    private String tipo;
    private LocalDateTime horario;
    private Funcionario funcionario; // Alterado de Instrutor para Funcionario

    public Aula(String tipo, LocalDateTime horario, Funcionario funcionario) {
        this.tipo = tipo;
        this.horario = horario;
        this.funcionario = funcionario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "tipo='" + tipo + '\'' +
                ", horario=" + horario +
                ", funcionario=" + funcionario +
                '}';
    }
}



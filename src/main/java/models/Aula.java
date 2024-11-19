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
    private String tipo; // Exemplo: Yoga, Pilates, Spinning
    private LocalDateTime horario; // Data e hora da aula
    private Instrutor instrutor; // Instrutor responsável pela aula
    private int capacidadeMaxima; // Máximo de alunos permitidos
    private int inscritos; // Quantidade atual de inscritos

    // Construtor
    public Aula(String tipo, LocalDateTime horario, Instrutor instrutor) {
        this.tipo = tipo;
        this.horario = horario;
        this.instrutor = instrutor;
        this.inscritos = 0; // Inicialmente não há inscritos
    }

    // Getters e Setters
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

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }


    public int getInscritos() {
        return inscritos;
    }

    public void setInscritos(int inscritos) {
        this.inscritos = inscritos;
    }

    // Métodos
    public boolean adicionarAluno() {
        if (inscritos < capacidadeMaxima) {
            inscritos++;
            return true;
        } else {
            return false; // Turma cheia
        }
    }

    public boolean removerAluno() {
        if (inscritos > 0) {
            inscritos--;
            return true;
        } else {
            return false; // Não há alunos para remover
        }
    }

    @Override
    public String toString() {
        return "Aula{" +
                "tipo='" + tipo + '\'' +
                ", horario=" + horario +
                ", instrutor=" + instrutor.getNome() +
                ", inscritos=" + inscritos +
                '}';
    }
}


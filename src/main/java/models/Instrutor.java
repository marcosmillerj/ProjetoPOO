/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author marcos_miller
 */

import java.util.ArrayList;
import java.util.List;

public class Instrutor extends Pessoa {
    private String especialidade;
    private List<Aula> aulas; // Lista de aulas ministradas pelo instrutor

    public Instrutor(String nome, String cpf, String telefone, String email, String especialidade) {
        super(nome, cpf, telefone, email); // Chama o construtor da classe Pessoa
        this.especialidade = especialidade;
        this.aulas = new ArrayList<>();
    }

    // Getters e Setters
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    // Métodos adicionais
    public void adicionarAula(Aula aula) {
        if (aula != null && !aulas.contains(aula)) {
            aulas.add(aula);
        }
    }

    public void removerAula(Aula aula) {
        aulas.remove(aula);
    }

    @Override
    public String toString() {
        return "Instrutor{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", aulasMinistradas=" + aulas.size() +
                '}';
    }
}


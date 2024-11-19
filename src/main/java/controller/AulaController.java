/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author marcos_miller
 */

import models.Aula;
import models.Instrutor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AulaController {
    private List<Aula> aulas;

    public AulaController() {
        this.aulas = new ArrayList<>(); // Inicializa a lista de aulas
    }

    // Criar uma nova aula
    public boolean criarAula(String tipo, LocalDateTime horario, Instrutor instrutor) {
        if (instrutor == null || tipo == null || tipo.isEmpty()) {
            return false; // Validação básica
        }
        Aula novaAula = new Aula(tipo, horario, instrutor);
        aulas.add(novaAula);
        return true;
    }

    // Listar todas as aulas
    public List<Aula> listarAulas() {
        return new ArrayList<>(aulas); // Retorna uma cópia da lista para evitar modificações externas
    }

    // Buscar aula pelo tipo
    public Aula buscarAulaPorTipo(String tipo) {
        for (Aula aula : aulas) {
            if (aula.getTipo().equalsIgnoreCase(tipo)) {
                return aula;
            }
        }
        return null; // Não encontrou
    }

    // Atualizar uma aula
    public boolean atualizarAula(String tipo, String novoTipo, LocalDateTime novoHorario, Instrutor novoInstrutor) {
        Aula aula = buscarAulaPorTipo(tipo);
        if (aula != null) {
            if (novoTipo != null && !novoTipo.isEmpty()) aula.setTipo(novoTipo);
            if (novoHorario != null) aula.setHorario(novoHorario);
            if (novoInstrutor != null) aula.setInstrutor(novoInstrutor);
            return true;
        }
        return false; // Aula não encontrada
    }

    // Remover uma aula
    public boolean removerAula(String tipo) {
        Aula aula = buscarAulaPorTipo(tipo);
        if (aula != null) {
            aulas.remove(aula);
            return true;
        }
        return false; // Aula não encontrada
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author marcos_miller
 */

import models.Cliente;
import models.Instrutor;
import models.Produto;
import models.Reserva;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class JsonHandler {

    // Caminho dos arquivos JSON
    private static final String CLIENTES_FILE = "clientes.json";
    private static final String INSTRUTORES_FILE = "instrutores.json";
    private static final String PRODUTOS_FILE = "produtos.json";
    private static final String RESERVAS_FILE = "reservas.json";

    // Método para carregar a lista de clientes
    public static List<Cliente> carregarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            FileReader reader = new FileReader(CLIENTES_FILE);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonContent.toString());

            // Convertendo o JSONArray para lista de objetos Cliente
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Cliente cliente = new Cliente(
                        jsonObject.getString("cpf"),
                        jsonObject.getString("nome"),
                        jsonObject.getString("telefone"),
                        jsonObject.getString("email")
                );
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // Método para salvar a lista de clientes no arquivo JSON
    public static void salvarClientes(List<Cliente> clientes) {
        JSONArray jsonArray = new JSONArray();
        for (Cliente cliente : clientes) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cpf", cliente.getCpf());
            jsonObject.put("nome", cliente.getNome());
            jsonObject.put("telefone", cliente.getTelefone());
            jsonObject.put("email", cliente.getEmail());
            jsonArray.put(jsonObject);
        }
        try (FileWriter file = new FileWriter(CLIENTES_FILE)) {
            file.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar a lista de instrutores
    public static List<Instrutor> carregarInstrutores() {
        List<Instrutor> instrutores = new ArrayList<>();
        try {
            FileReader reader = new FileReader(INSTRUTORES_FILE);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonContent.toString());

            // Convertendo o JSONArray para lista de objetos Instrutor
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Instrutor instrutor = new Instrutor(
                        jsonObject.getString("cpf"),
                        jsonObject.getString("nome"),
                        jsonObject.getString("telefone"),
                        jsonObject.getString("email"),
                        jsonObject.getString("especialidade")
                );
                instrutores.add(instrutor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instrutores;
    }

    // Método para salvar a lista de instrutores no arquivo JSON
    public static void salvarInstrutores(List<Instrutor> instrutores) {
        JSONArray jsonArray = new JSONArray();
        for (Instrutor instrutor : instrutores) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cpf", instrutor.getCpf());
            jsonObject.put("nome", instrutor.getNome());
            jsonObject.put("telefone", instrutor.getTelefone());
            jsonObject.put("email", instrutor.getEmail());
            jsonObject.put("especialidade", instrutor.getEspecialidade());
            jsonArray.put(jsonObject);
        }
        try (FileWriter file = new FileWriter(INSTRUTORES_FILE)) {
            file.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar a lista de produtos
    public static List<Produto> carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            FileReader reader = new FileReader(PRODUTOS_FILE);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonContent.toString());

            // Convertendo o JSONArray para lista de objetos Produto
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Produto produto = new Produto(
                        jsonObject.getString("codigo"),
                        jsonObject.getString("nome"),
                        jsonObject.getDouble("preco"),
                        jsonObject.getInt("quantidade")                     
                );
                produtos.add(produto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    // Método para salvar a lista de produtos no arquivo JSON
    public static void salvarProdutos(List<Produto> produtos) {
        JSONArray jsonArray = new JSONArray();
        for (Produto produto : produtos) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("codigo", produto.getCodigo());
            jsonObject.put("nome", produto.getNome());
            jsonObject.put("preco", produto.getPreco());
            jsonObject.put("quantidade", produto.getQuantidade());
            jsonArray.put(jsonObject);
        }
        try (FileWriter file = new FileWriter(PRODUTOS_FILE)) {
            file.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar a lista de reservas
    public static List<Reserva> carregarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        try {
            FileReader reader = new FileReader(RESERVAS_FILE);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonContent.toString());

            // Convertendo o JSONArray para lista de objetos Reserva
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Reserva reserva = new Reserva(
                        new Cliente(jsonObject.getString("cpfCliente"), "", "", ""),  // Aqui é necessário um cliente completo, pode ser ajustado se necessário.
                        new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.getString("dataReserva"))
                );
                reserva.setCodigo(jsonObject.getString("codigo"));
                reservas.add(reserva);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return reservas;
    }

    // Método para salvar a lista de reservas no arquivo JSON
    public static void salvarReservas(List<Reserva> reservas) {
        JSONArray jsonArray = new JSONArray();
        for (Reserva reserva : reservas) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("codigo", reserva.getCodigo());
            jsonObject.put("cpfCliente", reserva.getCliente().getCpf());
            jsonObject.put("dataReserva", new SimpleDateFormat("yyyy-MM-dd").format(reserva.getDataReserva()));
            jsonArray.put(jsonObject);
        }
        try (FileWriter file = new FileWriter(RESERVAS_FILE)) {
            file.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





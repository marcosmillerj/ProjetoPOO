package utils;

import models.Cliente;
import models.Funcionario;
import models.Produto;
import models.Reserva;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {

    // Caminho dos arquivos JSON
    private static final String CLIENTES_FILE = "clientes.json";
    private static final String FUNCIONARIOS_FILE = "funcionarios.json";
    private static final String PRODUTOS_FILE = "produtos.json";
    private static final String RESERVAS_FILE = "reservas.json";

    // Método para carregar a lista de clientes
    public static List<Cliente> carregarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(CLIENTES_FILE));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonContent.toString());

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
    
    //método para salvar os clientes
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

    // Método para carregar a lista de funcionários
    public static List<Funcionario> carregarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FUNCIONARIOS_FILE));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonContent.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Funcionario funcionario = new Funcionario(
                        jsonObject.getString("nome"),
                        jsonObject.getString("cpf"),
                        jsonObject.getString("cargo"),
                        jsonObject.getDouble("salario"),
                        jsonObject.getString("telefone"),
                        jsonObject.getString("email")
                );
                funcionarios.add(funcionario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }
    
    //método salvar os funcinários
    public static void salvarFuncionarios(List<Funcionario> funcionarios) {
        JSONArray jsonArray = new JSONArray();
        for (Funcionario funcionario : funcionarios) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nome", funcionario.getNome());
            jsonObject.put("cpf", funcionario.getCpf());
            jsonObject.put("telefone", funcionario.getTelefone());
            jsonObject.put("email", funcionario.getEmail());
            jsonObject.put("cargo", funcionario.getCargo());
            jsonObject.put("salario", funcionario.getSalario()); // Salvando o salário
            jsonArray.put(jsonObject);
        }
        try (FileWriter file = new FileWriter(FUNCIONARIOS_FILE)) {
            file.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar a lista de produtos
    public static List<Produto> carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(PRODUTOS_FILE));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonContent.toString());

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
            BufferedReader bufferedReader = new BufferedReader(new FileReader(RESERVAS_FILE));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonContent.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Reserva reserva = new Reserva(
                        new Cliente(jsonObject.getString("cpfCliente"), "", "", ""),
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
    
    // metodo Salvar as reservas
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

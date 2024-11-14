/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author marcos_miller
 */

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.List;

public class JsonHandler {

    // Salvar dados em JSON
    public static void saveToJson(String filePath, Object data) {
        try (Writer writer = new FileWriter(filePath)) {
            JSONObject jsonObject = new JSONObject(data);
            writer.write(jsonObject.toString(4)); // Formatação do JSON (indentação)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carregar dados de um arquivo JSON para um objeto
    public static <T> T loadFromJson(String filePath, Class<T> clazz) {
        try (Reader reader = new FileReader(filePath)) {
            StringBuilder jsonBuilder = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                jsonBuilder.append((char) ch);
            }
            JSONObject jsonObject = new JSONObject(jsonBuilder.toString());
            // Aqui você pode criar instâncias do tipo desejado
            // Dependendo da classe, você precisa de lógica específica para preenchê-la com os dados do JSON
            return clazz.getConstructor(JSONObject.class).newInstance(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Carregar uma lista de objetos a partir de um arquivo JSON
    public static <T> List<T> loadListFromJson(String filePath, Class<T[]> clazz) {
        try (Reader reader = new FileReader(filePath)) {
            StringBuilder jsonBuilder = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                jsonBuilder.append((char) ch);
            }
            JSONArray jsonArray = new JSONArray(jsonBuilder.toString());
            // Aqui, você pode iterar sobre o JSONArray para criar instâncias da classe T
            // Retornando uma lista de objetos
            return null; // Será necessário adaptar para a lista de objetos
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author marcos_miller
 */

import models.Produto;

import java.util.List;

public class ProdutoController {
    private List<Produto> produtos; // Lista de produtos (pode ser substituída por um banco de dados futuramente)

    // Construtor
    public ProdutoController(List<Produto> produtos) {
        this.produtos = produtos;
    }

    // Método para buscar produto por código
    private Produto buscarProdutoPorCodigo(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null; // Produto não encontrado
    }

    // Método para atualizar dados de um produto
    public boolean atualizarProduto(String codigo, String novoNome, double novoPreco, int novaQuantidade) {
        Produto produto = buscarProdutoPorCodigo(codigo);
        if (produto != null) {
            // Atualizando os atributos do produto
            if (novoNome != null && !novoNome.isEmpty()) produto.setNome(novoNome);
            if (novoPreco > 0) produto.setPreco(novoPreco);
            if (novaQuantidade >= 0) produto.setQuantidade(novaQuantidade);

            return true; // Produto atualizado com sucesso
        }
        return false; // Produto não encontrado
    }

    // Método para remover um produto
    public boolean removerProduto(String codigo) {
        Produto produto = buscarProdutoPorCodigo(codigo);
        if (produto != null) {
            produtos.remove(produto);
            return true;
        }
        return false; // Produto não encontrado
    }
}


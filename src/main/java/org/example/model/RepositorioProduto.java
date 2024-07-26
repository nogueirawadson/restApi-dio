package org.example.model;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioProduto {



    public void save(Produto produto) {
        System.out.println("Salvando produto");
        System.out.println(produto);
    }

    public Produto upadate(Produto produto) {
        Produto produtoAtualizado = new Produto();
        produtoAtualizado = produto;
        produtoAtualizado.setProdutoId(produto.getProdutoId());
        System.out.println("Atualizando produto");
        return produtoAtualizado;

    }

    public void delete(Produto produto) {
        System.out.println("Deletando produto");
        System.out.println(produto);

    }


    public Produto findBynome(String nome) {
        Produto produto_nome = new Produto();
        produto_nome.getNome();
        return produto_nome;
    }



}

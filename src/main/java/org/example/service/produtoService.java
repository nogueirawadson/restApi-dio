package org.example.service;

import javassist.tools.rmi.ObjectNotFoundException;
import org.example.model.Produto;
import org.example.repository.RepositorioProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class produtoService {

    @Autowired
    private RepositorioProduto repository;

    public Produto findById(Integer id){
        Optional<Produto> produto = repository.findById(id);
        try {
            return produto.orElseThrow(() ->
                    new ObjectNotFoundException("Objeto não encontrado! " + id + "Tipo: " + Produto.class.getName()));
        } catch (ObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Produto> findAll() {
        List<Produto> list = repository.findAll();
        return list;
    }


    public Produto create(Produto produto) {
        Produto newProduto = new Produto();
        newProduto.setId(null);
        newProduto.setNome(produto.getNome());
        newProduto.setDescricao(produto.getDescricao());
        newProduto.setCodigo(produto.getCodigo());
        return repository.save(newProduto);

    }

    public Produto update(Integer id, Produto produto) {
        Produto newProduto = findById(id);
        newProduto.setNome(produto.getNome());
        newProduto.setDescricao(produto.getDescricao());
        newProduto.setCodigo(produto.getCodigo());
        return repository.save(newProduto);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

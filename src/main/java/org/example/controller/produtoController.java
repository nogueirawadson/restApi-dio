package org.example.controller;

import org.example.model.Produto;
import org.example.model.RepositorioProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class produtoController {

   @Autowired
   private RepositorioProduto produtos;

    @RequestMapping(value = "/produtos", method = RequestMethod.GET, produces = "application/json")
    public RepositorioProduto getProdutos(){
        return produtos;
    }


    @PostMapping("/produtos")
    public Produto addProduto(@RequestBody Produto produto){
        produtos.save(produto);
        System.out.println(produtos);
        return produto;
    }

    @PutMapping("/produtos{nome}")
    public Produto updateProduto(@PathVariable("nome") Produto produto){
        produtos.upadate(produto);
        return produto;
    }

    @GetMapping("/produtos")
    public Produto getProduto(@PathVariable("nome") String nome ) {
        return produtos.findBynome(nome);
    }

    @DeleteMapping(path = {"/produtos/{id}"})
    public void deleteProduto(@PathVariable("nome") String nome){
        produtos.delete(getProdutos().findBynome(nome));
    }

}

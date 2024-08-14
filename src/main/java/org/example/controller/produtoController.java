package org.example.controller;

import org.example.model.Produto;
import org.example.service.produtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class produtoController {

   @Autowired
   private produtoService service;

   @GetMapping(value = "/{id}") // AChar produto pelo id
   public ResponseEntity<Produto> findById(@PathVariable Integer id) {
       Produto produto = service.findById(id);
       return ResponseEntity.ok().body(produto);
   }

    @GetMapping(value = "/produtos") // Listar todos os produtos
    public ResponseEntity<List<Produto>> listAll() {
       List<Produto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


    @PostMapping // Quando recebemos uma requisição não precisamos de valor
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        produto = service.create(produto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> upadate(@PathVariable Integer id, @RequestBody Produto produto){
       Produto newProduto = service.update(id, produto);
       return ResponseEntity.ok().body(newProduto);

    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
       service.delete(id);
       return ResponseEntity.noContent().build();
    }

}

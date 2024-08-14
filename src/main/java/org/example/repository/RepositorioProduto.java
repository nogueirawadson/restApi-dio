package org.example.repository;

import org.example.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProduto extends JpaRepository<Produto, Integer> {




    }





package br.com.tex.persistencia.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}

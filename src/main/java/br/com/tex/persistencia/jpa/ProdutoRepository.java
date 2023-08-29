package br.com.tex.persistencia.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends Repository<Produto, Integer> {
    void save(Produto produto);

    List<Produto> findAll();

    Optional<Produto> findById(Integer id);

    void deleteById(Integer id);
}

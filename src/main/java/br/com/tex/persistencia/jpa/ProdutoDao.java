package br.com.tex.persistencia.jpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProdutoDao {

    @PersistenceContext
    private EntityManager em;

    public void cadastra(Produto produto) {
        em.persist(produto);
    }

    public List<Produto> lista() {
        return this.em.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public Produto buscaPor(Integer id) {
        return this.em.find(Produto.class, id);
    }

    public void remove(Integer id) {
        this.em.remove(this.em.find(Produto.class, id));
    }
}

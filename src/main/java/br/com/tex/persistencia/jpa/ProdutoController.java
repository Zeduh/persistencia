package br.com.tex.persistencia.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoDao dao;

    @Transactional
    @PostMapping
    public void cadastra(@RequestBody Produto produto){
        this.dao.cadastra(produto);
    }

    @GetMapping
    public List<Produto> lista(){
        return this.dao.lista();
    }

    @GetMapping("/{id}")
    public Produto buscaPor(@PathVariable Integer id){
        return this.dao.buscaPor(id);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleta(@PathVariable Integer id){
        this.dao.remove(id);
    }

    @Transactional
    @PutMapping
    public void altera(@RequestBody Produto produto){
        Produto produtoCadastrado = this.dao.buscaPor(produto.getId());
        produtoCadastrado.setPreco(produto.getPreco());
    }

}

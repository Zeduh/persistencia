package br.com.tex.persistencia.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository dao;

    @Transactional
    @PostMapping
    public void cadastra(@RequestBody Produto produto){
        this.dao.save(produto);
    }

    @GetMapping
    public List<Produto> lista(){
        return (List<Produto>) this.dao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscaPor(@PathVariable Integer id){
        Optional<Produto> optionalProduto = this.dao.findById(id);
        if(optionalProduto.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(this.dao.findById(id).get());
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleta(@PathVariable Integer id){
        this.dao.deleteById(id);
    }

    @Transactional
    @PutMapping
    public void altera(@RequestBody Produto produto){
        this.dao.save(produto);
    }

}

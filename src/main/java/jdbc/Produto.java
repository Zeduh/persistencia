package jdbc;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Produto {

    private Integer id;
    private  String nome;
    private BigDecimal preco;
    private LocalDate validade;
    private Categoria categoria;

    public Produto(){}

    public Produto(String nome, BigDecimal preco, LocalDate validade, Categoria categoria){
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.categoria = categoria;
    }

    public Integer getId() {return id;}

    public String getNome() {return nome;}

    public BigDecimal getPreco() {return preco;}

    public LocalDate getValidade() {return validade;}

    public Categoria getCategoria() {return categoria;}

    public void setId(Integer id) {this.id = id;}

    public void setNome(String nome) {this.nome = nome;}

    public void setPreco(BigDecimal preco) {this.preco = preco;}

    public void setValidade(LocalDate validade) {this.validade = validade;}

    public void setCategoria(Categoria categoria) {this.categoria = categoria;}

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", validade=" + validade +
                ", categoria=" + categoria +
                '}';
    }
}

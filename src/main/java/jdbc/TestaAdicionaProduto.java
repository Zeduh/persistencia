package jdbc;

import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class TestaAdicionaProduto {
    public static void main(String[] args) throws SQLException {

        Produto produto = new Produto("produto1", BigDecimal.ONE, LocalDate.now(), Categoria.COMIDA);
        ProdutoDao dao = new ProdutoDao();
//        dao.cadastra(produto);
        dao.cadastra(new Produto("produto2", new BigDecimal(25), LocalDate.now(), Categoria.SOBREMESA));
        dao.cadastra(new Produto("produto3", new BigDecimal(100), LocalDate.now(), Categoria.BEBIDA));
        System.out.println("Produto cadastrado com sucesso!");
    }
}

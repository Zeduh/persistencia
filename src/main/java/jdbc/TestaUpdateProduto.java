package jdbc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class TestaUpdateProduto {
    public static void main(String[] args) throws SQLException {
        Produto produto = new Produto("produto4", BigDecimal.ZERO, LocalDate.now(), Categoria.COMIDA);
        produto.setId(2);

        ProdutoDao dao = new ProdutoDao();
        dao.atualiza(produto);

        System.out.println("Produto atualizado com sucesso!");
    }
}

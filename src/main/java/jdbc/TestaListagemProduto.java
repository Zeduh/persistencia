package jdbc;

import java.sql.SQLException;
import java.util.List;

public class TestaListagemProduto {
    public static void main(String[] args) throws SQLException {
        ProdutoDao dao = new ProdutoDao();
        List<Produto> produtos = dao.lista();

        produtos.forEach(produto -> System.out.println(produto));
    }
}

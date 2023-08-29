package jdbc;

import java.sql.SQLException;

public class TestaBuscaProdutoPorId {
    public static void main(String[] args) throws SQLException {
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.buscaPor(2);
        System.out.println(produto);
    }
}

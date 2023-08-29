package jdbc;

import java.sql.SQLException;

public class TestaRemoveProduto {
    public static void main(String[] args) throws SQLException {
        ProdutoDao dao = new ProdutoDao();
        dao.remove(1);
        System.out.println("Produto removido com sucesso");
    }
}

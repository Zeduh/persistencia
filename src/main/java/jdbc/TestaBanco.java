package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaBanco {
    public static void main(String[] args) throws SQLException {

        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/persistencia", "root", "1234");
        System.out.println("Temos uma conexão...");
        conexao.close();

    }
}

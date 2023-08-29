package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

    public static Connection getConexao(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/persistencia", "root", "1234");
        } catch (SQLException ex){
            throw  new RuntimeException();
        }

    }

}

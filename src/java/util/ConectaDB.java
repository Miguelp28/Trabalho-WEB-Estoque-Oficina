/** *************************************************
 * @author Miguel Henrique dos Santos Correa        *
 * RGM: 11231101499                                 *
 * Turma: B                                         *
 * Período: 04                                      *
 ***************************************************/
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaDB {

    public static Connection conectar() throws ClassNotFoundException {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3307/oficina", "root", "");
            return conexao;
        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        }
        return conexao;
    }
}

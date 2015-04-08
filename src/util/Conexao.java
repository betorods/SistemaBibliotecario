package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Alberto
 */
public class Conexao {
     public static Connection conexao() throws ClassNotFoundException{
        try {
           //  Class.forName("org.mysql.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/BDbiblioteca","root","12345");
        //     JOptionPane.showMessageDialog(null, "Conectado com sucesso:");
             return con;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return null;
        //    throw new RuntimeException(ex);
        }
    }
}

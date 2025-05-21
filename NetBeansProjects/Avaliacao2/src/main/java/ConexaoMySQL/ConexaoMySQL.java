
package ConexaoMySQL;

/**
 *
 * @author aluno.den
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
   public static Connection conectar() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/Avaliacao2";
            String usuario = "root";
            String senha = "";

            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados: " + e.getMessage());
        }
    }
}

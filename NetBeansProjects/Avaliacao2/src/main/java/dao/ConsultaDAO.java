
package dao;

import ConexaoMySQL.ConexaoMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import model.Consulta;

/**
 *
 * @author Adriana
 */
public class ConsultaDAO {
     public void inserir(Consulta consulta) {
        String sql = "INSERT INTO consulta (id_paciente, id_medico, data, hora, observacao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              stmt.setInt(1, consulta.getId_paciente());
            stmt.setInt(2, consulta.getId_medico());
            stmt.setDate(3, Date.valueOf(consulta.getData()));
            stmt.setTime(4, Time.valueOf(consulta.getHora()));
            stmt.setString(5, consulta.getObservacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
    }
        
    }
      public ArrayList<Consulta> listar() {
        ArrayList<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consulta";
        try (Connection conn = ConexaoMySQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Consulta c = new Consulta(
                    rs.getInt("id"),
                    rs.getInt("id_paciente"),
                    rs.getInt("id_medico"),
                    rs.getDate("data").toLocalDate(),
                    rs.getTime("hora").toLocalTime(),
                    rs.getString("observacao")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
}
      public ArrayList<Consulta> buscarPorID(int id) {
    ArrayList<Consulta> lista = new ArrayList<>();
    String sql = "SELECT * FROM consulta WHERE id LIKE ?";

    try (Connection conn = ConexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "%" + id + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Consulta c = new Consulta(
                rs.getInt("id"),
                rs.getInt("id_paciente"),
                rs.getInt("id_medico"),
                rs.getDate("data").toLocalDate(),
                rs.getTime("hora").toLocalTime(),
                rs.getString("observacao")    
            );
            lista.add(c);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
      public void atualizar(Consulta consulta) {
        String sql = "UPDATE medico SET id_paciente = ?, id_medico = ?, data  = ?,  hora = ?, observacao = ? WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, consulta.getId_paciente());
            stmt.setInt(2, consulta.getId_medico());
            stmt.setDate(3, Date.valueOf(consulta.getData()));
            stmt.setTime(4, Time.valueOf(consulta.getHora()));
            stmt.setString(5, consulta.getObservacao());
            stmt.setInt(6, consulta.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 }
       public void remover(int id) {
        String sql = "DELETE FROM consulta WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

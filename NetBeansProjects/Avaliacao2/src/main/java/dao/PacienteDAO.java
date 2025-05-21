
package dao;

import ConexaoMySQL.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Paciente;

/**
 *
 * @author aluno.den
 */



public class PacienteDAO {
     public void inserir(Paciente paciente) {
        String sql = "INSERT INTO paciente (nome, cpf, telefone) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNomePaciente());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public ArrayList<Paciente> listar() {
        ArrayList<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        try (Connection conn = ConexaoMySQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Paciente p = new Paciente(
                        rs.getInt("id"),
                        rs.getString("nomepaciente"),
                        rs.getString("cpf"),
                         rs.getString("telefone")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
     
     public ArrayList<Paciente> buscarPorNome(String nome) {
    ArrayList<Paciente> lista = new ArrayList<>();
    String sql = "SELECT * FROM paciente WHERE nome LIKE ?";

    try (Connection conn = ConexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "%" + nome + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Paciente p = new Paciente(
                rs.getInt("id"),
                rs.getString("nomepaciente"),
                rs.getString("cpf"),
                rs.getString("telefone")    
            );
            lista.add(p);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
    }
     
      public void atualizar(Paciente paciente) {
        String sql = "UPDATE paciente SET nome = ?, cpf = ?, telefone = ? WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNomePaciente());
            stmt.setString(2, paciente.getCpf());
            stmt.setInt(3, paciente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
      public void remover(int id) {
        String sql = "DELETE FROM paciente WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
      public Paciente buscarPorId(int id) {
          Paciente p = null;
          String sql = "SELECT * FROM paciente WHERE id = ?";
          
          try (Connection conn = ConexaoMySQL.conectar());
                PreparedStatement stmt = conn.prepareStatement(sql) {
              
              stmt.setInt(1, id);
              ResultSet rs = stmt.executeQuery();
              
          } catch (Exception e) {
          }
      }
}

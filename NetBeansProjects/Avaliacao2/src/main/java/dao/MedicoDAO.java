
package dao;

import ConexaoMySQL.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Medico;


/**
 *
 * @author Adriana
 */
public class MedicoDAO {
      public boolean inserir(Medico medico) {
        String sql = "INSERT INTO medico (nome, especialidade, crm) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
          stmt.setString(1, medico.getNomeMedico());
        stmt.setString(2, medico.getEspecialidade());
        stmt.setString(3, medico.getCrm());

        int linhasAfetadas = stmt.executeUpdate();
        if (linhasAfetadas > 0) {
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                medico.setId(rs.getInt(1));
            }
            return true;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
        
    }
      public ArrayList<Medico> listar() {
        ArrayList<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM medico";
        try (Connection conn = ConexaoMySQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Medico m = new Medico(
                        rs.getInt("id"),
                        rs.getString("nomemedico"),
                        rs.getString("especialidade"),
                        rs.getString("crm")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
}
      public ArrayList<Medico> buscarPorNome(String nomemedico) {
    ArrayList<Medico> lista = new ArrayList<>();
    String sql = "SELECT * FROM medico WHERE nome LIKE ?";

    try (Connection conn = ConexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "%" + nomemedico + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Medico m = new Medico(
                rs.getInt("id"),
                rs.getString("nomemedico"),
                rs.getString("especialidade"),
                rs.getString("crm")    
            );
            lista.add(m);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
      public void atualizar(Medico medico) {
        String sql = "UPDATE medico SET nome = ?, especialidade = ?, crm = ? WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNomeMedico());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setInt(3, medico.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 }
       public void remover(int id) {
        String sql = "DELETE FROM medico WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       public Medico buscarPorId(int id) {
        Medico medico = null;
        String sql = "SELECT * FROM Medico WHERE id = ?";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                medico = new Medico(rs.getInt("id"), rs.getString("nome"), rs.getString("especialidade"), rs.getString("crm"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medico;
}
       
       
}

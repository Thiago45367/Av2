/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
      public void inserir(Medico medico) {
        String sql = "INSERT INTO medico (nome, especialidade, crm) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setInt(2, medico.getCrm());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
    }
        
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
                        rs.getString("nome"),
                        rs.getString("especialidade"),
                        rs.getInt("crm")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
}
      public ArrayList<Medico> buscarPorNome(String nome) {
    ArrayList<Medico> lista = new ArrayList<>();
    String sql = "SELECT * FROM medico WHERE nome LIKE ?";

    try (Connection conn = ConexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "%" + nome + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Medico m = new Medico(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("especialidade"),
                rs.getInt("crm")    
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
            stmt.setString(1, medico.getNome());
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
}

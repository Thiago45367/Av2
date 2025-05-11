/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PacienteDAO;
import model.Paciente;
import java.sql.SQLException;
import java.util.List;

public class PacienteController {
      private PacienteDAO dao = new PacienteDAO();

    public void adicionarPaciente(Paciente paciente) throws SQLException {
        dao.inserir(paciente);
    }

    public List<Paciente> listarPacientes() throws SQLException {
        return dao.listar();
    }
}

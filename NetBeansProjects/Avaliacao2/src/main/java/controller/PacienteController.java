package controller;

import dao.PacienteDAO;
import model.Paciente;
import java.util.ArrayList;


public class PacienteController {
      private PacienteDAO dao = new PacienteDAO();

    public Paciente cadastrar(String nome, String cpf, String telefone) {
     Paciente paciente = new Paciente(nome, cpf, telefone);
     PacienteDAO dao = new PacienteDAO();
     boolean sucesso = dao.inserir(paciente); 
     return sucesso ? paciente : null;
}

    
    public ArrayList<Paciente> listar() {
        return dao.listar();
    }
    
    public void atualizar(int id, String nome, String cpf, String telefone) {
        Paciente p = new Paciente(id, nome, cpf, telefone);
        dao.atualizar(p);
    }
    
    public void remover(int id) {
        dao.remover(id);
    }
    
    public ArrayList<Paciente> buscarPorNome(String nome) {
       return dao.buscarPorNome(nome);
}
}

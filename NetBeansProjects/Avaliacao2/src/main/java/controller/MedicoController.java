
package controller;

import dao.MedicoDAO;
import java.util.ArrayList;
import model.Medico;

/**
 *
 * @author aluno.den
 */
public class MedicoController {
    private MedicoDAO dao = new MedicoDAO();

    public Medico cadastrar(String nome, String especialidade, String crm) {
     Medico medico = new Medico(nome, especialidade, crm);
     MedicoDAO dao = new MedicoDAO();
     boolean sucesso = dao.inserir(medico); 
     return sucesso ? medico: null;
    }
    
    public ArrayList<Medico> listar() {
        return dao.listar();
    }
    
    public void atualizar(int id, String nome, String especialidade, String crm) {
        Medico m = new Medico(id, nome, especialidade, crm);
        dao.atualizar(m);
    }
    
    public void remover(int id) {
        dao.remover(id);
    }
    
    public ArrayList<Medico> buscarPorNome(String nome) {
       return dao.buscarPorNome(nome);
}
}

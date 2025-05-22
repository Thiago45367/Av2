
package controller;

import dao.ConsultaDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import model.Consulta;

/**
 *
 * @author aluno.den
 */
public class ConsultaController {
      private ConsultaDAO dao = new ConsultaDAO();

    public boolean cadastrar(int id_paciente, int id_medico, LocalDate data, LocalTime hora, String observacao) {
        Consulta c = new Consulta(id_paciente, id_medico, data, hora, observacao);
        dao.inserir(c);
          return false;
    }
    
    public ArrayList<Consulta> listar() {
        return dao.listar();
    }
    
    public void atualizar (int id_paciente, int id_medico, LocalDate date, LocalTime hora, String observacao) {
        Consulta c = new Consulta(id_paciente, id_medico, date, hora, observacao);
        dao.atualizar(c);
    }
    
   
}

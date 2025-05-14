
package controller;

import dao.ConsultaDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import model.Consulta;

/**
 *
 * @author aluno.den
 */
public class ConsultaController {
      private ConsultaDAO dao = new ConsultaDAO();

    public void cadastrar(int id_paciente, int id_medico, LocalDate data, LocalTime hora, String observacao) {
        Consulta c = new Consulta(id_paciente, id_medico, data, hora, observacao);
        dao.inserir(c);
    }
    
   
}

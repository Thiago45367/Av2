
package controller;

import dao.MedicoDAO;
import java.sql.SQLException;
import java.util.List;
import model.Medico;

/**
 *
 * @author aluno.den
 */
public class MedicoController {
      private MedicoDAO dao = new MedicoDAO();

    public void adicionarMedico(Medico medico) throws SQLException {
        dao.inserir(medico);
    }

    public List<Medico> listarMedico() throws SQLException {
        return dao.listar();
    }
}

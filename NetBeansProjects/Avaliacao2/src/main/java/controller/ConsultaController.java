
package controller;

import dao.ConsultaDAO;
import java.sql.SQLException;
import java.util.List;
import model.Consulta;

/**
 *
 * @author aluno.den
 */
public class ConsultaController {
      private ConsultaDAO dao = new ConsultaDAO();

    public void adicionarConsulta(Consulta consulta) throws SQLException {
        dao.inserir(consulta);
    }

    public List<Consulta> listarPacientes() throws SQLException {
        return dao.listar();
    }
}

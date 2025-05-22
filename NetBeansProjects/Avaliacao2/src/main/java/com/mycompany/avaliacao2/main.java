

package com.mycompany.avaliacao2;

import java.sql.Connection;
import view.TelaLogin;
import ConexaoMySQL.ConexaoMySQL;


/**
 *
 * @author aluno.den
 */
public class main {

    public static void main(String[] args) {
         try {
            Connection conexao = ConexaoMySQL.conectar();
            if (conexao != null) {
                System.out.println("✅ Conexão com o banco de dados estabelecida com sucesso!");
                conexao.close();
            }
        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar com o banco de dados:");
            e.printStackTrace();
        }
         
          javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaLogin tela = new TelaLogin();
                tela.setVisible(true);
            }
        });
    }
}
    
        
       
    



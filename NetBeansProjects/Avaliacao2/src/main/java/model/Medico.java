
package model;

/**
 *
 * @author aluno.den
 */
public class Medico {
    private int id;
    private String nomemedico;
    private String especialidade;
    private String crm;

    public Medico() {
    
 }

    public Medico(String nomemedico, String especialidade, String crm) {
        this.nomemedico = nomemedico;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public Medico(int id, String nomemedico, String especialidade, String crm) {
        this.id = id;
        this.nomemedico = nomemedico    ;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public int getId() {
        return id;
    }

    public String getNomeMedico() {
        return nomemedico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeMedico(String nomemedico) {
        this.nomemedico = nomemedico;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }  
}

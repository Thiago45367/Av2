
package model;

/**
 *
 * @author aluno.den
 */
public class Medico {
    private int id;
    private String nome;
    private String especialidade;
    private int crm;

    public Medico() {
    
 }

    public Medico(String nome, String especialidade, int crm) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public Medico(int id, String nome, String especialidade, int crm) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public int getCrm() {
        return crm;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }  
}


package model;

/**
 *
 * @author aluno.den
 */
public class Paciente {
    private int id;
    private String nomepaciente;
    private String cpf;
    private String telefone;

    
    
    public Paciente() {
    
    }
             
    

    public Paciente(String nomepaciente, String cpf, String telefone) {
        this.nomepaciente = nomepaciente;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Paciente(int id, String nomepaciente, String cpf, String telefone) {
        this.id = id;
        this.nomepaciente = nomepaciente;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNomePaciente() {
        return nomepaciente;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomePaciente(String nomepaciente) {
        this.nomepaciente = nomepaciente;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}


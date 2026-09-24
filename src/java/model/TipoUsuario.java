/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aluno
 */
public class TipoUsuario {
    private int id;
    private String moduloAdministrativo;
    private String moduloAgendamento;
    private String moduloAtendimento;

    public TipoUsuario(int id) {
        this.id = id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0){
            throw new IllegalArgumentException("ID não pode ser menor que 0.");
        } else {
            this.id = id;
        }
    }

    public String getModuloAdministrativo() {
        return moduloAdministrativo;
    }

    public void setModuloAdministrativo(String moduloAdministrativo) {
        if(moduloAdministrativo == null){
            throw new IllegalArgumentException("moduloAdministrativo não pode ser nula.");
        } else{
            this.moduloAdministrativo = moduloAdministrativo;
        }
    }

    public String getModuloAgendamento() {
        return moduloAgendamento;
    }

    public void setModuloAgendamento(String moduloAgendamento) {
        if(moduloAgendamento == null){
            throw new IllegalArgumentException("moduloAgendamento não pode ser nula.");
        } else{
            this.moduloAgendamento = moduloAgendamento;
        }
    }

    public String getModuloAtendimento() {
        return moduloAtendimento;
    }

    public void setModuloAtendimento(String moduloAtendimento) {
        if(moduloAtendimento == null){
            throw new IllegalArgumentException("moduloAtendimento não pode ser nula.");
        } else{
            this.moduloAtendimento = moduloAtendimento;
        }
    }
    
    
}

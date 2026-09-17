/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aluno
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String senha;
    
    public Usuario(int id){
        setId(id);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        if(id < 0){
            throw new IllegalArgumentException("ID não pode ser menor que 0.");
        } else {
            this.id = id;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha == null){
            throw new IllegalArgumentException("Senha não pode ser nula.");
        } else {
            this.senha = senha;
        }
    }
    
    @Override
    public String toString(){
        return "(" + getId() + ", " + getNome() + ", " + getSenha() + ")";
    }
    
}

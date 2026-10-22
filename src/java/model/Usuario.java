/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import framework.util.Hash;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author aluno
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String senha;
    private int tipoUsuarioId;
    private String nascimento;
    private String logadouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String uf;
    private String cep;
    
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

    public void setSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if(senha == null){
            throw new IllegalArgumentException("Senha não pode ser nula.");
        } else {
            String aux = Integer.toString(getId()) + senha;
            String hash = Hash.stringToHash(aux, "SHA-256");
            this.senha = hash;
        }
    }
    
    public void setSenhaHash(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if(senha == null){
            throw new IllegalArgumentException("Senha não pode ser nula.");
        } else {
            this.senha = senha;
        }
    }

    public int getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(int tipoUsuarioId) {
        if(id < 0){
            throw new IllegalArgumentException("TipoUsuarioId não pode ser menor que 0.");
        } else {
            this.tipoUsuarioId = tipoUsuarioId;
        }
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    @Override
    public String toString(){
        return "(" + getId() + ", " + getNome() + ", " + getSenha() + "," + getTipoUsuarioId() + ")";
    }
    
}

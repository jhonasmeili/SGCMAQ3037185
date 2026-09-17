/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Main {
    public static void main(String[] args) throws SQLException{
        //Usuario usuario = new Usuario(15);
        //usuario.setNome("Usuario 13");
        //usuario.setSenha("1313");
        //usuario.setNome("Usuario 15");
        //usuario.setSenha("1500");
        //usuario.setNome("Usuario Novo");
        //usuario.setSenha("1000");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        ArrayList<Usuario> listaUsuarios = usuarioDAO.getAll();
//        System.out.println(listaUsuarios);
//        usuarioDAO.insert(usuario);
        //usuarioDAO.update(usuario);
        //usuarioDAO.delete(usuario);
        
        Usuario usuario = usuarioDAO.getUnique(15);
        System.out.println(usuario);
                
    }
}

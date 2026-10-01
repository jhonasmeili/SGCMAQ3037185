/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import framework.config.AppConfig;
import framework.dao.DataAccessObject;
import framework.dao.DataBaseConnections;

/**
 *
 * @author aluno
 */
public class UsuarioDAO extends DataAccessObject<Usuario>{

    @Override
    public void insert(Usuario t) throws Exception {
        Connection connection = DataBaseConnections.getInstance().getConnection();
        
        String dml = "INSERT INTO usuario (id, nome, senha, tipo_usuario_id) values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(dml);
        preparedStatement.setInt(1, t.getId());
        preparedStatement.setString(2, t.getNome());
        preparedStatement.setString(3, t.getSenha());
        preparedStatement.setInt(4, t.getTipoUsuarioId());
        
        if(AppConfig.getInstance().getConfig("settings", "verbose"). equals("true")){
            System.out.println(preparedStatement);
        }
        
        preparedStatement.execute();
        
        preparedStatement.close();
        DataBaseConnections.getInstance().closeConnection(connection);
    }

    @Override
    public void update(Usuario t) throws Exception {
        Connection connection = DataBaseConnections.getInstance().getConnection();
        
        String dml = "UPDATE usuario  SET nome = ?, senha = ?,  tipo_usuario_id = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(dml);
        preparedStatement.setInt(4, t.getId());
        preparedStatement.setString(1, t.getNome());
        preparedStatement.setString(2, t.getSenha());
        preparedStatement.setInt(3, t.getTipoUsuarioId());
        
        if(AppConfig.getInstance().getConfig("settings", "verbose"). equals("true")){
            System.out.println(preparedStatement);
        }
        
        preparedStatement.execute();
        
        preparedStatement.close();
        DataBaseConnections.getInstance().closeConnection(connection);
    }

    @Override
    public void delete(Usuario t) throws Exception {
        Connection connection = DataBaseConnections.getInstance().getConnection();
        
        String dml = "DELETE FROM usuario WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(dml);
        preparedStatement.setInt(1, t.getId());
        
        if(AppConfig.getInstance().getConfig("settings", "verbose"). equals("true")){
            System.out.println(preparedStatement);
        }
        
        preparedStatement.execute();
        
        preparedStatement.close();
        DataBaseConnections.getInstance().closeConnection(connection);
    }

    @Override
    public Usuario getUnique(Object... values) throws Exception {
        Usuario resultado = null;
        
        Connection connection = DataBaseConnections.getInstance().getConnection();
        
        String dql = "SELECT * FROM usuario WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(dql);
        preparedStatement.setInt(1, (int) values[0]);
        if(AppConfig.getInstance().getConfig("settings", "verbose"). equals("true")){
            System.out.println(preparedStatement);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        
        boolean status = resultSet.next();
        if(status == true){
            resultado = new Usuario((int) resultSet.getObject(1));
            resultado.setNome((String)resultSet.getObject(2));
            resultado.setSenhaHash((String)resultSet.getObject(3));
            resultado.setTipoUsuarioId((int)resultSet.getObject(4));
        }
       
        
        resultSet.close();
        preparedStatement.close();
        DataBaseConnections.getInstance().closeConnection(connection);
        return resultado;
    }

    @Override
    public ArrayList<Usuario> getAll() throws Exception {
        ArrayList<Usuario> resultado = new ArrayList<>();
        Connection connection = DataBaseConnections.getInstance().getConnection();
        
        String dql = "SELECT * FROM  usuario";
        Statement statement = connection.createStatement();
        if(AppConfig.getInstance().getConfig("settings", "verbose"). equals("true")){
            System.out.println(statement);
        }
        ResultSet resultSet = statement.executeQuery(dql);

        while( resultSet.next() ) {
            Usuario usuario = new Usuario((int)resultSet.getObject(1));
            usuario.setNome((String)resultSet.getObject(2));
            usuario.setSenhaHash((String)resultSet.getObject(3));
            usuario.setTipoUsuarioId((int)resultSet.getObject(4));
            
            resultado.add(usuario);
        }
        
        resultSet.close();
        statement.close();
        DataBaseConnections.getInstance().closeConnection(connection);
        return resultado;
    }
    
}

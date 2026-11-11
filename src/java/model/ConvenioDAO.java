/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import framework.dao.DataAccessObject;
import framework.dao.DataBaseConnections;
import framework.config.AppConfig;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jhonasmeili
 */
public class ConvenioDAO extends DataAccessObject<Convenio>{

    @Override
    public void insert(Convenio t) throws Exception {
        Connection connection = DataBaseConnections.getInstance().getConnection();
        
        String dml = "INSERT INTO convenio (id, nome, cnpj, telefone, valor) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(dml);
        preparedStatement.setInt(1, t.getId());
        preparedStatement.setString(2, t.getNome());
        preparedStatement.setString(3, t.getCnpj());
        preparedStatement.setString(4, t.getTelefone());
        preparedStatement.setDouble(5, t.getValor());
        
        if(AppConfig.getInstance().getConfig("settings", "verbose").equals("true")){
            System.out.println(preparedStatement);
        }
        
        preparedStatement.execute();
        
        preparedStatement.close();
        DataBaseConnections.getInstance().closeConnection(connection);
    }

    @Override
    public void update(Convenio t) throws Exception {
        Connection connection = DataBaseConnections.getInstance().getConnection();
        
        String dml = "UPDATE convenio SET nome = ?, cnpj = ?, telefone = ?, valor = ? WHERE id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(dml);
        preparedStatement.setInt(5, t.getId());
        preparedStatement.setString(1, t.getNome());
        preparedStatement.setString(2, t.getCnpj());
        preparedStatement.setString(3, t.getTelefone());
        preparedStatement.setDouble(4, t.getValor());
        
        if(AppConfig.getInstance().getConfig("settings", "verbose").equals("true")){
            System.out.println(preparedStatement);
        }
        
        preparedStatement.execute();
        
        preparedStatement.close();
        DataBaseConnections.getInstance().closeConnection(connection);
    }

    @Override
    public void delete(Convenio t) throws Exception {
        Connection connection = DataBaseConnections.getInstance().getConnection();
        
        String dml = "DELETE FROM convenio WHERE id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(dml);
        preparedStatement.setInt(1, t.getId());
        
        
        if(AppConfig.getInstance().getConfig("settings", "verbose").equals("true")){
            System.out.println(preparedStatement);
        }
        
        preparedStatement.execute();
        
        preparedStatement.close();
        DataBaseConnections.getInstance().closeConnection(connection);
    }

    @Override
    public Convenio getUnique(Object... values) throws Exception {
        Convenio convenio = null;
        
        Connection connection = DataBaseConnections.getInstance().getConnection();
        
        String dql = "SELECT * FROM convenio WHERE id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(dql);
        preparedStatement.setInt(1, (int) values[0]);
        
        if(AppConfig.getInstance().getConfig("settings", "verbose").equals("true")){
            System.out.println(preparedStatement);
        }
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        Boolean status = resultSet.next();
        if(status == true){
            convenio = new Convenio((int) resultSet.getObject(1));
            convenio.setNome((String) resultSet.getObject(2));
            convenio.setCnpj((String) resultSet.getObject(3));
            convenio.setTelefone((String) resultSet.getObject(4));
            convenio.setValor((double) resultSet.getObject(5));
        }
        
        resultSet.close();
        preparedStatement.close();
        DataBaseConnections.getInstance().closeConnection(connection);
        
        return convenio;
    }

    @Override
    public ArrayList<Convenio> getAll() throws Exception {
        ArrayList<Convenio> resultado = new ArrayList<>();
        
        Connection connection = DataBaseConnections.getInstance().getConnection();
        
        String dql = "SELECT * FROM convenio";
        
        Statement statement = connection.createStatement();
        
        if(AppConfig.getInstance().getConfig("settings", "verbose").equals("true")){
            System.out.println(statement);
        }
        
        ResultSet resultSet = statement.executeQuery(dql);
        
        while(resultSet.next()){
            Convenio convenio = new Convenio((int) resultSet.getObject(1));
            convenio.setNome((String) resultSet.getObject(2));
            convenio.setCnpj((String) resultSet.getObject(3));
            convenio.setTelefone((String) resultSet.getObject(4));
            float aux = (float) resultSet.getObject(5);
            convenio.setValor(aux);
            
            resultado.add(convenio);
        }
        
        resultSet.close();
        statement.close();
        DataBaseConnections.getInstance().closeConnection(connection);
        
        return resultado;
    }
    
}

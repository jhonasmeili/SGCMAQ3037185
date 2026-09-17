/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package framework.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public abstract class DataAccessObject <T> {
    
    public abstract void insert(T t) throws SQLException;
    public abstract void update(T t) throws SQLException;
    public abstract void delete(T t) throws SQLException;
    
    public abstract T getUnique(Object... values) throws SQLException;
    public abstract ArrayList<T> getAll() throws SQLException;
}

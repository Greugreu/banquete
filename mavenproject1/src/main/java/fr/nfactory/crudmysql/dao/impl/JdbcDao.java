/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Représente l'accès à la base, la création de la connexion à la base
public class JdbcDao {
    
    // static final : attribut constant
    private static final String URL="jdbc:mysql://localhost:3307/banquete";   
    // postgre : jdbc:postgresql://hostname:port/dbname
    private static final String USER="root";
    private static final String PASS="root";
    
    private Connection connection;
    
    // throws : on laisse la méthode qui va appeler le constructeur gérer l'exception
    public JdbcDao() throws SQLException{
        this.connection = DriverManager.getConnection(URL, USER, PASS);
        //postgre this.connection = DriverManager.getConnection("jdbc:postgresql://hostname:port/dbname", "root", "root");
    }
    
    protected Connection getConnection(){
        return this.connection;
    } 
}

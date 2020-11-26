/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.dao.impl;

import fr.nfactory.crudmysql.beans.Clients;
import fr.nfactory.crudmysql.dao.ClientsDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ludivine
 */
public class Launcher {
    
    //main : le point d'entrée de l'application
    // ... entre 0 et n valeurs qui seront récupérées dans un tableau appel => main("toto","zozo")
    // ... peut le remplace par String[] appel => main(["toto","zozo"])
    public static void main(String... args){
        try {
            ArrayList<Alcool> alcools = DaoFactory.getAlcoolDao().getAll();
            MainFrame mf = new MainFrame(alcools);
            //mf.setVisible(true);
            
            // test du crud
            
            /*ArrayList<Alcool> alcools = DaoFactory.getAlcoolDao().getAll();
            alcools.forEach(System.out::println);
            for(Alcool a : alcools){
                System.out.println(a);
            }
            System.out.println("Le premier alcool est "+ DaoFactory.getAlcoolDao().get(1));
            DaoFactory.getAlcoolDao().add(new Alcool("Bacardi",40,0.75));
            DaoFactory.getAlcoolDao().delete(6);*/
        } catch (SQLException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

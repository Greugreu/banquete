/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.dao;

import fr.nfactory.crudmysql.dao.impl.AlcoolDaoJdbc;
import java.sql.SQLException;

/**
 *
 * @author ludivine
 */
public class DaoFactory {
    
    // static on passe par la classe et non l'objet pour y accéder
    private static AlcoolDao alcoolDao;
    
    private DaoFactory(){
        throw new IllegalStateException();
    }
    
    // Objectif : singleton, une instance par exécution, évite les problèmes d'incohérence en DB et d'accès concurrents à la 
    public static AlcoolDao getAlcoolDao() throws SQLException{
        if(alcoolDao == null){
            alcoolDao = new AlcoolDaoJdbc();
        }
        return alcoolDao;
    }
    
}

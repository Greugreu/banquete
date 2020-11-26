/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.dao;

import fr.nfactory.crudmysql.beans.Clients;
import java.util.ArrayList;

/**
 *
 * @author ludivine
 */
public interface ClientsDao {
    public void add(Clients clients);
    public ArrayList<Clients> getAll();
    public Clients get(int idclients);
    public boolean delete(int idclients);    
}

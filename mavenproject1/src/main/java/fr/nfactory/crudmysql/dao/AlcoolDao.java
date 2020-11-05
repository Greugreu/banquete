/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.dao;

import fr.nfactory.crudmysql.beans.Alcool;
import java.util.ArrayList;

/**
 *
 * @author ludivine
 */
public interface AlcoolDao {
    public void add(Alcool alcool);
    public ArrayList<Alcool> getAll();
    public Alcool get(int id);
    public boolean delete(int id);    
}

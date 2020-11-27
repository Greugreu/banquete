/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.dao;

import fr.nfactory.crudmysql.beans.Offers;
import java.util.ArrayList;

/**
 *
 * @author ludivine
 */
public interface OffersDao {
    public void add(Offers offers);
    public ArrayList<Offers> getAll();
    public Offers get(int idoffers);
    public boolean delete(int idoffers);    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.dao.impl;

import fr.nfactory.crudmysql.beans.Alcool;
import fr.nfactory.crudmysql.dao.AlcoolDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ludivine
 */
public class AlcoolDaoJdbc extends JdbcDao implements AlcoolDao{
    
    public AlcoolDaoJdbc() throws SQLException{
        super();
    }

    @Override
    public void add(Alcool alcool) {
        try{
            // préviens de l'injection SQL
            String sql = "INSERT INTO alcools(name,degre,volume) VALUES(?,?,?)";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, alcool.getName());
            statement.setDouble(2, alcool.getDegre());
            statement.setDouble(3, alcool.getVolume()); 
            // ATTENTION PAS SELECT => executeUpdate();
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Alcool> getAll() {
        ArrayList<Alcool> alcools = new ArrayList<>();
        try{
            String sql = "SELECT * FROM alcools";
            PreparedStatement ps = getConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // on va parcourir les lignes de la table "sql' renvoyée
            while(rs.next()){
                // transformer la ligne sql en un object java
                alcools.add(transformSqlToAlcool(rs));
            }
        } catch (SQLException se){
            // affiche l'erreur en console
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return alcools;
    }

    @Override
    public Alcool get(int id) {
        Alcool a = new Alcool();
        try{
            String sql = "SELECT * FROM alcools WHERE id = ?";
            PreparedStatement ps = getConnection().prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            // on va parcourir les lignes de la table "sql' renvoyée
            if(rs.next()){
                // transformer la ligne sql en un object java
                a = transformSqlToAlcool(rs);
            }
        } catch (SQLException se){
            // affiche l'erreur en console
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean delete(int id) {
        try{
            // préviens de l'injection SQL
            String sql = "DELETE FROM alcools  WHERE id = ?";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            // ATTENTION PAS SELECT => executeUpdate();
            statement.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    private Alcool transformSqlToAlcool(ResultSet rs) throws SQLException{
        Alcool alcool = new Alcool();
        alcool.setId(rs.getInt("id"));
        alcool.setName(rs.getString("name"));
        alcool.setDegre(rs.getDouble("degre"));
        alcool.setVolume(rs.getDouble("volume"));
        return alcool;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.dao.impl;

import fr.nfactory.crudmysql.beans.Offers;
import fr.nfactory.crudmysql.dao.OffersDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ludivine
 */
public class OffersDaoJdbc extends JdbcDao implements OffersDao{
    
    public OffersDaoJdbc() throws SQLException{
        super();
    }

    @Override
    public void add(Offers offers) {
        try{
            // préviens de l'injection SQL
            String sql = "INSERT INTO offers(offersName, offersPrice, ageMini, ageMax, details, createdAt, modifiedAt) VALUES ?,?,?,?,?,?,?";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, offers.getOffersName());
            statement.setFloat(2, offers.getOffersPrice());
            statement.setInt(3, offers.getAgeMini());
            statement.setInt(4, offers.getAgeMax());
            statement.setString(5, offers.getDetails());
            statement.setInt(13, offers.getCreatedAt());
            statement.setInt(14, offers.getModifiedAt());
            // ATTENTION PAS SELECT => executeUpdate();
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Offers> getAll() {
        ArrayList<Offers> offers = new ArrayList<>();
        try{
            String sql = "SELECT * FROM offers";
            PreparedStatement ps = getConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // on va parcourir les lignes de la table "sql' renvoyée
            while(rs.next()){
                // transformer la ligne sql en un object java
                offers.add(transformSqlToOffers(rs));
            }
        } catch (SQLException se){
            // affiche l'erreur en console
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return offers;
    }

    @Override
    public Offers get(int idoffers) {
        Offers a = new Offers();
        try{
            String sql = "SELECT * FROM offers WHERE idoffers = ?";
            PreparedStatement ps = getConnection().prepareCall(sql);
            ps.setInt(1, idoffers);
            ResultSet rs = ps.executeQuery();
            // on va parcourir les lignes de la table "sql' renvoyée
            if(rs.next()){
                // transformer la ligne sql en un object java
                a = transformSqlToOffers(rs);
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
    public boolean delete(int idoffers) {
        try{
            // préviens de l'injection SQL
            String sql = "DELETE FROM offers  WHERE id = ?";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, idoffers);
            // ATTENTION PAS SELECT => executeUpdate();
            statement.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    private Offers transformSqlToOffers(ResultSet rs) throws SQLException{
        Offers offers = new Offers();
        offers.setOffersName(rs.getString("offersName"));
        offers.setOffersPrice(rs.getFloat("offersPrice"));
        offers.setAgeMini(rs.getInt("ageMini"));
        offers.setAgeMax(rs.getInt("ageMax"));
        offers.setDetails(rs.getString("details"));
        offers.setCreatedAt(rs.getInt("createdAt"));
        offers.setModifiedAt(rs.getInt("modifiedAt"));
        
        return offers;
    }
    
}

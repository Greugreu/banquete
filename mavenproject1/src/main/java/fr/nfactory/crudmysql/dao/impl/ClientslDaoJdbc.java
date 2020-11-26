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

/**
 *
 * @author ludivine
 */
public class ClientslDaoJdbc extends JdbcDao implements ClientsDao{
    
    public ClientslDaoJdbc() throws SQLException{
        super();
    }

    @Override
    public void add(Clients clients) {
        try{
            // préviens de l'injection SQL
            String sql = "INSERT INTO clients(clientsNme, clientsSurname, birthdate, tel, situation, kids, income, isContact, job, mail, adress, gender, createdAt, modifiedAt) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, clients.getClientsName());
            statement.setString(2, clients.getClientsSurname());
            statement.setInt(3, clients.getBirthdate());
            statement.setInt(4, clients.getTel());
            statement.setString(5, clients.getSituation());
            statement.setInt(6, clients.getKids());
            statement.setDouble(7, clients.getIncome());
            statement.setInt(8, clients.getIsContact());
            statement.setString(9, clients.getJob());
            statement.setString(10, clients.getMail());
            statement.setString(11, clients.getAdress());
            statement.setString(12, clients.getGender());
            statement.setInt(13, clients.getCreatedAt());
            statement.setInt(14, clients.getModifiedAt());
            // ATTENTION PAS SELECT => executeUpdate();
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Clients> getAll() {
        ArrayList<Clients> clients = new ArrayList<>();
        try{
            String sql = "SELECT * FROM clients";
            PreparedStatement ps = getConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // on va parcourir les lignes de la table "sql' renvoyée
            while(rs.next()){
                // transformer la ligne sql en un object java
                clients.add(transformSqlToClients(rs));
            }
        } catch (SQLException se){
            // affiche l'erreur en console
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Clients get(int idclients) {
        Clients a = new Clients();
        try{
            String sql = "SELECT * FROM clients WHERE idclients = ?";
            PreparedStatement ps = getConnection().prepareCall(sql);
            ps.setInt(1, idclients);
            ResultSet rs = ps.executeQuery();
            // on va parcourir les lignes de la table "sql' renvoyée
            if(rs.next()){
                // transformer la ligne sql en un object java
                a = transformSqlToClients(rs);
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
    public boolean delete(int idclients) {
        try{
            // préviens de l'injection SQL
            String sql = "DELETE FROM clients  WHERE id = ?";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, idclients);
            // ATTENTION PAS SELECT => executeUpdate();
            statement.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    private Clients transformSqlToClients(ResultSet rs) throws SQLException{
        Clients clients = new Clients();
        clients.setIdClients(rs.getInt("idclients"));
        clients.setClientsName(rs.getString("clientsName"));
        clients.setClientsSurname(rs.getString("clientsSurname"));
        clients.setBirthdate(rs.getInt("birthdate"));
        clients.setTel(rs.getInt("tel"));
        clients.setSituation(rs.getString("situation"));
        clients.setKids(rs.getInt("kids"));
        clients.setIncome(rs.getDouble("income"));
        clients.setIsContact(rs.getInt("isContact"));
        clients.setJob(rs.getString("job"));
        clients.setMail(rs.getString("mail"));
        clients.setAdress(rs.getString("adress"));
        clients.setGender(rs.getString("gender"));
        clients.setCreatedAt(rs.getInt("createdAt"));
        clients.setModifiedAt(rs.getInt("modifiedAt"));
        
        return clients;
    }
    
}

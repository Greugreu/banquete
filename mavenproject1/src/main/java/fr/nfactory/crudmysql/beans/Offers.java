/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.beans;

/**
 *
 * @author ludivine
 */
// Javabeans une classe qui a un constructeur par défaut, les attributs privés et les ascesseurs
public class Offers {
    
    private int idoffers;
    private String offersName;
    private float offersPrice;
    private int ageMini;
    private int ageMax;
    private String details;
    private int createdAt;
    private int modifiedAt;
    
    public Offers(){} // si aucun constructeur n'est délacaré, la JVM en crée un d'office par défaut

    public Offers(int idoffers, String offersName, float offersPrice, int ageMini, int ageMax, String details, int createdAt, int modifiedAt) {
        this.idoffers = idoffers;
        this.offersName = offersName;
        this.offersPrice = offersPrice;
        this.ageMini = ageMini;
        this.ageMax = ageMax;
        this.details = details;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public int getIdoffers() {
        return idoffers;
    }

    public void setIdoffers(int idoffers) {
        this.idoffers = idoffers;
    }

    public String getOffersName() {
        return offersName;
    }

    public void setOffersName(String offersName) {
        this.offersName = offersName;
    }

    public float getOffersPrice() {
        return offersPrice;
    }

    public void setOffersPrice(float offersPrice) {
        this.offersPrice = offersPrice;
    }

    public int getAgeMini() {
        return ageMini;
    }

    public void setAgeMini(int ageMini) {
        this.ageMini = ageMini;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public int getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(int modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "Offres{" + "idoffers=" + idoffers + ", offersName=" + offersName + ", offersPrice=" + offersPrice + ", ageMini=" + ageMini + ", ageMax=" + ageMax + ", details=" + details + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + '}';
    }
    
    
}
   

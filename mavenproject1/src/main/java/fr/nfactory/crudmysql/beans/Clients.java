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
public class Clients {
    
    private int idclients;
    private String clientsName;
    private String clientsSurname;
    private int birthdate;
    private int tel;
    private String situation;
    private int kids;
    private Double income;
    private int isContact;
    private String job;
    private String mail;
    private String adress;
    private String gender;
    private int createdAt;
    private int modifiedAt;
    
    public Clients(){} // si aucun constructeur n'est délacaré, la JVM en crée un d'office par défaut

    public Clients(int idclients, String clientsName, String clientsSurname, int birthdate, int tel, String situation, int kids, Double income, int isContact, String job, String mail, String adress, String gender, int createdAt, int modifiedAt) {
        this.idclients = idclients;
        this.clientsName = clientsName;
        this.clientsSurname = clientsSurname;
        this.birthdate = birthdate;
        this.tel = tel;
        this.situation = situation;
        this.kids = kids;
        this.income = income;
        this.isContact = isContact;
        this.job = job;
        this.mail = mail;
        this.adress = adress;
        this.gender = gender;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public int getIdclients() {
        return idclients;
    }

    public void setIdclients(int idclients) {
        this.idclients = idclients;
    }

    public String getClientsName() {
        return clientsName;
    }

    public void setClientsName(String clientsName) {
        this.clientsName = clientsName;
    }

    public String getClientsSurname() {
        return clientsSurname;
    }

    public void setClientsSurname(String clientsSurname) {
        this.clientsSurname = clientsSurname;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public int getKids() {
        return kids;
    }

    public void setKids(int kids) {
        this.kids = kids;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public int getIsContact() {
        return isContact;
    }

    public void setIsContact(int isContact) {
        this.isContact = isContact;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

   
    // si toString n'est pas défini explicetement par défaut elle renvoie l'adresse de l'objet en mémoire

    @Override
    public String toString() {
        return "Clients{" + "idclients=" + idclients + ", clientsName=" + clientsName + ", clientsSurname=" + clientsSurname + ", birthdate=" + birthdate + ", tel=" + tel + ", situation=" + situation + ", kids=" + kids + ", income=" + income + ", isContact=" + isContact + ", job=" + job + ", mail=" + mail + ", adress=" + adress + ", gender=" + gender + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + '}';
    }
    
}

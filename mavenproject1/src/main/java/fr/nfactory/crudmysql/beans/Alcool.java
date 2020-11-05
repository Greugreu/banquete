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
public class Alcool {
    
    private int id;
    private String name;
    private double degre;
    private double volume;
    
    public Alcool(){} // si aucun constructeur n'est délacaré, la JVM en crée un d'office par défaut

    public Alcool(int id, String name, double degre, double volume) {
        this.id = id;
        this.name = name;
        this.degre = degre;
        this.volume = volume;
    }
    public Alcool(String name, double degre, double volume) {
        this.name = name;
        this.degre = degre;
        this.volume = volume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDegre() {
        return degre;
    }

    public void setDegre(double degre) {
        this.degre = degre;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Alcool{" + "id=" + id + ", name=" + name + ", degre=" + degre + ", volume=" + volume + '}';
    }
    // si toString n'est pas défini explicetement par défaut elle renvoie l'adresse de l'objet en mémoire
    
}

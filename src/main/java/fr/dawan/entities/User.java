package fr.dawan.entities;

import java.beans.Transient;
import java.io.Serializable;

/**
 * JavaBean: Objet
 * Serializable : Un objet qui a une identité unique, ce qui lui permet d'être identifiable dans une base de données ou un fichier texte.
 */
public class User implements Serializable {

    private String nom;
    private String prenom;
    private String id;


    // Permet d'ignorer une propriété lors d'un enregistrement dans une base de données par exemple
    transient private String password;

    public User() {

    }

    public User(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public User(String id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}

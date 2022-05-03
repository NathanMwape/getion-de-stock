/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_stock;

/**
 *
 * @author NATHAN
 */
public class facture {
    
    String designation;
    String date;
    int id;
    int quantite;
   int  prix_unitaire;
    int prix_total;

    public facture(String designation, String date, int id, int quantite, int prix_unitaire, int prix_total) {
        this.designation = designation;
        this.date = date;
        this.id = id;
        this.quantite = quantite;
        this.prix_unitaire = prix_unitaire;
        this.prix_total = prix_total;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getPrix_unitaire() {
        return prix_unitaire;
    }

    public int getPrix_total() {
        return prix_total;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix_unitaire(int prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public void setPrix_total(int prix_total) {
        this.prix_total = prix_total;
    }
    
    
    
}

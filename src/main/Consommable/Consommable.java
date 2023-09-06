package main.Consommable;

import main.App;
import main.Joueur;

public class Consommable {
    
    private int prix;
    private String nom;

    public Consommable(int prix, String nom){
        this.prix = prix;
        this.nom = nom;
    }

    public String effet(){
        return "ceci est un " + nom + " qui coute " + prix;
    }

    public void achete(){
        int argent_restant = App.joueur.getArgent() - prix;
        App.joueur.setArgent(argent_restant);
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

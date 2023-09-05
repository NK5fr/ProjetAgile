package main.Consommable;

public class Bonheur extends Consommable{
    
    private int bonheur;

    public Bonheur(int bonheur, int prix, String nom){
        super(prix, nom);
        this.bonheur = bonheur;
    }

    public String effet(){
        return "Ceci est un " + this.getNom() + " qui coute " + getPrix() + " pour gagner " + bonheur +" point de bonheur.";
    }
}

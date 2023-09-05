package main.Consommable;

public class Nourriture extends Consommable{
    
    private int faim;

    public Nourriture(int faim, int prix, String nom){
        super(prix, nom);
        this.faim = faim;
    }

    public String effet(){
        return "Ceci est un " + this.getNom() + " qui coute " + getPrix() + " pour gagner " + faim +" point de nourriture.";
    }

}

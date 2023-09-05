package main.Boutique;

import java.util.ArrayList;
import java.util.List;

import main.Consommable.*;

public class Boutique {
    
    private List<Consommable> consommables;

    public Boutique(){
        this.consommables = new ArrayList<Consommable>();
    }

    public static void main(String[] args){
        Boutique b = new Boutique();
        b.consommables.add(new Nourriture(5,8,"pizza"));
        b.consommables.add(new Nourriture(8,6,"kebab"));
        b.consommables.add(new Nourriture(10,15,"tacos"));
        b.consommables.add(new Nourriture(15,12,"sushi"));
        b.consommables.add(new Nourriture(20,17,"raclette"));

        b.consommables.add(new Bonheur(10,5,"vetement"));
        b.consommables.add(new Bonheur(15,100,"voiture"));
        b.consommables.add(new Bonheur(20,1000,"maison"));
        b.consommables.add(new Bonheur(75,10000,"femme"));
        b.consommables.add(new Bonheur(50,7000,"enfant"));

        for(Consommable c: b.consommables){
            b.afficher(c);
        }
    }

    public void afficher(Consommable c){
        System.out.println(c.effet());
        // if(c instanceof Bonheur){
        //     System.out.println(c.getNom() + " pour " + c.getPrix() + " vous donneras ");
        // }
    }
}

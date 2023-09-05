package main.Boutique;

import java.util.ArrayList;
import java.util.List;

import main.Consommable.*;

public class Boutique {
    
    private List<Consommable> consommables;

    public Boutique(){
        this.consommables = new ArrayList<Consommable>();
    }

    public void initialiserConsommable(){
        this.consommables.add(new Nourriture(5,8,"pizza"));
        this.consommables.add(new Nourriture(8,6,"kebab"));
        this.consommables.add(new Nourriture(10,15,"tacos"));
        this.consommables.add(new Nourriture(15,12,"sushi"));
        this.consommables.add(new Nourriture(20,17,"raclette"));

        this.consommables.add(new Bonheur(10,5,"vetement"));
        this.consommables.add(new Bonheur(15,100,"voiture"));
        this.consommables.add(new Bonheur(20,1000,"maison"));
        this.consommables.add(new Bonheur(25,10000,"femme"));
        this.consommables.add(new Bonheur(30,7000,"enfant"));
    }

    public static void main(String[] args){
        Boutique b = new Boutique();
        b.initialiserConsommable();

        for(Consommable c: b.consommables){
            b.afficher(c);
        }

        b.afficherBonheur();
        b.afficherNourriture();
    }

    public void afficher(Consommable c){
        System.out.println(c.effet());
    }

    public void afficherNourriture(){
        List<Consommable> n = new ArrayList<Consommable>();
        for(Consommable c: this.consommables){
            if(c instanceof Nourriture){
                n.add(c);
            }
        }
        for(Consommable c: n){
            this.afficher(c);
        }
    }

    public void afficherBonheur(){
        List<Consommable> n = new ArrayList<Consommable>();
        for(Consommable c: this.consommables){
            if(c instanceof Bonheur){
                n.add(c);
            }
        }
        for(Consommable c: n){
            this.afficher(c);
        }
    }
}

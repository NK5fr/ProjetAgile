package main.Boutique;

import java.util.ArrayList;
import java.util.List;

import main.App;
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

        // for(Consommable c: b.consommables){
        //     b.afficher(c);
        // }



        b.afficherBonheur();
        // b.afficherNourriture();
    }

    public void afficher(Consommable c, int i){
        System.out.println(c.effet());
        System.out.println();
    }

    public void afficherMenu(){
        char car;
        do{
           //this.afficherBoutique();
            System.out.println("Bienvenue dans la Boutique.\n"
            + "Içi, vous pouvez acheter: \n"
            + "n - De la nourriture, pour vous nourrir"
            + "b - Des biens divers pour vous rendre heureux");
            car = App.ecouterChar(); 
        }while(car == 'n' || car == 'b');
        
        if(car == 'n'){
            this.afficherNourriture();
        }else if(car == 'b'){
            this.afficherBonheur();
        }
        
    }

    public void afficherNourriture(){
        int i = 0;
        for(Consommable c: this.consommables){
            if(c instanceof Nourriture){
                this.afficher(c,i);
                i++;
            }
        }
    }

    public void afficherBonheur(){
        int i = 0;
        for(Consommable c: this.consommables){
            if(c instanceof Bonheur){
                this.afficher(c,i);
                i++;
            }
        }
    }
}

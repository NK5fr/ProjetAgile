package main.Boutique;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.App;
import main.Bingo.bingo;
import main.Consommable.*;


public class Boutique {
    

    private List<Consommable> consommables;

    public Boutique(){
        this.consommables = new ArrayList<Consommable>();
        this.initialiserConsommable();
    }

    public void initialiserConsommable(){

        this.consommables.add(new Nourriture(1,1,"Terre"));
        this.consommables.add(new Nourriture(5,5,"Legume"));
        this.consommables.add(new Nourriture(7,10,"Pomme de terre"));
        this.consommables.add(new Nourriture(10,15,"Pizza"));
        this.consommables.add(new Nourriture(15,20,"Sushi"));
        this.consommables.add(new Nourriture(18,25,"Steak"));
        this.consommables.add(new Nourriture(22,30,"Kebab"));
        this.consommables.add(new Nourriture(26,40,"Tacos"));
        this.consommables.add(new Nourriture(30,50,"Raclette"));
        this.consommables.add(new Nourriture(5,500,"caviar"));
        
        
        

        this.consommables.add(new Bonheur(10,5,"Vetement"));
        this.consommables.add(new Bonheur(30,7000,"Jeux"));
        this.consommables.add(new Bonheur(15,100,"Voiture"));
        this.consommables.add(new Bonheur(20,1000,"Maison"));
        this.consommables.add(new Bonheur(25,10000,"Femme"));
        this.consommables.add(new Bonheur(30,7000,"Enfant"));
        this.consommables.add(new Bonheur(30,7000,"Voiture de luxe"));
        this.consommables.add(new Bonheur(30,7000,"Bateau"));
        this.consommables.add(new Bonheur(30,7000,"Avion"));
        this.consommables.add(new Bonheur(30,7000,"Lune"));
    }

    public static void main(String[] args){
        Boutique b = new Boutique();
        b.afficherMenu();
    }

    public void afficher(Consommable c, int i){
        // System.out.println(c.effet());
        System.out.println("_________________________________________________________________________________________\n");
        System.out.println(i + " | " + c.getNom() + " | " + c.getPrix() + " | " + c.effet());
        
    }

    public void menu() throws InterruptedException{
        char car = ' ';
        do{
            car = afficherMenu();
            if(car != 'q'){
                achat(car);
            }
        }while(car != 'q');
        System.out.println(car);
    }
    
    public char afficherMenu(){
        String car;
        do{
            bingo.clear();
            bingo.afficherTitre("Boutique");
            System.out.println("Bienvenue dans la Boutique.\n"
            + "Içi, vous pouvez acheter: \n"
            + "N - De la nourriture, pour vous nourrir\n"
            + "B - Des biens divers pour vous rendre heureux\n"
            + "T - Afficher tout\n"
            + "Q - Quitter\n");
            car = "" + App.ecouterChar(); 
            car = car.toLowerCase();
        }while(!car.equals("n") && !car.equals("b") && !car.equals("t") && !car.equals("q"));
        return car.charAt(0);
    }

    public void achat(char car) throws InterruptedException{
        
            
        int choix = 21;
        do{
            bingo.clear();
            if(car == 't'){
                this.afficherTout();

                do{
                    System.out.println("Taper le chiffre de ce que vous voulez acheter, ou taper 0 pour revenir en arriere: ");
                    choix = App.scanner.nextInt();
                }while(choix<0 && choix>20);
                this.acheterTout(choix);

            }else{
                if(car == 'n'){
                    this.afficherNourriture();
                }else if(car == 'b'){
                    this.afficherBonheur();
                }

                do{
                    System.out.println("Taper le chiffre de ce que vous voulez acheter, ou taper 0 pour revenir en arriere: ");
                    choix = App.scanner.nextInt();
                }while(choix<0 && choix>10);
                if(car == 'n'){
                    this.acheterNourriture(choix);
                }else if(car == 'b'){
                    this.acheterBonheur(choix);
                }
            }
        }while(choix != 0);
    }

    public void acheterBonheur(int j) throws InterruptedException{
        int i = 0;
        for(Consommable c: this.consommables){
            if(c instanceof Bonheur){
                i++;
            }
            if(i == j){
                c.achete();
            }
        }
    }

    public void acheterNourriture(int j) throws InterruptedException{
        int i = 0;
        for(Consommable c: this.consommables){
            if(c instanceof Nourriture){
                i++;
            }
            if(i == j){
                c.achete();
            }
        }
    }

    public void acheterTout(int j) throws InterruptedException{
        int i = 0;
        for(Consommable c: this.consommables){
            i++;
            if(i == j){
                c.achete();
            }
        }
    }

    public void afficherNourriture(){
        int i = 1;
        for(Consommable c: this.consommables){
            if(c instanceof Nourriture){
                this.afficher(c,i);
                i++;
            }
        }
        System.out.println("_________________________________________________________________________________________\n");
    }

    public void afficherBonheur(){
        int i = 1;
        for(Consommable c: this.consommables){
            if(c instanceof Bonheur){
                this.afficher(c,i);
                i++;
            }
        }
        System.out.println("_________________________________________________________________________________________\n");
    }

    public void afficherTout(){
        int i = 1;
        for(Consommable c: this.consommables){
            this.afficher(c, i);
            i++;
        }
    }
}

package main.Lotterie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.App;
import main.Jeu;
import main.Joueur;
import main.Bingo.bingo;


public class Lotterie implements Jeu{

    private List<Integer> boules;
    private List<Integer> predictionBoules;
    private List<Integer> tirages;
    
    private final static Random RAND = new Random();

    public Lotterie() {
        this.predictionBoules = new ArrayList<>();
        this.boules = new ArrayList<>();
        for (int number = 1; number < 46; number++) {
            boules.add(number);
        }
    }

    public List<Integer> getBoules() {
        return boules;
    }

    public List<Integer> getPredictionBoules() {
        return predictionBoules;
    }

    public List<Integer> getTirages() {
        return tirages;
    }

    public void input_user() {
        boolean bon_input;
        int boule1 = 0;
        int boule2 = 0;
        int boule3 = 0;
        int boule4 = 0;
        int boule5 = 0;
        int boule6 = 0;
        do {
            bon_input = true;
            System.out.println("Entrez les 6 numeros (un par un)");
            
            boule1 = App.scanner.nextInt();
            boule2 = App.scanner.nextInt();
            boule3 = App.scanner.nextInt();
            boule4 = App.scanner.nextInt();
            boule5 = App.scanner.nextInt();
            boule6 = App.scanner.nextInt();
            if(0 < boule1 && boule1 < 46) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 1 n'est pas comprise entre 1 et 45");
            }
            if(0 < boule2 && boule2 < 46) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 2 n'est pas comprise entre 1 et 45");
            }
            if(0 < boule3 && boule3 < 46) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 3 n'est pas comprise entre 1 et 45");
            }
            if(0 < boule4 && boule4 < 46) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 4 n'est pas comprise entre 1 et 45");
            }
            if(0 < boule5 && boule5 < 46) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 5 n'est pas comprise entre 1 et 45");
            }
            if(0 < boule6 && boule6 < 46) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 6 n'est pas comprise entre 1 et 45");
            }
        }while(!bon_input);
        this.predictionBoules.add(boule1);
        this.predictionBoules.add(boule2);
        this.predictionBoules.add(boule3);
        this.predictionBoules.add(boule4);
        this.predictionBoules.add(boule5);
        this.predictionBoules.add(boule6);     
    }



    public void tirage() {
        int i = 0;
        List<Integer> tirer = new ArrayList<>();
        while (tirer.size() != 6) {
            int tirage = RAND.nextInt(45-i);
            i++;
            int boule_tirer = this.getBoules().remove(tirage);
            tirer.add(boule_tirer);
        }
        this.tirages = tirer;
    }

    @Override
    public void tricher() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tricher'");
    }

    @Override
    public void jouer(Joueur joueur) {
        boolean trouver = true;
        int nb_trouver = 0;
        bingo.afficherTitre("Loterie");
        Lotterie l = new Lotterie();
        l.input_user();
        l.tirage();
        System.out.println("Le tirages est:" + l.getTirages());
        System.out.println("Votre prédiction est:" + l.getPredictionBoules());
        for (Integer integer : l.getTirages()) {
            if (l.getPredictionBoules().contains(integer)){
                trouver = trouver && true;
                nb_trouver++;
            }
            else {
                trouver = false;
            }
        }
        if (trouver) {
            this.victoire(joueur);
        }else {
            this.defaite(joueur);
        }
    }

    @Override
    public void victoire(Joueur joueur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'victoire'");
    }

    @Override
    public void defaite(Joueur joueur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defaite'");
    }

    @Override
    public void baisserTemps() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'baisserTemps'");
    }

    @Override
    public int duree() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'duree'");
    }
}
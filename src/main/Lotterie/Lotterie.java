package main.Lotterie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Lotterie {

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
        Scanner sc = new Scanner(System.in);
        do {
            bon_input = true;
            System.out.println("Entrez les 6 numeros (un par un)");
            
            boule1 = sc.nextInt();
            boule2 = sc.nextInt();
            boule3 = sc.nextInt();
            boule4 = sc.nextInt();
            boule5 = sc.nextInt();
            boule6 = sc.nextInt();
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
        sc.close();
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

    public static void main(String[] args) {
        boolean trouver = true;
        int nb_trouver = 0;
        System.out.println(".----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------."); 
        System.out.println("| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |");
        System.out.println("| |   _____      | || |     ____     | || |  _________   | || |  _________   | || |  _________   | || |  _______     | || |     _____    | || |  _______     | || |  _________   | |");
        System.out.println("| |  |_   _|     | || |   .'    `.   | || | |  _   _  |  | || | |  _   _  |  | || | |_   ___  |  | || | |_   __ \\    | || |    |_   _|   | || | |_   __ \\    | || | |_   ___  |  | |");
        System.out.println("| |    | |       | || |  /  .--.  \\  | || | |_/ | | \\_|  | || | |_/ | | \\_|  | || |   | |_  \\_|  | || |   | |__) |   | || |      | |     | || |   | |__) |   | || |   | |_  \\_|  | |");
        System.out.println("| |    | |   _   | || |  | |    | |  | || |     | |      | || |     | |      | || |   |  _|  _   | || |   |  __ /    | || |      | |     | || |   |  __ /    | || |   |  _|  _   | |");
        System.out.println("| |   _| |__/ |  | || |  \\  `--'  /  | || |    _| |_     | || |    _| |_     | || |  _| |___/ |  | || |  _| |  \\ \\_  | || |     _| |_    | || |  _| |  \\ \\_  | || |  _| |___/ |  | |");
        System.out.println("| |  |________|  | || |   `.____.'   | || |   |_____|    | || |   |_____|    | || | |_________|  | || | |____| |___| | || |    |_____|   | || | |____| |___| | || | |_________|  | |");
        System.out.println("| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |");
        System.out.println("| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |");
        System.out.println(" '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' ");
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
            System.out.println("Bravo vous avez tout trouver");
        }else {
            System.out.println("Dommage vous n'avez trouver que " + nb_trouver + " boules");
        }
    }
}
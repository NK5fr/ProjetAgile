package Roulette;

import java.util.Random;
import java.util.Scanner;

public class Roulette{
    
    private int resultat;
    private String pari; // a voir sous quel forme on fait le pari
    private static int[] black = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
    private static int[] red = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};

    private String Pari(){
        String choix = "";
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Vous pouvez parier sur: " + "\n" + "- Un chiffre (taper le numéro du chiffre)" 
            + "\n" + "- Une couleur (taper noire ou rouge)" 
            + "\n" + "- Un nombres pair et impair (taper pair ou impair)" 
            + "\n" + "- Une moitié (taper moitie1 pour les chiffre de 1 à 18, et moitie2 pour les nombres de 19 à 36)" 
            + "\n" + "- Une colonne (taper colonne1, colonne2 ou colonne3)"
            + "\n" + "- Un tiers (taper tiers1, tiers2, tiers3)"
            + "\n \n" + "- Taper retour pour revenir en arriere ou Parier pour parier votre mise");
            choix = sc.next();
            if(choix.equals("noire") || choix.equals("rouge") || choix.equals("pair") || choix.equals("impair") || choix.equals("colonne1") || choix.equals("colonne2") || choix.equals("colonne3") || choix.equals("moitie1") || choix.equals("moitie2") || choix.equals("tiers1") || choix.equals("tiers2") || choix.equals("tiers3") || choix.equals("noire") || choix.equals("noire") || )
        }while(choix.equals("Retour") || choix.equals("Parier"));
    }

    private void TournerRoue(){
        Random rand = new Random();
        resultat = rand.nextInt(37);
    }

    private int Gain(){}
}
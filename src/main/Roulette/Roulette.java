package main.Roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import main.App;

public class Roulette{
    
    private static int resultat;
    private static String pari; // a voir sous quel forme on fait le pari
    private static int argentParier;
    private static List black = Arrays.asList(2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35);
    private static List red = Arrays.asList(1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36);

    public Roulette(){
        Random rand = new Random();
        resultat = rand.nextInt(37);
    }

    public static void Pari(){
        String choix = "";
        boolean fin = false;
        do{
            fin = false;
            affichageTable();
            System.out.println("\nLes chiffres noirs sont les chiffres 2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35"
            + "\n" + "Les chiffres rouges sont les chiffres 1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36 \n");

            System.out.println("Vous pouvez parier sur: " + "\n" + "- Un chiffre (taper le numéro du chiffre)" 
            + "\n" + "Les chiffres noirs sont les chiffres 2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35"
            + "\n" + "Les chiffres rouges sont les chiffres 1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36"
            + "\n" + "- Une couleur (taper noir ou rouge)" 
            + "\n" + "- Un nombres pair et impair (taper pair ou impair)" 
            + "\n" + "- Une moitié (taper moitie1 pour les chiffre de 1 à 18, et moitie2 pour les nombres de 19 à 36)" 
            + "\n" + "- Une colonne (taper colonne1, colonne2 ou colonne3)"
            + "\n" + "- Un tiers (taper tiers1, tiers2, tiers3)");
            choix = App.scanner.next();
            if(choix.equals("noir") || choix.equals("rouge") || choix.equals("pair") || choix.equals("impair") || choix.equals("colonne1") || choix.equals("colonne2") || choix.equals("colonne3") || choix.equals("moitie1") || choix.equals("moitie2") || choix.equals("tiers1") || choix.equals("tiers2") || choix.equals("tiers3") || (Integer.parseInt(choix) >= 0 && Integer.parseInt(choix) <=36) ){
                fin = true;
                pari = choix;
                do{
                    System.out.println("metter combien d'argent");
                    argentParier = App.scanner.nextInt();
                }while(argentParier < 0);
            }else{
                System.out.println("Le pari n'est pas valide");
            }
        }while(!fin);
    }

    public static int Gain(){
        if(pari.equals("noir")){
            if(black.contains(resultat)){
                return argentParier * 1;
            }
        }else if(pari.equals("rouge")){
            if(red.contains(resultat)){
                return argentParier * 1;
            }
        }else if(pari.equals("pair")){
            if(resultat % 2 == 0){
                return argentParier * 1;
            }
        }else if(pari.equals("impair")){
            if(resultat % 2 != 0){
                return argentParier * 1;
            }
        }else if(pari.equals("moitie1")){
            if(resultat > 0 && resultat < 19){
                return argentParier * 1;
            }
        }else if(pari.equals("moitie2")){
            if(resultat > 18 && resultat < 37){
                return argentParier * 1;
            }
        }else if(pari.equals("colonne1")){
            if(resultat % 3 == 1){
                return argentParier * 2;
            }
        }else if(pari.equals("colonne2")){
            if(resultat % 3 == 2){
                return argentParier * 2;
            }
        }else if(pari.equals("colonne3")){
            if(resultat % 3 == 0){
                return argentParier * 2;
            }
        }else if(pari.equals("tiers1")){
            if(resultat > 0 && resultat < 13){
                return argentParier * 2;
            }
        }else if(pari.equals("tiers2")){
            if(resultat > 12 && resultat < 25){
                return argentParier * 2;
            }
        }else if(pari.equals("tiers3")){
            if(resultat > 24 && resultat < 37){
                return argentParier * 2;
            }
        }else if(Integer.parseInt(pari) == resultat){
            return argentParier * 35;
        }
        return 0;
    }

    public static void affichageRoulette(){
        System.out.println(".----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. ");
        System.out.println("| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |");
        System.out.println("| |  _______     | || |     ____     | || | _____  _____ | || |   _____      | || |  _________   | || |  _________   | || |  _________   | || |  _________   | |");
        System.out.println("| | |_   __ \\    | || |   .'    `.   | || ||_   _||_   _|| || |  |_   _|     | || | |_   ___  |  | || | |  _   _  |  | || | |  _   _  |  | || | |_   ___  |  | |");
        System.out.println("| |   | |__) |   | || |  /  .--.  \\  | || |  | |    | |  | || |    | |       | || |   | |_  \\_|  | || | |_/ | | \\_|  | || | |_/ | | \\_|  | || |   | |_  \\_|  | |");
        System.out.println("| |   |  __ /    | || |  | |    | |  | || |  | '    ' |  | || |    | |   _   | || |   |  _|  _   | || |     | |      | || |     | |      | || |   |  _|  _   | |");
        System.out.println("| |  _| |  \\ \\_  | || |  \\  `--'  /  | || |   \\ `--' /   | || |   _| |__/ |  | || |  _| |___/ |  | || |    _| |_     | || |    _| |_     | || |  _| |___/ |  | |");
        System.out.println("| | |____| |___| | || |   `.____.'   | || |    `.__.'    | || |  |________|  | || | |_________|  | || |   |_____|    | || |   |_____|    | || | |_________|  | |");
        System.out.println("| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |");
        System.out.println("| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |");
        System.out.println(" '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'");
    }

    public static void affichageTable(){
        System.out.println("                          __________ ");
        System.out.println("                          |   0    |  ");
        System.out.println("                 |----------------------------|");
        System.out.println("                 |        |1 |2 |3 |          |");
        System.out.println("                 |        |4 |5 |6 |          |");
        System.out.println("                 | tiers1 |7 |8 |9 |          |");
        System.out.println("                 |        |10|11|12|  moitie1 |");
        System.out.println("                 |-----------------|          | ");
        System.out.println("                 |        |13|14|15|          |");
        System.out.println("                 | tiers2 |16|17|18|          |");
        System.out.println("                 |        |-------------------| ");
        System.out.println("                 |        |19|20|21|          |");
        System.out.println("                 |        |22|23|24|          |");
        System.out.println("                 |-----------------|          |");
        System.out.println("                 |        |25|26|27|  moitie2 |");
        System.out.println("                 | tiers3 |28|29|30|          |");
        System.out.println("                 |        |31|32|33|          |");
        System.out.println("                 |        |34|35|36|          |");
        System.out.println("                 |________|__|__|__|__________| ");
        System.out.println("                          |c1|c2|c3|    ");
    }



    public static void main(String[] args){
        Roulette r = new Roulette();

        affichageRoulette();

        Pari();
        
        System.out.println("Le numéro gagnant est : " + resultat);
        System.out.println("vous avez gagner " + Gain());
    }

    public static int getResultat() {
        return resultat;
    }

    public static void setResultat(int resultat) {
        Roulette.resultat = resultat;
    }

    public static String getPari() {
        return pari;
    }

    public static void setPari(String pari) {
        Roulette.pari = pari;
    }

    public static int getArgentParier() {
        return argentParier;
    }

    public static void setArgentParier(int argentParier) {
        Roulette.argentParier = argentParier;
    }

    public static List getBlack() {
        return black;
    }

    public static void setBlack(List black) {
        Roulette.black = black;
    }

    public static List getRed() {
        return red;
    }

    public static void setRed(List red) {
        Roulette.red = red;
    }

    
}
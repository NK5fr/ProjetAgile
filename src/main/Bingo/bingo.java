package main.Bingo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import main.App;
import main.Jeu;

public class bingo implements Jeu{
    public static ArrayList<String> grille1 = new ArrayList<String>();
    public static ArrayList<String> grille2 = new ArrayList<String>();
    public static ArrayList<String> grille3 = new ArrayList<String>();
    public static ArrayList<String> grille4 = new ArrayList<String>();
    public static ArrayList<String> grille5 = new ArrayList<String>();
    public static ArrayList<Boolean> trouve1 = new ArrayList<Boolean>();
    public static ArrayList<Boolean> trouve2 = new ArrayList<Boolean>();
    public static ArrayList<Boolean> trouve3 = new ArrayList<Boolean>();
    public static ArrayList<Boolean> trouve4 = new ArrayList<Boolean>();
    public static ArrayList<Boolean> trouve5 = new ArrayList<Boolean>();
    public static int g1 = 0;
    public static int g2 = 0;
    public static int g3 = 0;
    public static int g4 = 0;
    public static int g5 = 0;
    public static ArrayList<String> tire = new ArrayList<>();
    private static final int DUREE = 12;
    public static int triche = 0;
    public static int nbtriche = 0;



    public static void afficherTitre(String nom){
        File file = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "affichage" + File.separator + nom + ".txt");
        try(Scanner sc = new Scanner(file)){
            sc.useDelimiter("\n");
            while(sc.hasNext()){
                System.out.println(sc.next());
            }
        }catch(FileNotFoundException e){
            System.out.println(nom);        
        }
    }

    public int duree(){
        return DUREE;
    }

    public void tricher(){
        if (nbtriche == 0){
            triche = 30;
            nbtriche ++;
        }else{
            triche += 10;
            nbtriche ++;
        }
        grille1.set(g1, "  ");
        trouve1.set(g1, true);
        g1 ++;
    }

    public void baisserTemps(){
        App.jour.moinsTempsJour(duree());
    }
    
    public void jouer() {
        clear();
        App.joueur.setArgent(App.joueur.getArgent() - 20);
        afficherTitre("Bingo");
        create_grille();
        System.out.println();
        System.out.println("Voici ta grille : ");
        affichage_grille(grille1);
        System.out.println("Le jeu commence ! ");
        lancer();
        System.out.println();
        victoire();
        defaite();
    }

    public void victoire(){
        if(!trouve1.contains(false)){
            System.out.println("Vous avez gagné !");
            System.out.println();
            App.joueur.setArgent(App.joueur.getArgent() + 100);
        }
    }

    public void defaite(){
        if(trouve1.contains(false)){
            System.out.println("Vous avez perdu...");
            System.out.println();
        }
    }

    public void lancer(){
        char c;
        Random r = new Random();
        int tr = 0;
        String chiffre;
        while(trouve1.contains(false) && trouve2.contains(false) && trouve3.contains(false) && trouve4.contains(false) && trouve5.contains(false)){
            tr = r.nextInt(100);
            if(tr>triche){
                chiffre = r.nextInt(45) + "";
                while(tire.contains(chiffre)){
                    chiffre = r.nextInt(45) + "";
                }
                tire.add(chiffre + "");
                System.out.println();
                System.out.println("Que voulez-vous faire ?");
                System.out.println("-> [b] Passer au tour suivant");
                System.out.println("-> [c] Tricher");
                System.out.println();
                c = App.ecouterChar();
                while(c != 'c' && c != 'b'){
                    c = App.ecouterChar();
                }
                affichageDé(chiffre);
                if(c == 'c'){
                    tricher();
                }else{   
                    if(grille1.contains(chiffre)){
                        trouve1.set(g1, true);
                        g1++;
                        grille1.set(grille1.indexOf(chiffre), "  ");
                    }
                }
                if(grille2.contains(chiffre)){
                    trouve2.set(g2, true);
                    g2++;
                }
                if(grille3.contains(chiffre)){
                    trouve3.set(g3, true);
                    g3++;
                }
                if(grille4.contains(chiffre)){
                    trouve4.set(g4, true);
                    g4++;
                }
                if(grille5.contains(chiffre)){
                    trouve5.set(g5, true);
                    g5++;
                }
                affichage_grille(grille1);
                System.out.println();
                affichage_score();
            }else{
                System.out.println();
                System.out.println("Vous avez été surpris en train de tricher ! ");
                System.out.println("Vous vous faites éjecter du casino et payer une amende de 100e.");
                App.joueur.setArgent(App.joueur.getArgent() - 100);
                break;
            }
            
        }
    }
    
    public static void affichage_score(){
        System.out.println("           -------------------------------");
        System.out.println("JOUEUR     |  J1 |  J2 |  J3 |  J4 |  J5 |");
        System.out.println("NB RESTANT |  " + (9-g1) + "  |  " + (9-g2) + "  |  " + (9-g3) + "  |  " + (9-g4) + "  |  " + (9-g5) + "  |");
        System.out.println("           -------------------------------");
    }
    
    public static void create_grille(){
        grille1.clear();
        grille2.clear();
        grille3.clear();
        grille4.clear();
        grille5.clear();
        trouve1.clear();
        trouve2.clear();
        trouve3.clear();
        trouve4.clear();
        trouve5.clear();
        tire.clear();
        Random r = new Random();
        String r1;
        //création des cinqs grilles
        for (int i=0; i<9; i++){
            r1 = r.nextInt(45) + "";
            while(grille1.contains(r1)){
                r1 = r.nextInt(45) + "";
            }
            grille1.add(r1 + "");
            r1 = r.nextInt(45) + "";
            while(grille2.contains(r1)){
                r1 = r.nextInt(45) + "";
            }
            grille2.add(r1+ "");
            r1 = r.nextInt(45) + "";
            while(grille3.contains(r1)){
                r1 = r.nextInt(45) + "";
            }
            grille3.add(r1+ "");
            r1 = r.nextInt(45) + "";
            while(grille4.contains(r1)){
                r1 = r.nextInt(45) + "";
            }
            grille4.add(r1+ "");
            r1 = r.nextInt(45) + "";
            while(grille5.contains(r1)){
                r1 = r.nextInt(45) + "";
            }
            grille5.add(r1 + "");
        }
        //création des cinqs grille de révelation 
        for (int i=0; i<9; i++){
            trouve1.add(false);
            trouve2.add(false);
            trouve3.add(false);
            trouve4.add(false);
            trouve5.add(false);
        }
    }

    static void affichage_grille(ArrayList<String> grille){
        System.out.println();
        for (int i=0; i<8; i++){
            System.out.print((" -"));
        }
        System.out.println();
        int y = 0;
        for (int x=0; x<3;x++){
            for (int i=0; i<7; i++){
                if(i%2 == 0){
                    System.out.print(" | ");
                }else{
                    System.out.print(grille.get(y) + "");
                    y++;
                }
            }
            System.out.println();
        }
        for (int i=0; i<7; i++){
            System.out.print((" -"));
        }
        System.out.println();
    }

    static void affichageDé(String chiffre){
        for (int i=0; i<3; i++){
            System.out.print(("-"));
        }
        System.out.println();
        System.out.println("|" + chiffre + "|");
        for (int i=0; i<3; i++){
            System.out.print(("-"));
        }
    }

    public static void clear()
    {
        final String ESC = "\033[";
        System.out.print (ESC + "2J");
        System.out.print (ESC + "0;0H");
        System.out.flush();
    }
   
}
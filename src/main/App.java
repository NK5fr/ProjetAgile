package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import main.Bingo.bingo;
import main.Boutique.Boutique;
import main.Lotterie.Lotterie;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static Joueur joueur;
    public static Jour jour;
    public static final File CLASSEMENT = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "classement" + File.separator + "classement.csv");

    private static void introduction(){
        clear();
        bingo.afficherTitre("Debut");
        System.out.println();
        System.out.print("Bonjour veuillez entrer votre nom pour jouer : ");
        String nom = scanner.next();
        while(nom.equals("test")){
            System.out.print("Nom invalide recommencez : ");
            nom = scanner.next();
        }
        clear();
        joueur = new Joueur(nom);
        joueur.charger();
    }

    private static void informations(){
        clear();
        System.out.print("Nom du joueur : ");
        System.out.println(joueur.getNom());
        System.out.print("Argent du joueur : ");
        System.out.println(joueur.getArgent() + " €");
        System.out.print("Nourriture du joueur : ");
        System.out.println(joueur.getNourriture());
        System.out.print("Bonheur du joueur : ");
        System.out.println(joueur.getBonheur());
        System.out.print("Nombre de jours passé : ");
        System.out.println(joueur.getNbJours());
        System.out.println();
        System.out.print("Entrez un caractère pour quitter : ");
        scanner.next();
    }

    private static void boutique() throws InterruptedException{
        Boutique b = new Boutique();
        b.menu();
    }

    private static void jouerArgent(){
        boolean continuer = true;
        char c;
        while(continuer){
            clear();
            System.out.println("Jour -> " + joueur.getNbJours()+ " | Heure -> " + jour.getVisualHour()+"h00");
            System.out.println("Argent -> " + joueur.getArgent() + "€ | Temps restant journée -> "+ jour.getTempsJour());
            System.out.println("Jeux possibles :");
            System.out.println();
            bingo.afficherTitre("Presentation");
            System.out.println();
            System.out.println("- la commande b permet de jouer au Bingo");
            System.out.println("- la commande j permet de jouer au BlackJack");
            System.out.println("- la commande r permet de jouer à la Roulette");
            System.out.println("- la commande m permet de jouer à la Machine à sous");
            System.out.println("- la commande l permet de jouer à la Loterie");
            System.out.println("- la commande q permet de quitter ce menu");
            c = ecouterChar();
            if(c == 'b'){
                bingo b = new bingo();
                b.jouer();            
            }else if(c == 'j'){
                
            }else if(c == 'r'){
                
            }else if(c == 'm'){
                
            }else if(c == 'l'){
                Jeu l = new Lotterie();
                try {
                    l.jouer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if(c == 'q'){
                continuer = false;
            }
            if(joueur.getArgent() <= 0){
                continuer = false;
            }
        }
    }

    public static void clear()
	{
        final String ESC = "\033[";
        System.out.print (ESC + "2J");
        System.out.print (ESC + "0;0H");
        System.out.flush();
	}

    public static char ecouterChar(){
        System.out.print("Veuillez entrer 1 caractère : ");
        String c = scanner.next();
        while(c.length() != 1){
            System.out.println("invalide");
            System.out.print("Veuillez entrer 1 caractère : ");
            c = scanner.next();
        }
        return c.charAt(0);
    }

    public static void saveClassement(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(CLASSEMENT, true))){
            bw.write(joueur.getNom());
            bw.newLine();
            bw.write("" + joueur.getNbJours());
            bw.newLine();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void classement(){
        clear();
        List<String> players = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();
        try(Scanner scan = new Scanner(CLASSEMENT)){
            scan.useDelimiter("\n");
            while(scan.hasNext()){
                players.add(scan.next());
                scores.add(Integer.valueOf(scan.next()));
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        Integer max;
        int idxMax;
        for(int i = 1; i <= 10; i++){
            max = Collections.max(scores);
            idxMax = scores.indexOf(max);
            System.out.println("N°" + i + " : " + players.get(idxMax) + " avec un score de " + scores.get(idxMax));
            players.remove(idxMax);
            scores.remove(idxMax);
        }
        System.out.print("Entrez un caractère pour quitter : ");
        scanner.next();
    }

    public static void main(String[] args) throws Exception {
        introduction();
        Thread.sleep(2000);
        jour = new Jour(joueur.getArgent());
        boolean continuer = true;
        char c;
        while(joueur.getNourriture() > 0 && continuer && joueur.getArgent() > 0){
            clear();
            System.out.println("Menu principal :");
            System.out.println("- la commande i affiche les informations sur le joueur");
            System.out.println("- la commande b affiche la boutique");
            System.out.println("- la commande j permet de jouer aux jeux d'argent");
            System.out.println("- la commande p permet de passer le temps");
            System.out.println("- la commande c permet d'afficher le classement des joueurs");
            System.out.println("- la commande q permet de quitter le jeu");
            c = ecouterChar();
            if(c == 'i'){
                informations();
            }else if(c == 'b'){
                boutique();
            }else if(c == 'j'){
                jouerArgent();
            }else if(c == 'p'){
                jour.setTempsJour(0);
            }else if(c == 'c'){
                classement();
            }else if(c == 'q'){
                continuer = false;
            }
            if(joueur.getArgent() > 0 && jour.getTempsJour() == 0){
                clear();
                System.out.println("Encore une journée de finie...\n");
                System.out.println(jour);
                Thread.sleep(2000);
                jour = new Jour(joueur.getArgent());
                joueur.addNbJours();
                joueur.jourPasse();
            }
        }
        if(!continuer){
            joueur.sauvegarder();
            clear();
            System.out.println("Partie sauvegardée !! On espère te revoir.");
        }else if(joueur.getNourriture() <= 0){
            clear();
            System.out.println("GAME OVER !!! Vous n'avez pas mangé depuis trop longtemps");
            File file = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + joueur.getNom() + ".csv");
            file.delete();
            saveClassement();
        }else if(joueur.getArgent() < 0){
            //clear();
            System.out.println("GAME OVER !!! Vous n'avez plus d'argent et vous finissez par mourir de faim");
            File file = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + joueur.getNom() + ".csv");
            file.delete();
            saveClassement();
        }
        Thread.sleep(3000);
    }
}

package main;
import java.io.File;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static Joueur joueur;
    public static Jour jour;

    private static void introduction(){
        clear();
        System.out.print("Bonjour veillez entrer votre nom pour jouer : ");
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
        System.out.println(joueur.getArgent());
        System.out.print("Nourriture du joueur : ");
        System.out.println(joueur.getNourriture());
        System.out.print("Bonheur du joueur : ");
        System.out.println(joueur.getBonheur());
        System.out.print("Nombre de jours passé : ");
        System.out.println(joueur.getNbJours());
        System.out.println();
        System.out.print("Entrez un caractère pour quittez : ");
        scanner.next();
    }

    private static void boutique(){

    }

    private static void jouerArgent(){
        boolean continuer = true;
        char c;
        while(continuer){
            clear();
            System.out.println("Jeux possibles :");
            System.out.println("- la commande b permet de jouer au Bingo");
            System.out.println("- la commande j permet de jouer au BlackJack");
            System.out.println("- la commande r permet de jouer à la Roulette");
            System.out.println("- la commande m permet de jouer à la Machine à sous");
            System.out.println("- la commande l permet de jouer à la lotterie");
            System.out.println("- la commande q permet de quitter ce menu");
            c = ecouterChar();
            if(c == 'b'){
                
            }else if(c == 'j'){
                
            }else if(c == 'r'){
                
            }else if(c == 'm'){
                
            }else if(c == 'l'){
                ;
            }else if(c == 'q'){
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

    public static void main(String[] args) throws Exception {
        introduction();
        Thread.sleep(2000);
        boolean continuer = true;
        char c;
        while(joueur.getNourriture() > 0 && continuer){
            clear();
            System.out.println("Menu principal :");
            System.out.println("- la commande i affiche les informations sur le joueur");
            System.out.println("- la commande b affiche la boutique");
            System.out.println("- la commande j permet de jouer aux jeux d'argent");
            System.out.println("- la commande q permet de quitter le jeu");
            c = ecouterChar();
            if(c == 'i'){
                informations();
            }else if(c == 'b'){
                boutique();
            }else if(c == 'j'){
                jouerArgent();
            }else if(c == 'q'){
                continuer = false;
            }
            if(jour.getTempsJour() == 0){
                clear();
                System.out.println("Encore une journée de finie...\n");
                System.out.println(jour);
                Thread.sleep(2000);
                jour = new Jour(joueur.getArgent(), joueur);
                joueur.addNbJours();
            }
        }
        if(!continuer){
            joueur.sauvegarder();
            clear();
            System.out.println("Partie sauvegardée !! On espère te revoir.");
        }else{
            System.out.println("GAME OVER !!! Vous n'avez pas mangé depuis trop longtemps");
            File file = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + joueur.getNom() + ".csv");
            file.delete();
        }
        Thread.sleep(1000);
    }
}

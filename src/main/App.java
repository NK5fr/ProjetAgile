package main;
import java.io.File;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    private static Joueur joueur;

    private static void introduction(){
        clear();
        System.out.print("Bonjour veillez entrer votre nom pour jouer : ");
        String nom = scanner.next();
        File file = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + nom + ".csv");
        if(!file.exists()){
            clear();
            System.out.println("Ahh un nouveau joueur soit le bienvenu !!");
            joueur = new Joueur(nom, 100, 100, 100);
            joueur.sauvegarder();
        }
    }

    public static void clear()
	{
        final String ESC = "\033[";
        System.out.print (ESC + "2J");
        System.out.print (ESC + "0;0H");
        System.out.flush();
	}

    public static void main(String[] args) throws Exception {
        introduction();
    }
}

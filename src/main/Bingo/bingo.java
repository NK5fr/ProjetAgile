package main.Bingo;
import java.util.ArrayList;
import java.util.Random;

public class bingo {
    static ArrayList<String> grille1 = new ArrayList<>();
    static ArrayList<String> grille2 = new ArrayList<>();
    static ArrayList<String> grille3 = new ArrayList<>();
    static ArrayList<String> grille4 = new ArrayList<>();
    static ArrayList<String> grille5 = new ArrayList<>();
    static ArrayList<Boolean> trouve1 = new ArrayList<Boolean>();
    static ArrayList<Boolean> trouve2 = new ArrayList<Boolean>();
    static ArrayList<Boolean> trouve3 = new ArrayList<Boolean>();
    static ArrayList<Boolean> trouve4 = new ArrayList<Boolean>();
    static ArrayList<Boolean> trouve5 = new ArrayList<Boolean>();
    static int g1 = 0;
    static int g2 = 0;
    static int g3 = 0;
    static int g4 = 0;
    static int g5 = 0;
    static ArrayList<String> tire = new ArrayList<>();

    bingo(){
    }

    public static void jouer() throws InterruptedException{
        System.out.println("\n" + //
                "\n" + //
                " .----------------.  .----------------.  .-----------------. .----------------.  .----------------. \n" + //
                "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" + //
                "| |   ______     | || |     _____    | || | ____  _____  | || |    ______    | || |     ____     | |\n" + //
                "| |  |_   _ \\    | || |    |_   _|   | || ||_   \\|_   _| | || |  .' ___  |   | || |   .'    `.   | |\n" + //
                "| |    | |_) |   | || |      | |     | || |  |   \\ | |   | || | / .'   \\_|   | || |  /  .--.  \\  | |\n" + //
                "| |    |  __'.   | || |      | |     | || |  | |\\ \\| |   | || | | |    ____  | || |  | |    | |  | |\n" + //
                "| |   _| |__) |  | || |     _| |_    | || | _| |_\\   |_  | || | \\ `.___]  _| | || |  \\  `--'  /  | |\n" + //
                "| |  |_______/   | || |    |_____|   | || ||_____|\\____| | || |  `._____.'   | || |   `.____.'   | |\n" + //
                "| |              | || |              | || |              | || |              | || |              | |\n" + //
                "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" + //
                " '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \n" + //
                "\n" + //
                "");
        Random r = new Random();
        String r1;
        String chiffre;
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
        System.out.println();
        System.out.println("Voici ta grille : ");
        affichage_grille(grille1);
        System.out.println("Le jeu commence ! ");
        //Répetitions des lancers de dés jusqu'au gagnant
        while(trouve1.contains(false) && trouve2.contains(false) && trouve3.contains(false) && trouve4.contains(false) && trouve5.contains(false)){
            chiffre = r.nextInt(45) + "";
            while(tire.contains(chiffre)){
                chiffre = r.nextInt(45) + "";
            }
            tire.add(chiffre + "");
            Thread.sleep(2000);
            affichageDé(chiffre);
            if(grille1.contains(chiffre)){
                trouve1.set(g1, true);
                g1++;
                grille1.set(grille1.indexOf(chiffre), "  ");
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
            System.out.println("           -------------------------------");
            System.out.println("JOUEUR     |  J1 |  J2 |  J3 |  J4 |  J5 |");
            System.out.println("NB RESTANT |  " + (9-g1) + "  |  " + (9-g2) + "  |  " + (9-g3) + "  |  " + (9-g4) + "  |  " + (9-g5) + "  |");
            System.out.println("           -------------------------------");
        }
        System.out.println();
        //Indique si on a gagné ou perdu
        if(!trouve1.contains(false)){
            System.out.println("Vous avez gagné !");
        }else{
            System.out.println("Vous avez perdu...");
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
    
    public static void main(String[] args) throws InterruptedException {
        clear();
        jouer();
    }
}
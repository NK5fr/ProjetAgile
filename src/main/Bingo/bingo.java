import java.util.ArrayList;
import java.util.Random;

public class bingo {
    ArrayList grille1 = new ArrayList<>();
    ArrayList grille2 = new ArrayList<>(null);
    ArrayList grille3 = new ArrayList<>(null);
    ArrayList grille4 = new ArrayList<>(null);
    ArrayList grille5 = new ArrayList<>(null);
    boolean[] trouve1 = new boolean[9];
    boolean[] trouve2 = new boolean[9];
    boolean[] trouve3 = new boolean[9];
    boolean[] trouve4 = new boolean[9];
    boolean[] trouve5 = new boolean[9];

    bingo(){
        Random r = new Random();
        int chiffre;
        //création des cinqs grilles
        for (int i=0; i<9; i++){
            r.nextInt(45);
            if(!grille1.contains(r)){
                grille1.add(r.nextInt(45));
            }else{
                while(!grille1.contains(r)){
                    r.nextInt(45);
                    grille1.add(r.nextInt(45));
                }
            }
            r.nextInt(45);
            if(!grille2.contains(r)){
                grille2.add(r.nextInt(45));
            }else{
                while(!grille2.contains(r)){
                    r.nextInt(45);
                    grille2.add(r.nextInt(45));
                }
            }
            r.nextInt(45);
            if(!grille3.contains(r)){
                grille3.add(r.nextInt(45));
            }else{
                while(!grille3.contains(r)){
                    r.nextInt(45);
                    grille3.add(r.nextInt(45));
                }
            }
            r.nextInt(45);
            if(!grille4.contains(r)){
                grille4.add(r.nextInt(45));
            }else{
                while(!grille4.contains(r)){
                    r.nextInt(45);
                    grille4.add(r.nextInt(45));
                }
            }
            r.nextInt(45);
            if(!grille5.contains(r)){
                grille5.add(r.nextInt(45));
            }else{
                while(!grille5.contains(r)){
                    r.nextInt(45);
                    grille5.add(r.nextInt(45));
                }
            }
        }
        //création des cinqs grille de révelation 
        for (int i=0; i<9; i++){
            trouve1[i] = false;
            trouve2[i] = false;
            trouve3[i] = false;
            trouve4[i] = false;
            trouve5[i] = false;
        }
        System.out.println("Voici ta grille : ");
        affichage_grille(grille1);
        System.out.println("Le jeu commence ! ");
        chiffre = (int)r.nextInt(45);
        affichageDé(chiffre);
        
    }

    static void affichage_grille(ArrayList grille){
        for (int i=0; i<8; i++){
            System.out.print((" - "));
        }
        System.out.println();
        int y = 0;
        for (int x=0; x<8;x++){
            for (int i=0; i<8; i++){
                if(i%2 == 0){
                    System.out.print(" | ");
                }else{
                    System.out.print(grille.get(y) + "");
                    y++;
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i=0; i<7; i++){
            System.out.print(("--"));
        }
    }

    static void affichageDé(int chiffre){
        for (int i=0; i<3; i++){
            System.out.print((" -"));
        }
        System.out.println();
        System.out.println(" | " + chiffre + " |");
        for (int i=0; i<3; i++){
            System.out.print((" -"));
        }
    }
    
    public static void main(String[] args) {
        affichageDé(1);
        ArrayList a = new ArrayList<>();
        a.add(45);
        a.add(22);
        a.add(44);
        a.add(3);
        a.add(25);
        a.add(18);
        a.add(5);
        a.add(4);
        a.add(10);
        affichage_grille(a);
    }
}
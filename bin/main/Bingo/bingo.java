import java.util.Random;

public class bingo {
    int[] grille1 = new int[9];
    int[] grille2 = new int[9];
    int[] grille3 = new int[9];
    int[] grille4 = new int[9];
    int[] grille5 = new int[9];
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
            //if(r not in grille1)
            grille1[i] =  r.nextInt(45);
            r.nextInt(45);
            //if(r not in grille2)
            grille2[i] =  r.nextInt(45);
            r.nextInt(45);
            //if(r not in grille3)
            grille3[i] =  r.nextInt(45);
            r.nextInt(45);
            //if(r not in grille4)
            grille4[i] =  r.nextInt(45);
            r.nextInt(45);
            //if(r not in grille5)
            grille5[i] =  r.nextInt(45);
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

    String[][] affichage_grille(int[] grille){
        String[][] grille_afficher = new String[6][6];
        grille_afficher[0][0] = "--";
        grille_afficher[0][1] = "--";
        grille_afficher[0][2] = "--";
        grille_afficher[0][3] = "--";
        grille_afficher[0][4] = "--";
        grille_afficher[0][5] = "--";
        grille_afficher[0][6] = "--";
        grille_afficher[6][0] = "--";
        grille_afficher[6][1] = "--";
        grille_afficher[6][2] = "--";
        grille_afficher[6][3] = "--";
        grille_afficher[6][4] = "--";
        grille_afficher[6][5] = "--";
        grille_afficher[6][6] = "--";
        grille_afficher[1][0] = "|";
        grille_afficher[2][0] = "|";
        grille_afficher[3][0] = "|";
        grille_afficher[4][0] = "|";
        grille_afficher[5][0] = "|";
        grille_afficher[6][0] = "--";
        grille_afficher[1][1] = grille[0] + "";
        grille_afficher[2][1] = "--";
        grille_afficher[3][1] = grille[3] + "";
        grille_afficher[4][1] = "--";
        grille_afficher[5][1] = grille[6] + "";
        grille_afficher[6][1] = "--";
        grille_afficher[1][2] = "|";
        grille_afficher[2][2] = "|";
        grille_afficher[3][2] = "|";
        grille_afficher[4][2] = "|";
        grille_afficher[5][2] = "|";
        grille_afficher[6][2] = "|";
        grille_afficher[1][3] = grille[1] + "";
        grille_afficher[2][3] = "--";
        grille_afficher[3][3] = grille[4] + "";
        grille_afficher[4][3] = "--";
        grille_afficher[5][3] = grille[7] + "";
        grille_afficher[6][3] = "--";
        grille_afficher[1][4] = "|";
        grille_afficher[2][4] = "|";
        grille_afficher[3][4] = "|";
        grille_afficher[4][4] = "|";
        grille_afficher[5][4] = "|";
        grille_afficher[6][4] = "|";
        grille_afficher[1][5] = grille[2] + "";
        grille_afficher[2][5] = "--";
        grille_afficher[3][5] = grille[5] + "";
        grille_afficher[4][5] = "--";
        grille_afficher[5][5] = grille[8] + "";
        return grille_afficher;
    }

    String[][] affichageDé(int chiffre){
        String[][] chiffre_afficher = new String[3][3];
        chiffre_afficher[0][0]= "--";
        chiffre_afficher[0][1]= "--";
        chiffre_afficher[0][2]= "--";
        chiffre_afficher[2][0]= "--";
        chiffre_afficher[2][1]= "--";
        chiffre_afficher[2][2]= "--";
        chiffre_afficher[0][1]= "|";
        chiffre_afficher[0][2]= "|";
        chiffre_afficher[2][1]= "|";
        chiffre_afficher[2][2]= "|";
        chiffre_afficher[1][1]= chiffre + "";
        return chiffre_afficher;
    }
    
}
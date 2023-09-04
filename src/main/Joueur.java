package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Joueur {
    private String nom;
    private int vie;
    private int argent;
    private int bonheur;

    public Joueur(String nom, int vie, int argent, int bonheur) {
        this.nom = nom;
        this.vie = vie;
        this.argent = argent;
        this.bonheur = bonheur;
    }

    public void sauvegarder(){
        File file = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + this.nom + ".csv");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("" + vie);
            bw.newLine();
            bw.write("" + argent);
            bw.newLine();
            bw.write("" + bonheur);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier " + file + " : " + e.getMessage());
        }
    }
}

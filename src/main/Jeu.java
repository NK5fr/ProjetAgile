package main;

public interface Jeu {

    public void tricher();

    public void jouer();

    public void victoire(Joueur joueur);

    public void defaite(Joueur joueur);

    public void baisserTemps();

    public int duree();

    public String toString();
}

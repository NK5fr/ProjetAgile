package main;

public interface Jeu {

    public void tricher();

    public void jouer(Joueur joueur);

    public void victoire(Joueur joueur);

    public void defaite(Joueur joueur);

    public void baisserTemps();

    public int duree();

    public String toString();
}

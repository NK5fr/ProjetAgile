package main;

public interface Jeu {

    public void tricher();

    public void jouer() throws InterruptedException;

    public void victoire();

    public void defaite();

    public void baisserTemps();

    public int duree();

    public String toString();
}

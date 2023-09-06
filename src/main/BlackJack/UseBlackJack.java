package main.BlackJack;

import main.App;

public class UseBlackJack {
    public static void main(String[] args) throws InterruptedException {
        BlackJack currentGame = new BlackJack(App.joueur);
        currentGame.jouer();
    }
}

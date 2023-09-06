package main.BlackJack;

public class UseBlackJack {
    public static void main(String[] args) throws InterruptedException {
        BlackJack currentGame = new BlackJack(new User(100, "player"));
        currentGame.jouer();
    }
}

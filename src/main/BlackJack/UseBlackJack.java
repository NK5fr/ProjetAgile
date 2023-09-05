package main.BlackJack;

public class UseBlackJack {
    public static void main(String[] args) throws InterruptedException {
        CardDeck aceDeck = new CardDeck();
        /*
        for (Card card : aceDeck.getDeck()) {
            if (!card.getCardRealValue().equals(Value.ACE)) {
                card.getCardRealValue().setCardValue(Value.ACE);
            }
        }
        */
        BlackJack currentGame = new BlackJack(new User(100, "player"));
        currentGame.startOfGame();
    }
}

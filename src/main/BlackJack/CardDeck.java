package main.BlackJack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    ArrayList<Card> deck;

    CardDeck() {
        for (int suits = 0; suits < Suits.values().length; suits++) {
            Suits currentSuit = Suits.CLUB;
            for (int value = 0; value < Value.values().length ; value++) {
                Value currentValue = Value.ONE;
                deck.add(new Card(currentSuit, currentValue));
            }
        }
    }

    void shuffle() {
        Collections.shuffle(deck);
    }

    Card deal() {
        this.deck.get(0);
        this.deck.remove(0);
    }
}

package main.BlackJack;

import java.util.ArrayList;

public class User {
    ArrayList<Card> userHand;
    Score userScore;
    int currentMoney;
    String denomination;
    
    public User(ArrayList<Card> userHand, Score userScore, int currentMoney, String denomination) {
        this.userHand = userHand;
        this.userScore = userScore;
        this.currentMoney = currentMoney;
        this.denomination = denomination;
    }

    public User(int currentMoney, String denomination) {
        this(new ArrayList<Card>(), new Score(), currentMoney, denomination);
    }

    public User() {
        this(new ArrayList<Card>(), new Score(), 0, "dealer");
    }

    public void addCard(Card card) {
        this.userHand.add(card);
    }

    public ArrayList<Card> getUserHand() {
        return userHand;
    }

    public void setUserHand(ArrayList<Card> userHand) {
        this.userHand = userHand;
    }

    public Score getUserScore() {
        return userScore;
    }

    public void setUserScore(Score userScore) {
        this.userScore = userScore;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getDenomination() {
        return this.denomination;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.denomination + "\n");
        for (Card card : this.userHand) {
            str.append("\t"+ card.toString() + "\n");
        }
        str.append(this.userScore.getUserScore());
        
        return str.toString();
    }

    void calculateScore() {
        Score calculatedScore = new Score();
        for (Card card : this.userHand) {
            if (card.isVisible) {
                calculatedScore.addValue(card.getCardValue());
            }
        }
        this.setUserScore(calculatedScore);
    }

    boolean isBusted() {
        for (Card card : userHand) {
            if (card.cardValue.equals(Value.ACE)) {
                
            }
        }
        return this.userScore.isBusted();
    }

    boolean isBlackJack() {
        return this.userScore.isBlackJack();
    }

    void setAllCardsVisible() {
        for (Card card : this.userHand) {
            card.setVisible(true);
        }
    }
}

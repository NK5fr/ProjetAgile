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

    public User(int currentMoney) {
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

    public int getUserScore() {
        return userScore.getUserScore();
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
        int nbAce = 0;
        for (Card card : this.userHand) {
            if (card.isVisible) {
                calculatedScore.addValue(card.getCardValue());
                if (card.getCardRealValue().equals(Value.ACE)) {
                    nbAce++;
                }
            }
        }
        if (calculatedScore.getUserScore() > 21) {
            calculatedScore.setUserScore(calculatedScore.getUserScore() - (10*nbAce));
        }

        this.setUserScore(calculatedScore);

    }

    boolean isBusted() {
        return this.getUserScore() > 21;
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

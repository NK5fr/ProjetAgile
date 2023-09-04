package main.BlackJack;

public class Score {
    int userScore;


    Score() {
        this.userScore = 0;
    }

    Score(int userScore) {
        this.userScore = userScore;
    }

    boolean busted() {
        return this.userScore > 21;
    }

    boolean blackJack() {
        return this.userScore == 21;
    }
}

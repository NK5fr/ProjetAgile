package main.BlackJack;

import java.util.Scanner;

public class BlackJack {

    public Scanner scanner = new Scanner(System.in);

    
    User player;
    User dealer;
    int bet;
    CardDeck deck;

    
    public BlackJack(User user, CardDeck deck, User dealer, int bet) {
        this.player = user;
        this.player.setDenomination("player");
        this.dealer = dealer;
        this.deck = deck;
        this.bet = bet;
    }

    public BlackJack(User user) {
        this(user, new CardDeck(), new User(), 0);
    }

    public BlackJack() {
        this(new User());
    }

    void bet(int playerBet) {
        if (playerBet <= this.player.getCurrentMoney()) {
            this.bet = playerBet;
        }
    }

    void playerDeal() {
        Card deltCard = this.deck.deal();
        this.player.addCard(deltCard);
        this.player.calculateScore();
    }

    void dealerDeal() {
        Card deltCard = this.deck.deal();
        this.dealer.addCard(deltCard);
    }    

    

    void startingDeal() {
        this.playerDeal();
        this.dealerDeal();
        this.dealer.userHand.get(0).setVisible(false);
        this.playerDeal();
        this.dealerDeal();
        this.player.calculateScore();
        this.dealer.calculateScore();
    }

    void showCards() {
        System.out.println(dealer);
        System.out.println(player);
    }

    void askForChoice() {
        String choice = "";
        while (!(choice.equals("H")) && !(choice.equals("S"))) {
            System.out.println("H- Hit");
            System.out.println("S- Stand");
            choice = scanner.next().toUpperCase();
        }
        if (choice.equals("H")) {
            this.hit();
        } else if (choice.equals("S")) {
            this.stand();
        }
    }

    void askForBet() {
        int choice = 0;
        while (choice > this.player.currentMoney || choice <= 0) {
            System.out.println("How much will you risk");
            choice = scanner.nextInt();
        }
    }

    void hit() {
        this.playerDeal();
        if (this.player.userScore.isBusted()) {
            this.gameOver();
            return;
        }
        this.showCards();
        this.askForChoice();
    }

    void stand() {
        while (this.dealer.isBusted()) {
            this.dealerDeal();
        }

    }

    void gameOver() {
        this.dealer.setAllCardsVisible();
        this.dealer.calculateScore();
        this.showCards();
        System.out.println("Game Over,\nYour score went over 21\nToo bad!");
    }

    void startOfGame() {
        System.out.println("\n" + //
                "\n" + //
                " .----------------.  .----------------.  .----------------.  .----------------.  .----------------. \n" + //
                "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" + //
                "| |   ______     | || |   _____      | || |      __      | || |     ______   | || |  ___  ____   | |\n" + //
                "| |  |_   _ \\    | || |  |_   _|     | || |     /  \\     | || |   .' ___  |  | || | |_  ||_  _|  | |\n" + //
                "| |    | |_) |   | || |    | |       | || |    / /\\ \\    | || |  / .'   \\_|  | || |   | |_/ /    | |\n" + //
                "| |    |  __'.   | || |    | |   _   | || |   / ____ \\   | || |  | |         | || |   |  __'.    | |\n" + //
                "| |   _| |__) |  | || |   _| |__/ |  | || | _/ /    \\ \\_ | || |  \\ `.___.'\\  | || |  _| |  \\ \\_  | |\n" + //
                "| |  |_______/   | || |  |________|  | || ||____|  |____|| || |   `._____.'  | || | |____||____| | |\n" + //
                "| |              | || |              | || |              | || |              | || |              | |\n" + //
                "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" + //
                " '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \n" + //
                "             .----------------.  .----------------.  .----------------.  .----------------.         \n" + //
                "            | .--------------. || .--------------. || .--------------. || .--------------. |        \n" + //
                "            | |     _____    | || |      __      | || |     ______   | || |  ___  ____   | |        \n" + //
                "            | |    |_   _|   | || |     /  \\     | || |   .' ___  |  | || | |_  ||_  _|  | |        \n" + //
                "            | |      | |     | || |    / /\\ \\    | || |  / .'   \\_|  | || |   | |_/ /    | |        \n" + //
                "            | |   _  | |     | || |   / ____ \\   | || |  | |         | || |   |  __'.    | |        \n" + //
                "            | |  | |_' |     | || | _/ /    \\ \\_ | || |  \\ `.___.'\\  | || |  _| |  \\ \\_  | |        \n" + //
                "            | |  `.___.'     | || ||____|  |____|| || |   `._____.'  | || | |____||____| | |        \n" + //
                "            | |              | || |              | || |              | || |              | |        \n" + //
                "            | '--------------' || '--------------' || '--------------' || '--------------' |        \n" + //
                "             '----------------'  '----------------'  '----------------'  '----------------'         \n" + //
                "\n" + //
                "");
        this.deck.shuffle();
        System.out.println("You currently have "+ this.player.currentMoney+" $ in your account");
        askForBet();
        startingDeal();
        showCards();
        askForChoice();
    }
}

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
        this.bet = playerBet;
    }

    void playerDeal() {
        Card deltCard = this.deck.deal();
        this.player.addCard(deltCard);
        this.player.calculateScore();
    }

    void dealerDeal() {
        Card deltCard = this.deck.deal();
        this.dealer.addCard(deltCard);
        if (this.dealer.userHand.size() == 1) {
            deltCard.setVisible(false);   
        }
        this.dealer.calculateScore();
    }    

    

    void startingDeal() {
        this.playerDeal();
        this.dealerDeal();
        this.playerDeal();
        this.dealerDeal();
    }

    void showCards() {
        System.out.println(dealer);
        System.out.println("\n");
        System.out.println(player);
        System.out.println("\n");
    }

    void askForChoice() throws InterruptedException {
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
        bet(choice);
    }

    void hit() throws InterruptedException {
        this.playerDeal();
        if (this.player.userScore.isBusted()) {
            this.gameOver();
            return;
        }
        this.showCards();
        this.askForChoice();
    }

    void stand() throws InterruptedException {
        this.dealer.setAllCardsVisible();
        this.dealer.calculateScore();
        this.showCards();
        do {
            Thread.sleep(100);
            this.dealerDeal();
            this.showCards();
        } while (this.dealer.getUserScore() < this.player.getUserScore() && !(this.dealer.isBusted()));
        if (this.dealer.getUserScore() > this.player.getUserScore()) {
            if (this.dealer.isBusted()) {
                this.gameWon();
            } else {
                this.gameOver();
            }
        }
    }

    
    void gameOver() {
        this.dealer.setAllCardsVisible();
        this.dealer.calculateScore();
        this.showCards();
        if (this.player.isBusted()) {
            System.out.println("Game Over,\nYour score went over 21\nToo bad!");
        }
        else {
            System.out.println("Game Over,\nYour score is inferior to the dealer's\nToo bad!");
        }
        scanner.close();
    }

    void gameWon() {
        System.out.println("YOU WON, the dealer busted");
        scanner.close();
    }

    void startOfGame() throws InterruptedException {
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
        //askForBet();
        startingDeal();
        showCards();
        askForChoice();
    }
}

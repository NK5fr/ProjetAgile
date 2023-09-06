package main.BlackJack;

import java.util.Scanner;

public class BlackJack {

    public Scanner scanner = new Scanner(System.in);

    
    public User player;
    public User dealer;
    public int bet;
    public CardDeck deck;

    
    public BlackJack(User user, CardDeck deck, User dealer, int bet) {
        this.player = user;
        this.player.setDenomination("joueur");
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

    

    public void startingDeal() {
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
        while (!(choice.equals("T")) && !(choice.equals("R"))) {
            System.out.println("T- Tirer");
            System.out.println("R- Rester");
            choice = scanner.next().toUpperCase();
        }
        if (choice.equals("T")) {
            this.hit();
        } else if (choice.equals("R")) {
            this.stand();
        }
    }

    void askForBet() {
        int choice = 0;
        while (choice > this.player.currentMoney || choice <= 0) {
            System.out.println("Combien allez-vous risquer");
            choice = scanner.nextInt();
        }
        bet(choice);
    }

    public boolean hit() throws InterruptedException {
        this.playerDeal();
        if (this.player.userScore.isBusted()) {
            return this.gameOver();
        }
        this.showCards();
        this.askForChoice();
        return true;
    }

    public boolean stand() throws InterruptedException {
        this.dealer.setAllCardsVisible();
        this.dealer.calculateScore();
        this.showCards();
        do {
            Thread.sleep(1000);
            this.dealerDeal();
            this.showCards();
        } while (this.dealer.getUserScore() < this.player.getUserScore() && !(this.dealer.isBusted()));
        if (this.dealer.isBusted()) {
            return this.gameWon();
        } else {
            return this.gameOver();
        }
    }

    
    boolean gameOver() {
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
        return false;
    }

    boolean gameWon() {
        System.out.println("YOU WON, the dealer busted");
        scanner.close();
        return true;
    }

    public void startOfGame() throws InterruptedException {
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

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public User getDealer() {
        return dealer;
    }

    public void setDealer(User dealer) {
        this.dealer = dealer;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public CardDeck getDeck() {
        return deck;
    }

    public void setDeck(CardDeck deck) {
        this.deck = deck;
    }
}

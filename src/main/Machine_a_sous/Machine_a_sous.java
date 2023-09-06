package main.Machine_a_sous;

import java.util.Arrays;
import java.util.List;

import main.App;
import main.Jeu;
import main.Joueur;
import main.Bingo.bingo;
import main.Lotterie.Lotterie;

public class Machine_a_sous implements Jeu{
    
    private List<Anneau> machine;

    public static String rep;
    private final static int DUREE = 4;
    private final static int prix = 10;
    private final static int frais_medic = 250;

    public Machine_a_sous() {
        this.machine = Arrays.asList(new Anneau(),new Anneau(),new Anneau());
    }

    public static void clear(){
        final String ESC = "\033[";
        System.out.print (ESC + "2J");
        System.out.print (ESC + "0;0H");
        System.out.flush();
    }

    public void roll() {
        Machine_a_sous.clear();
        for (Anneau anneau : machine) {
            if (anneau.isRolling()) {
                anneau.roll();
            }
            System.out.print(anneau);
        }
        System.out.print("\n");
    }

    public void stopAnneau(){
        for (Anneau anneau : machine) {
            if (anneau.isRolling()) {
                anneau.setRolling(false);
                return;
            }
        }
    }

    @Override
    public void tricher() {
        if (Anneau.RAND.nextInt(4) == 2) {
            System.out.println("Vous êtes pris la mains dans le sac. Le gérant vous envoi ses gros bras\nVous perder " + Machine_a_sous.frais_medic + "€");
            App.joueur.setArgent(App.joueur.getArgent() - Machine_a_sous.frais_medic);
            this.defaite();
            return;
        }
        System.out.println("Vous avez baisser le voltage de la machine les anneaux tourne moins vite");
        Anneau.setSpeed(1000);
    }

    @Override
    public void jouer() {
        char c;
        boolean continuer = true;
        Machine_a_sous m = new Machine_a_sous();
        continuer = true;
        while(continuer){
            App.clear();
            System.out.println("Voulez vous entrez le prix de la machine est " + Machine_a_sous.prix +"€ (o/n)");
            c = App.ecouterChar();
            if (c == 'o') {
                App.joueur.setArgent(App.joueur.getArgent() - Machine_a_sous.prix);
                continuer = false;
            }else if (c =='n') {
                return;
            }
        }
        continuer = true;
        while(continuer){
            App.clear();
            System.out.println("Voulez vous tricher (o/n)");
            c = App.ecouterChar();
            if (c == 'o') {
                this.tricher();
                System.out.println("Vous êtes sur que les nombres seronts inférieur de 26");
                continuer = false;
            }else if (c =='n') {
                continuer = false;
            }
        }
        bingo.afficherTitre("MAS");
 
        while (continuer) {
            m.roll();
            Thread t = new TextInputObject();
            t.start();
            if (Machine_a_sous.rep != null && Machine_a_sous.rep.equals("")) {
                Machine_a_sous.rep = null;
                m.stopAnneau();
            }
            if (!m.machine.get(2).isRolling()) {
                continuer = false;
            }
            try {
                Thread.sleep(Anneau.speed);
            } catch (Exception ignored) {}
            
            
        }
        if ((m.machine.get(0).getIdx()) == (m.machine.get(1).getIdx()) && (m.machine.get(1).getIdx()) == (m.machine.get(2).getIdx())) {
            this.victoire();
        }else {
            this.defaite();
        }
    }

    @Override
    public void victoire() {
        App.joueur.setBonheur(App.joueur.getBonheur() + 10);
        int récompense = 0;
        if (this.machine.get(0).getIdx() == 0) {
            récompense = (int) (Machine_a_sous.prix * 1.5);
        }else if (this.machine.get(0).getIdx() == 1) {
            récompense = (int) (Machine_a_sous.prix * 5);
        }else if (this.machine.get(0).getIdx() == 2) {
            récompense = (int) (Machine_a_sous.prix * 2);
        }else if (this.machine.get(0).getIdx() == 3) {
            récompense = (int) (Machine_a_sous.prix * 2.5);
        }else if (this.machine.get(0).getIdx() == 4) {
            récompense = (int) (Machine_a_sous.prix * 3);
        }
        System.out.println("Bravo vous avez gagner " +récompense+"€");
        System.out.println("Vous avez " + App.joueur.getArgent() + "€");
        App.joueur.setArgent(App.joueur.getArgent() + récompense);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}
    }

    @Override
    public void defaite() {
        App.joueur.setBonheur(App.joueur.getBonheur() - 10);
        System.out.println("Dommage vous avez perdu");
        System.out.println("Vous avez " + App.joueur.getArgent() + "€");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}
    }

    @Override
    public void baisserTemps() {
        App.jour.moinsTempsJour(Machine_a_sous.DUREE);
    }

    @Override
    public int duree() {
        return Machine_a_sous.DUREE;
    }

}
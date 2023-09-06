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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tricher'");
    }

    @Override
    public void jouer() {
        Machine_a_sous m = new Machine_a_sous();
        boolean continuer = true;
        
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
                Thread.sleep(Anneau.SPEED);
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
        System.out.println("Bravo vous avez gagner " +récompense*0.25 +"€");
        System.out.println("Vous avez " + App.joueur.getArgent() + "€");
        App.joueur.setArgent(App.joueur.getArgent() + ((int) (argent*0.25)));
    }

    @Override
    public void defaite() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defaite'");
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

package main.Machine_a_sous;

import java.util.Arrays;
import java.util.List;

import main.App;
import main.Jeu;
import main.Joueur;
import main.Bingo.bingo;

public class Machine_a_sous implements Jeu{
    
    private List<Anneau> machine;

    public static String rep;

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
    public void jouer(Joueur joueur) {
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
            this.victoire(joueur);
        }else {
            this.defaite(joueur);
        }
    }

    @Override
    public void victoire(Joueur joueur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'victoire'");
    }

    @Override
    public void defaite(Joueur joueur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defaite'");
    }

    @Override
    public void baisserTemps() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'baisserTemps'");
    }

    @Override
    public int duree() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'duree'");
    }
}

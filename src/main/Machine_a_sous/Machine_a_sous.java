package main.Machine_a_sous;

import java.util.Arrays;
import java.util.List;

public class Machine_a_sous{
    
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
    public static void main(String[] args) throws InterruptedException{
        Machine_a_sous m = new Machine_a_sous();
        boolean continuer = true;
        
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
            Thread.sleep(Anneau.SPEED);
            
        }
        if ((m.machine.get(0).getIdx()) == (m.machine.get(1).getIdx()) && (m.machine.get(1).getIdx()) == (m.machine.get(2).getIdx())) {
            System.out.println("Victoire");
        }else {
            System.out.println("Defaite");
        }
    }
}

package main.Machine_a_sous;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Anneau {

    private boolean rolling;
    private int idx;
    protected final static int SPEED = 200;
    private final static List<Character> SYMBOLES = new LinkedList<>();
    private final static Random RAND = new Random();

    public Anneau() {
        this.rolling = true;
        idx = RAND.nextInt(5);
        SYMBOLES.add('€');
        SYMBOLES.add('7');
        SYMBOLES.add('♥');
        SYMBOLES.add('♪');
        SYMBOLES.add('☻');
    }

    public void roll() {
        if (rolling) {
            this.setIdx((this.getIdx()+1)%5);
        }
    }

    @Override
    public String toString() {
        return ""+SYMBOLES.get(this.getIdx());
    }

    public void setRolling(boolean rolling) {
        this.rolling = rolling;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public boolean isRolling() {
        return rolling;
    }

    public int getIdx() {
        return idx;
    }

    
    
}

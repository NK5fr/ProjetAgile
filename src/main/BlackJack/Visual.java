package main.BlackJack;

public class Visual {
    String repeat(String str, int nb) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0 ; i < nb ; i++) {
            repeated.append(str);
        }
        return repeated.toString();
    }

    public static void clear()
    {
        final String ESC = "\033[";
        System.out.print (ESC + "2J");
        System.out.print (ESC + "0;0H");
        System.out.flush();
    }

    int biggestLine(String str) {
        return 0;
    }
}

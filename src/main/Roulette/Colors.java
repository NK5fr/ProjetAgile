package main.Roulette;

public class Colors {
    private static final String RESET = "\033[0m";
    private static final String BLACK = "\033[40;30m";
    private static final String RED = "\033[40;31m";

    public static String setColor(String color) {
        if (color.equals("black")) {
            return Colors.BLACK;
        }else if (color.equals("red")) {
            return Colors.RED;
        }
        return "";
    }

    public static String resetColor() {
        return Colors.RESET;
    }
}

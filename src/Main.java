import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] hand = getCards("src/InputFile");
        int[] bet = getBet("src/InputFile");

        Poker poker = new Poker(hand, bet);

        poker.analyzeHand();
        poker.sortByDeck();
        for (int i = 0; i < hand.length; i++) {
            poker.bubbleSort();
        }
        poker.totalBid();
        System.out.println("____________");
        System.out.println(poker);
    }

    // METHOD: all card hands are made into a STRING array
    public static String[] getCards(String fileName) {
        String[] hand = new String[50];      // change based on number of lines on input file
        File f = new File("src/input_file");

        String cardLine = "";
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                cardLine += currentLine.substring(0, currentLine.indexOf("|")) + "\n";
            }

            String[] array1 = cardLine.split("\n");

            for (int i = 0; i < array1.length; i++) {
                // split by space, now we have a list of String numbers
                hand[i] = Arrays.toString((array1[i]).split(" "));
            }
            return hand;
        } catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }
        return hand;
    }

    // METHOD: all bets are made into an INTEGER array
    public static int[] getBet(String fileName) {
        int[] bet = new int[50];
        File f = new File("src/input_file");

        String betLine = "";
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                betLine += currentLine.substring(currentLine.indexOf("|") + 1) + "\n";
            }
            String[] array2 = betLine.split("\n");

            for (int i = 0; i < array2.length; i++) {
                // split by space, now we have a list of String numbers
                bet[i] = Integer.parseInt(array2[i]);
            }
            return bet;
        } catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }
        return bet;
    }
}

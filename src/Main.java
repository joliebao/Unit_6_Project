import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] hand = getFileData("src/InputFile");
        System.out.println(Arrays.toString(hand));
//        Poker poker = new Poker(hand);

    }

    public static String[] getFileData(String fileName) {
        String[] hand = new String[5];      // change based on number of lines on input file
        File f = new File("src/input_file");

        String line = "";
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                line += currentLine.substring(0, currentLine.indexOf("|")) + "\n";
            }

            String[] array = line.split("\n");

            for (int i = 0; i < array.length; i++) {
                // split by space, now we have a list of String numbers
                hand[i] = Arrays.toString((array[i]).split(" "));
            }
            return hand;
        } catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }
        return hand;
    }
}

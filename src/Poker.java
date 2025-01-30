import java.util.Arrays;

public class Poker {
    private int[] bid;
    private String[] cards;

 public Poker (String[] cards, int[] bid){
     this.cards = cards;
     this.bid = bid;
 }

 public String analyzeHand(){  // part 1
     // sorts of deck hands
     int fiveOfAKind = 0;
     int fourOfAKind = 0;
     int fullHouse = 0;
     int threeOfAKind = 0;
     int twoPair = 0;
     int onePair = 0;
     int highCard = 0;

     // putting each element in the line into a specific card number
    for (String pile : cards){
        // types of cards
        int ace = 0;
        int king = 0;
        int queen = 0;
        int jack = 0;
        int ten = 0;
        int nine = 0;
        int eight = 0;
        int seven = 0;
        int six = 0;
        int five = 0;
        int four = 0;
        int three = 0;
        int two = 0;

        String card1 = pile.substring(1,(pile.indexOf(",")));
        pile = pile.substring((pile.indexOf(",")+1));
        String card2 = pile.substring(0,(pile.indexOf(",")));
        pile = pile.substring((pile.indexOf(",")+1));
        String card3 = pile.substring(0,(pile.indexOf(",")));
        pile = pile.substring((pile.indexOf(",")+1));
        String card4 = pile.substring(0,(pile.indexOf(",")));
        pile = pile.substring(pile.indexOf(",") + 1, pile.length() - 1);
        String card5 = pile;

        // new array made for the single line
        String[] hand = new String[5];
        hand[0] = card1;
        hand[1] = card2;
        hand[2] = card3;
        hand[3] = card4;
        hand[4] = card5;

        for (String each : hand){
            if (each.equals("Ace")) {
                ace++;
            }
            else if (each.equals("King")) {
                king++;
            }
            else if (each.equals("Queen")) {
                queen++;
            }
            else if (each.equals("Jack")) {
                jack++;
            }
            else if (each.equals("10")) {
                ten++;
            }
            else if (each.equals("9")) {
                nine++;
            }
            else if (each.equals("8")) {
                eight++;
            }
            else if (each.equals("7")) {
                seven++;
            }
            else if (each.equals("6")) {
                six++;
            }
            else if (each.equals("5")) {
                five++;
            }
            else if (each.equals("4")) {
                four++;
            }
            else if (each.equals("3")) {
                three++;
            }
            else if (each.equals("2")) {
                two++;
            }
        }

        if (ace == 5 || king == 5 || queen == 5 || jack == 5 || ten == 5 || nine == 5 || eight == 5 || seven == 5 || six == 5 || five == 5 || four == 5 || three == 5 || two == 5) {
            fiveOfAKind++;
        } else if (ace == 4 || king == 4 || queen == 4 || jack == 4 || ten == 4 || nine == 4 || eight == 4 || seven == 4 || six == 4 || five == 4 || four == 4 || three == 4 || two == 4) {
            fourOfAKind++;
        } else if ((ace == 3 || king == 3 || queen == 3 || jack == 3 || ten == 3 || nine == 3 || eight == 3 || seven == 3 || six == 3 || five == 3 || four == 3 || three == 3 || two == 3) &&
                (ace == 2 || king == 2 || queen == 2 || jack == 2 || ten == 2 || nine == 2 || eight == 2 || seven == 2 || six == 2 || five == 2 || four == 2 || three == 2 || two == 2)) {
            fullHouse++;
        } else if (ace == 3 || king == 3 || queen == 3 || jack == 3 || ten == 3 || nine == 3 || eight == 3 || seven == 3 || six == 3 || five == 3 || four == 3 || three == 3 || two == 3) {
            threeOfAKind++;
            // needs a better condition for if there are two pairs
        } else if ((ace == 2 || king == 2 || queen == 2 || jack == 2 || ten == 2 || nine == 2 || eight == 2 || seven == 2 || six == 2 || five == 2 || four == 2 || three == 2 || two == 2) &&
                (ace == 2 || king == 2 || queen == 2 || jack == 2 || ten == 2 || nine == 2 || eight == 2 || seven == 2 || six == 2 || five == 2 || four == 2 || three == 2 || two == 2)) {
            twoPair++;
        } else if (ace == 2 || king == 2 || queen == 2 || jack == 2 || ten == 2 || nine == 2 || eight == 2 || seven == 2 || six == 2 || five == 2 || four == 2 || three == 2 || two == 2) {
            onePair++;
        } else {
            highCard++;
        }

        // testing - - - - --
        System.out.println(fiveOfAKind);
        System.out.println(fourOfAKind);
        System.out.println(threeOfAKind);
        System.out.println(twoPair);
        System.out.println(onePair);
        System.out.println("----------------");
    }

    // totalling - --  -- - - - -
     return "Number of five of a kind hands: " + fiveOfAKind + "\n"+
     "Number of full house hands: " + fullHouse + "\n" +
     "Number of four of a kind hands: " + fourOfAKind + "\n" +
     "Number of three of a kind hands: " + threeOfAKind + "\n" +
     "Number of two pair hands: " + twoPair + "\n" +
     "Number of one pair hands: " + onePair + "\n" +
     "Number of high card hands: " + highCard;
 }

}

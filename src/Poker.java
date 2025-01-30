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

        // Counts how many of EACH card is what
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

        // NEW ARRAY: a standard assortment of cards
        int[] standardDeck = new int[13];
        standardDeck[0] = ace;
        standardDeck[1] = two;
        standardDeck[2] = three;
        standardDeck[3] = four;
        standardDeck[4] = five;
        standardDeck[5] = six;
        standardDeck[6] = seven;
        standardDeck[7] = eight;
        standardDeck[8] = nine;
        standardDeck[9] = ten;
        standardDeck[10] = king;
        standardDeck[11] = queen;
        standardDeck[12] = jack;

        int triple = 0; // if there are three of a card
        int twice = 0; // if there are two of a card
        int single = 0; // if there is only one of the card

        // determines how many of each card there are
        for (int amount : standardDeck){
            if (amount == 5){
                fiveOfAKind++;
            } else if (amount == 4){
                fourOfAKind++;
            } else if (amount == 3){
                triple ++;
            } else if (amount == 2){
                twice ++;
            } else if (amount == 1){
                single ++;
            }
        }

        // if not a five/four of a kind,
        // the other options can only be determined by the amount of triplets, doubles, and singles
        if (triple == 1 && twice == 1) {
            fullHouse++;
        } else if (triple == 1){
            threeOfAKind++;
        } else if (twice == 2){
            twoPair++;
        } else if (twice == 1) {
            onePair++;
        } else if (single == 5){
            highCard++;
        }
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

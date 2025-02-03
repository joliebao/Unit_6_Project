import java.util.Arrays;
import java.util.HashMap;

public class Poker {
    private int[] bid;
    private String[] cards;
    private String[] typeOfDeck;
    private String[] leastToGreatestOrder;
    private int iterationNum;

    // sorts of deck hands
    private int fiveOfAKind = 0;
    private int fourOfAKind = 0;
    private int fullHouse = 0;
    private int threeOfAKind = 0;
    private int twoPair = 0;
    private int onePair = 0;
    private int highCard = 0;

    public Poker(String[] cards, int[] bid) {
        this.cards = cards;
        this.bid = bid;
        typeOfDeck = new String[cards.length];
        leastToGreatestOrder = new String[cards.length];
    }

    public void analyzeHand() {  // part 1
        // putting each element in the line into a specific card number
        for (String pile : cards) {
            String line = pile;
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

            String card1 = pile.substring(1, (pile.indexOf(",")));
            pile = pile.substring((pile.indexOf(",") + 1));
            String card2 = pile.substring(0, (pile.indexOf(",")));
            pile = pile.substring((pile.indexOf(",") + 1));
            String card3 = pile.substring(0, (pile.indexOf(",")));
            pile = pile.substring((pile.indexOf(",") + 1));
            String card4 = pile.substring(0, (pile.indexOf(",")));
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
            for (String each : hand) {
                if (each.equals("Ace")) {
                    ace++;
                } else if (each.equals("King")) {
                    king++;
                } else if (each.equals("Queen")) {
                    queen++;
                } else if (each.equals("Jack")) {
                    jack++;
                } else if (each.equals("10")) {
                    ten++;
                } else if (each.equals("9")) {
                    nine++;
                } else if (each.equals("8")) {
                    eight++;
                } else if (each.equals("7")) {
                    seven++;
                } else if (each.equals("6")) {
                    six++;
                } else if (each.equals("5")) {
                    five++;
                } else if (each.equals("4")) {
                    four++;
                } else if (each.equals("3")) {
                    three++;
                } else if (each.equals("2")) {
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
            for (int amount : standardDeck) {
                if (amount == 5) {
                    fiveOfAKind++;
                    typeOfDeck[iterationNum] = "Five of a kind";
                } else if (amount == 4) {
                    fourOfAKind++;
                    typeOfDeck[iterationNum] = "Four of a kind";
                } else if (amount == 3) {
                    triple++;
                } else if (amount == 2) {
                    twice++;
                } else if (amount == 1) {
                    single++;
                }
            }

            // if not a five/four of a kind,
            // the other options can only be determined by the amount of triplets, doubles, and singles
            if (triple == 1 && twice == 1) {
                fullHouse++;
                typeOfDeck[iterationNum] = "Full house";
            } else if (triple == 1) {
                threeOfAKind++;
                typeOfDeck[iterationNum] = "Three of a kind";
            } else if (twice == 2) {
                twoPair++;
                typeOfDeck[iterationNum] = "Two pair";
            } else if (twice == 1) {
                onePair++;
                typeOfDeck[iterationNum] = "One pair";
            } else if (single == 5) {
                highCard++;
                typeOfDeck[iterationNum] = "High Card";
            }

            iterationNum++;
        }
    }

    // Part 2 ----------------------- - - -- - - - -
    // Note: Still need to match with bid value and create the totaling method
    // Sorting by deck title (ex. high card, one pair, two pair)
    public String[] sortByDeck() {
        // sorted into type of deck
        int i = 0;
        while (Arrays.stream(typeOfDeck).anyMatch("High card"::equals) && i < typeOfDeck.length) {
            leastToGreatestOrder[i] = cards[i];
            i++;
        }
        while (Arrays.stream(typeOfDeck).anyMatch("One pair"::equals) && i < typeOfDeck.length){
            leastToGreatestOrder[i] = cards[i];
            i++;
        }
        while (Arrays.stream(typeOfDeck).anyMatch("Two pair"::equals) && i < typeOfDeck.length) {
            leastToGreatestOrder[i] = cards[i];
            i++;
        }
        while (Arrays.stream(typeOfDeck).anyMatch("Three of a kind"::equals) && i < typeOfDeck.length) {
            leastToGreatestOrder[i] = cards[i];
            i++;
        }
        while (Arrays.stream(typeOfDeck).anyMatch("Four of a kind"::equals) && i < typeOfDeck.length) {
            leastToGreatestOrder[i] = cards[i];
            i++;
        }
        while (Arrays.stream(typeOfDeck).anyMatch("Full house"::equals) && i < typeOfDeck.length) {
            leastToGreatestOrder[i] = cards[i];
            i++;
        }
        while (Arrays.stream(typeOfDeck).anyMatch("Five of a kind"::equals) && i < typeOfDeck.length) {
            leastToGreatestOrder[i] = cards[i];
            i++;
        }

        System.out.println(Arrays.toString(leastToGreatestOrder));
        return leastToGreatestOrder;
    }

    // sort by numbers (ex. 1, 2, 3)
    // Note: need to consider the deck rankings, maybe deck ranking would occur second when the methods are called?
    public String[] bubbleSort(){
        for (int i = 0; i < leastToGreatestOrder.length; i++){
            int counter = 0;
            String deck1 = leastToGreatestOrder[i];
            String deck2 = leastToGreatestOrder[i+1];

            while (counter < 5){
                if (counter > 1){
                    deck1 = deck1.substring(deck1.indexOf(" "));
                    deck2 = deck2.substring(deck2.indexOf(" "));
                }
                String card1 = deck1.substring(0, deck1.indexOf(" "));
                String card2 = deck2.substring(0, deck2.indexOf(" "));
                int conversion1 = 0;
                int conversion2 = 0;

                if (card1.equals("King")){
                    conversion1 = 13;
                } else if (card1.equals("Queen")){
                    conversion1 = 12;
                } else if (card1.equals("Jack")){
                    conversion1 = 11;
                } else if (card1.equals("Ace")){
                    conversion1 = 1;
                } else {
                    conversion1 = Integer.parseInt(card1);
                }

                if (card2.equals("King")){
                    conversion2 = 13;
                } else if (card2.equals("Queen")){
                    conversion2 = 12;
                } else if (card2.equals("Jack")){
                    conversion2 = 11;
                } else if (card2.equals("Ace")){
                    conversion2 = 1;
                } else {
                    conversion2 = Integer.parseInt(card2);
                }

                if (conversion1 > conversion2){
                    leastToGreatestOrder[i] = deck2;
                    leastToGreatestOrder[i+1] = deck1;
                }
                else if (conversion1 == conversion2){
                    counter++;
                }
            }
        }
        return leastToGreatestOrder;
    }

    public int totalBidValue(){
        return 0; // placeholder, change when it is implemented
    }

    public String toString(){
        return "Number of five of a kind hands: " + fiveOfAKind + "\n" +
                "Number of full house hands: " + fullHouse + "\n" +
                "Number of four of a kind hands: " + fourOfAKind + "\n" +
                "Number of three of a kind hands: " + threeOfAKind + "\n" +
                "Number of two pair hands: " + twoPair + "\n" +
                "Number of one pair hands: " + onePair + "\n" +
                "Number of high card hands: " + highCard;
    }
}
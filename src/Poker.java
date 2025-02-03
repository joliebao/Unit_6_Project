import java.util.Arrays;
import java.util.HashMap;

public class Poker {
    private int[] bid;
    private String[] cards;
    private int[] typeOfDeck;
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
        typeOfDeck = new int[cards.length];
        leastToGreatestOrder = new String[cards.length];
    }

    public void analyzeHand() {  // part 1
        // putting each element in the line into a specific card number
        for (String pile : cards) {
            String line = pile;
            int amount = 0;

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

            int counter1 = 0;
            int counter2 = 0;
            int counter3 = 0;
            int counter4 = 0;

            for (int i = 0; i < hand.length; i++) {
                if (hand[0].equals(hand[i])) {
                    counter1++;
                } else if (hand[counter1].equals(hand[i])) {
                    counter2++;
                } else if (hand[counter2 + counter1].equals(hand[i])) {
                    counter3++;
                } else if (hand[counter3 + counter2 + counter1].equals(hand[i])) {
                    counter4++;
                }
            }

            if (counter1 == 5) {
                fiveOfAKind++;
                typeOfDeck[iterationNum] = 7;
            } else if (counter1 == 3 && counter2 == 2){
                fullHouse++;
                typeOfDeck[iterationNum] = 6;
            } else if (counter1 == 4){
                fourOfAKind++;
                typeOfDeck[iterationNum] = 5;
            } else if (counter1 == 3) {
                threeOfAKind++;
                typeOfDeck[iterationNum] = 4;
            } else if (counter1 == 2 && counter2 == 2) {
                twoPair++;
                typeOfDeck[iterationNum] = 3;
            } else if (counter1 == 2) {
                onePair++;
                typeOfDeck[iterationNum] = 2;
            } else if (counter1 == 1) {
                highCard++;
                typeOfDeck[iterationNum] = 1;
            }

            iterationNum++;
        }
    }

    // Part 2 ----------------------- - - -- - - - -
    // Note: Still need to match with bid value and create the totaling method
    // Sorting by deck title (ex. high card, one pair, two pair)
    public void sortByDeck() {
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
    }

    // sort by numbers (ex. 1, 2, 3)
    // Note: need to consider the deck rankings, maybe deck ranking would occur second when the methods are called?
    public void bubbleSort(){
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
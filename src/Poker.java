import java.util.Arrays;
import java.util.HashMap;

public class Poker {
    private int[] bid;
    private String[] cards;
    private int[] typeOfDeck;
    private int iterationNum;
    private int[] organizedBid;

    // sorts of deck hands
    private int fiveOfAKind = 0;
    private int fourOfAKind = 0;
    private int fullHouse = 0;
    private int threeOfAKind = 0;
    private int twoPair = 0;
    private int onePair = 0;
    private int highCard = 0;

    private int total = 0;

    public Poker(String[] cards, int[] bid) {
        this.cards = cards;
        this.bid = bid;
        typeOfDeck = new int[cards.length];
        organizedBid = new int[bid.length];
    }

    public void analyzeHand() {  // part 1
        // putting each element in the line into a specific card number
        for (String pile : cards) {
            pile = pile.replace("[", "");
            pile = pile.replace("]", "");;

            String[] hand = pile.split(",");

            int counter1 = 0;
            int counter2 = 0;
            int counter3 = 0;
            int counter4 = 0;

            for (int i = 0; i < hand.length; i++) {
                if (hand[0].equals(hand[i])) {
                    counter1++;
                } else if (hand[1].equals(hand[i])) {
                    counter2++;
                } else if (hand[2].equals(hand[i])) {
                    counter3++;
                } else if (hand[3].equals(hand[i])) {
                    counter4++;
                }
            }

            int triple = 0;
            int twice = 0;

            int[] counters = {counter1, counter2, counter3, counter4};

            for (int counter : counters){
                if (counter == 3) {
                    triple++;
                } else if (counter == 2) {
                    twice++;
                }
            }

            if (counter1 == 5) {
                fiveOfAKind++;
                typeOfDeck[iterationNum] = 7;
            } else if (triple == 1 && twice == 1){
                fullHouse++;
                typeOfDeck[iterationNum] = 6;
            } else if (counter1 == 4 || counter2 == 4){
                fourOfAKind++;
                typeOfDeck[iterationNum] = 5;
            } else if (triple == 1) {
                threeOfAKind++;
                typeOfDeck[iterationNum] = 4;
            } else if (twice == 2) {
                twoPair++;
                typeOfDeck[iterationNum] = 3;
            } else if (twice == 1) {
                onePair++;
                typeOfDeck[iterationNum] = 2;
            } else {
                highCard++;
                typeOfDeck[iterationNum] = 1;
            }

            iterationNum++;
        }
    }

    // Part 2 ----------------------- - - -- - - - -
    // Sorting by deck title (ex. high card, one pair, two pair)
    public void sortByDeck() {
        // sorted into type of deck
        // indexGetterArray = original hand value; use it to compare the array values and change the bid+card values to match
        String indexGetter = "";
        for (int num : typeOfDeck){
            indexGetter += num;
        }
        int i = 0;
        while (indexGetter.contains("1")) {
            int index = indexGetter.indexOf("1");
            indexGetter = indexGetter.substring(0, index) + indexGetter.substring(index +1);
            indexGetter = indexGetter.substring(0, index) + "0" + indexGetter.substring(index);
            organizedBid[i] = bid[index];
            i++;
        }
        while (indexGetter.contains("2")) {
            int index = indexGetter.indexOf("2");
            indexGetter = indexGetter.substring(0, index) + indexGetter.substring(index +1);
            indexGetter = indexGetter.substring(0, index) + "0" + indexGetter.substring(index);
            organizedBid[i] = bid[index];
            i++;
        }
        while (indexGetter.contains("3")) {
            int index = indexGetter.indexOf("3");
            indexGetter = indexGetter.substring(0, index) + indexGetter.substring(index +1);
            indexGetter = indexGetter.substring(0, index) + "0" + indexGetter.substring(index);
            organizedBid[i] = bid[index];
            i++;
        }
        while (indexGetter.contains("4")) {
            int index = indexGetter.indexOf("4");
            indexGetter = indexGetter.substring(0, index) + indexGetter.substring(index +1);
            indexGetter = indexGetter.substring(0, index) + "0" + indexGetter.substring(index);
            organizedBid[i] = bid[index];
            i++;
        }
        while (indexGetter.contains("5")) {
            int index = indexGetter.indexOf("5");
            indexGetter = indexGetter.substring(0, index) + indexGetter.substring(index +1);
            indexGetter = indexGetter.substring(0, index) + "0" + indexGetter.substring(index);
            organizedBid[i] = bid[index];
            i++;
        }
        while (indexGetter.contains("6")) {
            int index = indexGetter.indexOf("6");
            indexGetter = indexGetter.substring(0, index) + indexGetter.substring(index +1);
            indexGetter = indexGetter.substring(0, index) + "0" + indexGetter.substring(index);
            organizedBid[i] = bid[index];
            i++;
        }
        while (indexGetter.contains("7")) {
            int index = indexGetter.indexOf("7");
            indexGetter = indexGetter.substring(0, index) + indexGetter.substring(index +1);
            indexGetter = indexGetter.substring(0, index) + "0" + indexGetter.substring(index);
            organizedBid[i] = bid[index];
            i++;
        }
    }

    // sort by numbers (ex. 1, 2, 3)
    // Note: CALL THIS FIRST!
    public void bubbleSort(){
        for (int i = 0; i < cards.length - 1; i++){
            int conversion1 = 0;
            int conversion2 = 0;

            cards[i] = cards[i].replace("[", "");
            cards[i] = cards[i].replace("]", "");;

            cards[i+1] = cards[i+1].replace("[", "");
            cards[i+1] = cards[i+1].replace("]", "");;
            System.out.println(Arrays.toString(cards));

            String[] handPrev = cards[i].split(",");
            String[] handCurr = cards[i+1].split(",");

            int counter = 0;
            boolean swapped = false;
            while ((counter < handPrev.length) && !swapped){
                if (handPrev[counter].equals("King")){
                    conversion1 = 13;
                } else if (handPrev[counter].equals("Queen")){
                    conversion1 = 12;
                } else if (handPrev[counter].equals("Jack")){
                    conversion1 = 11;
                } else if (handPrev[counter].equals("Ace")){
                    conversion1 = 1;
                } else {
                    conversion1 = Integer.parseInt(handPrev[counter]);
                }

                if (handCurr[counter].equals("King")){
                    conversion2 = 13;
                } else if (handCurr[counter].equals("Queen")){
                    conversion2 = 12;
                } else if (handCurr[counter].equals("Jack")){
                    conversion2 = 11;
                } else if (handCurr[counter].equals("Ace")){
                    conversion2 = 1;
                } else {
                    conversion2 = Integer.parseInt(handCurr[counter]);
                }

                if (conversion1 > conversion2){
                    String temp = cards[i];
                    cards[i] = cards[i+1];
                    cards[i+1] = temp;
                    swapped = true;
                } else if (conversion1 == conversion2) {
                    counter ++;
                } else {
                    swapped = true; // ending the loop
                }
            }
        }
        System.out.println(Arrays.toString(cards));
    }

    public int totalBid(){
        for (int i = 0; i < cards.length; i++){
            total += bid[i] * i+1;
        }
        return total;
    }

    public String toString(){
        return "Number of five of a kind hands: " + fiveOfAKind + "\n" +
                "Number of full house hands: " + fullHouse + "\n" +
                "Number of four of a kind hands: " + fourOfAKind + "\n" +
                "Number of three of a kind hands: " + threeOfAKind + "\n" +
                "Number of two pair hands: " + twoPair + "\n" +
                "Number of one pair hands: " + onePair + "\n" +
                "Number of high card hands: " + highCard + "\n" +
                "Total Bid Value: " + total + "\n" +
                "Total Bid Value With Jacks Wild: " ; // add this variable after part 3
    }
}
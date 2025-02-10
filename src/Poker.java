import java.util.Arrays;
import java.util.ArrayList;

public class Poker {
    private int[] bid;
    private String[] cards;
    private int[] organizedBid;
    private ArrayList<String> organizedCards;
    private String indexGetter = "";

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
        organizedBid = new int[bid.length];
        organizedCards = new ArrayList<String>();
    }

    private void bracketRemoval(){
        for (int i = 0; i < cards.length; i++) {
            cards[i] = cards[i].replace("[", "");
            cards[i] = cards[i].replace("]", "");
        }
    }

    // Part 1 - - ---- -- - --- - - - -- -
    public void analyzeHand() {
        // putting each element in the line into a specific card number

        // for some reason index 0 starts with brackets...??
        cards[0] = cards[0].replace("[", "");
        cards[0] = cards[0].replace("]", "");
        for (String pile : cards) {
            bracketRemoval();
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
                indexGetter += 7;
            } else if (triple == 1 && twice == 1){
                fullHouse++;
                indexGetter += 5;
            } else if (counter1 == 4 || counter2 == 4){
                fourOfAKind++;
                indexGetter += 6;
            } else if (triple == 1) {
                threeOfAKind++;
                indexGetter += 4;
            } else if (twice == 2) {
                twoPair++;
                indexGetter += 3;
            } else if (twice == 1) {
                onePair++;
                indexGetter += 2;
            } else {
                highCard++;
                indexGetter += 1;
            }
        }
    }

    // Part 2 ----------------------- - - -- - - - -
    // Sorting by deck title (ex. high card, one pair, two pair), completed second
    // Used with bubbleSort();
    public void sortByDeck() {
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

    private int[] toIntegerArray(String pile){
        int conversion;
        String arr[] = pile.split(",");
        int[] convertedArr = new int[5];
        for (int i = 0; i < 5; i++) {
            if (arr[i].equals("King")) {
                conversion = 13;
            } else if (arr[i].equals("Queen")) {
                conversion = 12;
            } else if (arr[i].equals("Jack")) {
                conversion = 11;
            } else if (arr[i].equals("Ace")) {
                conversion = 1;
            } else {
                conversion = Integer.parseInt(arr[i]);
            }
            convertedArr[i] = conversion;
        }
        return convertedArr;
    }

    // sort by numbers (ex. 1, 2, 3)
    // Note: CALL THIS FIRST!, completed first in part 2
    public void bubbleSort(){
        for (int i = 0; i < cards.length-1; i += 2){
            bracketRemoval();
            int[] curr = toIntegerArray(cards[i]);
            int[] next = toIntegerArray(cards[i+1]);

//            while (organizedCards.size() != 0) {
//                // sorted list is empty, just put item there
//                if (organizedCards.size() == 0) {
//                    organizedCards.add(cards[i]);
//                }
//                else {
//                    int deck1Num = 0;
//                    int deck2Num = 0;
//                    for (int j = 0; j < 5; j++){
//                        deck1Num = toIntegerArray(organizedCards[i]);
//                        deck2Num = toIntegerArray(organizedCards[0]);
//
//                    // if item should be the first number in the list
//                    if (toIntegerArray(cards[i]) < toIntegerArray(organizedCards.get(0))) {
//                        organizedCards.add(0, item);
//                    }
//                    // if item should be the last number in the list
//                    else if (item > organizedCards.get(organizedCards.size()-1)) {
//                        organizedCards.add(item);
//                    }
//                    // item is somewhere in between
//                    else {
//                        for (int i = 0; i < organizedCards.size()-1; i++) {
//                            int current = organizedCards.get(i);
//                            int next = organizedCards.get(i+1);
//                            if (item > current && item < next) {
//                                organizedCards.add(i+1, item);
//                                break;
//                            }
//                        }
//                    }
//                }

            int counter = 0;
            boolean swapped = false;

            if (organizedCards.size() == 0) {
                organizedCards.add(cards[i]);
            }
            while (counter < 5 && !swapped){ // if the elements from the index before has a value greater than the elements from the index after;
                if (curr[counter] > next[counter]){
                    organizedCards.add(cards[i + 1]);   // the organized card list will put the future card before the past card
                    organizedCards.add(cards[i]);
                    swapped = true;
                } else if (curr[counter] < next[counter]) {
                    organizedCards.add(cards[i]);   // the organized card list will put the past card before the future card
                    organizedCards.add(cards[i + 1]);
                    // do something
                    swapped = true;
                } else {    // if equal
                    counter++;
                }
            }
            System.out.println(organizedCards);
        }
    }

    public void totalBid(){
        for (int i = 1; i < organizedBid.length + 1; i++){
            total += organizedBid[i-1] * i;
        }
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
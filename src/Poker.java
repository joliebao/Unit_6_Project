import java.util.ArrayList;


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


        ArrayList<String> fiveOAK = new ArrayList<String>();
        ArrayList<String> fullH = new ArrayList<String>();
        ArrayList<String> fourOAK = new ArrayList<String>();
        ArrayList<String> threeOAK = new ArrayList<String>();
        ArrayList<String> twoP = new ArrayList<String>();
        ArrayList<String> oneP = new ArrayList<String>();
        ArrayList<String> highC = new ArrayList<String>();

        ArrayList<Integer> fiveOAKValue = new ArrayList<Integer>();
        ArrayList<Integer> fourOAKValue = new ArrayList<Integer>();
        ArrayList<Integer> threeOAKValue = new ArrayList<Integer>();
        ArrayList<Integer> fullHouseValue = new ArrayList<Integer>();
        ArrayList<Integer> twoPairValue = new ArrayList<Integer>();
        ArrayList<Integer> onePairValue = new ArrayList<Integer>();
        ArrayList<Integer> highCardValue = new ArrayList<Integer>();



        // putting each element in the line into a specific card number
        for (String pile : cards){
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
                    fiveOAK.add(0,line);


                } else if (amount == 4){
                    fourOfAKind++;
                    fourOAK.add(0,line);
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
                fullH.add(0,line);
            } else if (triple == 1){
                threeOfAKind++;
                threeOAK.add(0,line);
            } else if (twice == 2){
                twoPair++;
                twoP.add(0,line);
            } else if (twice == 1) {
                onePair++;
                oneP.add(0,line);
            } else if (single == 5){
                highCard++;
                highC.add(0,line);
            }
            for(int i=0; i < fiveOAK.size(); i++){
                for(String each : fiveOAK){
                    String num1 = each.substring(1,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num2 = each.substring(0,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num3 = each.substring(0,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num4 = each.substring(0,(each.indexOf(",")));
                    each = each.substring(each.indexOf(",") + 1, each.length() - 1);
                    String num5 = each;

                    String[] temporary = {num1,num2,num3,num4,num5};

                    for(String index:temporary){
                        if(index=="Ace"){
                            fiveOAKValue.add(1);
                        }
                        else if (index =="Jack"){
                            fiveOAKValue.add(11);
                        }
                        else if (index =="Queen"){
                            fiveOAKValue.add(12);
                        }
                        else if (index =="King"){
                            fiveOAKValue.add(13);
                        }
                        else if (Integer.parseInt(index)==2){
                            fiveOAKValue.add(2);
                        }
                        else if (Integer.parseInt(index)==3){
                            fiveOAKValue.add(3);
                        }
                        else if (Integer.parseInt(index)==4){
                            fiveOAKValue.add(4);
                        }
                        else if (Integer.parseInt(index)==5){
                            fiveOAKValue.add(5);
                        }
                        else if (Integer.parseInt(index)==6){
                            fiveOAKValue.add(6);
                        }
                        else if (Integer.parseInt(index)==7){
                            fiveOAKValue.add(7);
                        }
                        else if (Integer.parseInt(index)==8){
                            fiveOAKValue.add(8);
                        }
                        else if (Integer.parseInt(index)==9){
                            fiveOAKValue.add(9);
                        }
                        else if (Integer.parseInt(index)==10){
                            fiveOAKValue.add(10);
                        }
                        else if (index =="Jack"){
                            fiveOAKValue.add(11);
                        }
                        else if (index =="Queen"){
                            fiveOAKValue.add(12);
                        }
                        else if (index =="King"){
                            fiveOAKValue.add(13);
                        }


                    }


                }




            }
            for(int i=0; i < fourOAK.size(); i++){
                for(String each : fourOAK){
                    String num1 = each.substring(1,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num2 = each.substring(0,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num3 = each.substring(0,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num4 = each.substring(0,(each.indexOf(",")));
                    each = each.substring(each.indexOf(",") + 1, each.length() - 1);
                    String num5 = each;

                    String[] temporary = {num1,num2,num3,num4,num5};

                    for(String index:temporary){
                        if(index=="Ace"){
                            fourOAKValue.add(1);
                        }
                        else if (index =="Jack"){
                            fourOAKValue.add(11);
                        }
                        else if (index =="Queen"){
                            fourOAKValue.add(12);
                        }
                        else if (index =="King"){
                            fourOAKValue.add(13);
                        }
                        else if (Integer.parseInt(index)==2){
                            fourOAKValue.add(2);
                        }
                        else if (Integer.parseInt(index)==3){
                            fourOAKValue.add(3);
                        }
                        else if (Integer.parseInt(index)==4){
                            fourOAKValue.add(4);
                        }
                        else if (Integer.parseInt(index)==5){
                            fourOAKValue.add(5);
                        }
                        else if (Integer.parseInt(index)==6){
                            fourOAKValue.add(6);
                        }
                        else if (Integer.parseInt(index)==7){
                            fourOAKValue.add(7);
                        }
                        else if (Integer.parseInt(index)==8){
                            fourOAKValue.add(8);
                        }
                        else if (Integer.parseInt(index)==9){
                            fourOAKValue.add(9);
                        }
                        else if (Integer.parseInt(index)==10){
                            fourOAKValue.add(10);
                        }



                    }


                }

            }
            for(int i=0; i < threeOAK.size(); i++){
                for(String each : threeOAK){
                    String num1 = each.substring(1,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num2 = each.substring(0,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num3 = each.substring(0,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num4 = each.substring(0,(each.indexOf(",")));
                    each = each.substring(each.indexOf(",") + 1, each.length() - 1);
                    String num5 = each;

                    String[] temporary = {num1,num2,num3,num4,num5};

                    for(String index:temporary){
                        if(index=="Ace"){
                            threeOAKValue.add(1);
                        }
                        else if (index =="Jack"){
                            threeOAKValue.add(11);
                        }
                        else if (index =="Queen"){
                            threeOAKValue.add(12);
                        }
                        else if (index =="King"){
                            threeOAKValue.add(13);
                        }
                        else if (Integer.parseInt(index)==2){
                            threeOAKValue.add(2);
                        }
                        else if (Integer.parseInt(index)==3){
                            threeOAKValue.add(3);
                        }
                        else if (Integer.parseInt(index)==4){
                            threeOAKValue.add(4);
                        }
                        else if (Integer.parseInt(index)==5){
                            threeOAKValue.add(5);
                        }
                        else if (Integer.parseInt(index)==6){
                            threeOAKValue.add(6);
                        }
                        else if (Integer.parseInt(index)==7){
                            threeOAKValue.add(7);
                        }
                        else if (Integer.parseInt(index)==8){
                            threeOAKValue.add(8);
                        }
                        else if (Integer.parseInt(index)==9){
                            threeOAKValue.add(9);
                        }
                        else if (Integer.parseInt(index)==10){
                            threeOAKValue.add(10);
                        }



                    }

                }

            }

            for(int i=0; i < fullH.size(); i++){
                for(String each : fullH){
                    String num1 = each.substring(1,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num2 = each.substring(0,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num3 = each.substring(0,(each.indexOf(",")));
                    each = each.substring((each.indexOf(",")+1));
                    String num4 = each.substring(0,(each.indexOf(",")));
                    each = each.substring(each.indexOf(",") + 1, each.length() - 1);
                    String num5 = each;

                    String[] temporary = {num1,num2,num3,num4,num5};

                    for(String index:temporary){
                        if(index=="Ace"){
                            fullHouseValue.add(1);
                        }
                        else if (index =="Jack"){
                            fullHouseValue.add(11);
                        }
                        else if (index =="Queen"){
                            fullHouseValue.add(12);
                        }
                        else if (index =="King"){
                            fullHouseValue.add(13);
                        }
                        else if (Integer.parseInt(index)==2){
                            fullHouseValue.add(2);
                        }
                        else if (Integer.parseInt(index)==3){
                            fullHouseValue.add(3);
                        }
                        else if (Integer.parseInt(index)==4){
                            fullHouseValue.add(4);
                        }
                        else if (Integer.parseInt(index)==5){
                            fullHouseValue.add(5);
                        }
                        else if (Integer.parseInt(index)==6){
                            fullHouseValue.add(6);
                        }
                        else if (Integer.parseInt(index)==7){
                            fullHouseValue.add(7);
                        }
                        else if (Integer.parseInt(index)==8){
                            fullHouseValue.add(8);
                        }
                        else if (Integer.parseInt(index)==9){
                            fullHouseValue.add(9);
                        }
                        else if (Integer.parseInt(index)==10){
                            fullHouseValue.add(10);
                        }



                    }


                }




            }

        }







        // totalling - --  -- - - - -
        return "Number of five of a kind hands: " + fiveOfAKind + "\n"+
                "Number of full house hands: " + fullHouse + "\n" +
                "Number of four of a kind hands: " + fourOfAKind + "\n" +
                "Number of three of a kind hands: " + threeOfAKind + "\n" +
                "Number of two pair hands: " + twoPair + "\n" +
                "Number of one pair hands: " + onePair + "\n" +
                "Number of high card hands: " + highCard+"\n"+fiveOAKValue+fourOAKValue+threeOAKValue;
    }




}


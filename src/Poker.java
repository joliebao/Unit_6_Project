public class Poker {
    private String[] bid;
    private String[] cards;
    private int group1;
    private int group2;

 public Poker (String[] bid, String[] cards){
     this.bid = bid;
     this.cards = cards;
     group1 = 0;
     group2 = 0;
 }
 //11234

 public String analyzeHand(){
     String card1 = "";
     String card2 = "";
     String card3 = "";
     String card4 = "";
     String card5 = "";

    for (String pile : cards){
        card1 = pile.substring(0,(pile.indexOf(",")));
        pile = pile.substring((pile.indexOf(",")));
        card2 = pile.substring(0,(pile.indexOf(",")));
        pile = pile.substring((pile.indexOf(",")));
        card3 = pile.substring(0,(pile.indexOf(",")));
        pile = pile.substring((pile.indexOf(",")));
        card4 = pile.substring(0,(pile.indexOf(",")));
        pile = pile.substring((pile.indexOf(",")));
        card5 = pile;
        if (card1 == card2){
            group1 +=1;
        }
        if (card1 == card3){
            group1 +=1;
        }
        if (card1 == card4){
            group1 +=1;
        }
        if (card1 == card5){
            group1 +=1;
        }

        if(card2 == card1 && card2 != ){
            group2+
        }

    }






 }

}

public class Poker {
    private String[] bid;
    private String[] cards;

 public Poker (String[] bid, String[] cards){
     this.bid = bid;
     this.cards = cards;
     int group1 = 0;
     int group2 = 0;
 }

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

    }





 }

}

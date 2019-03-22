import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }


    public int countCards() {
        return this.hand.size();
    }

    public void isDealtCard(Card card) {
        this.hand.add(card);
    }

    public int returnsCardValue() {
        int value = 0;
        for (Card card : this.hand){
            value = card.getValueFromEnum();
        }
        return value;
    }

    public void emptyHand(){
        this.hand.clear();
    }
}

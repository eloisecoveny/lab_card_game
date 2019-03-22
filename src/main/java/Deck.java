import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int countCards() {
       return this.cards.size();
    }

    public void populate(){
        deckReplenish();
        for (SuitType suit : SuitType.values()){
            for (RankType rank : RankType.values()){
                this.cards.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(this.cards);
    }

//    public void shuffle(){
//        ArrayList<Card> shuffledCards = new ArrayList<Card>();
//       int card = this.cards.size();
//       Random random = new Random();
//       for (int i = 0; i < card; i++){
//           int randomIndex random.nextInt(cards.countCards() -1);
//           int change = random.nextInt(i + card);
//           shuffledCards.add(this.cards(change));
//       }
//    }

    public void deckReplenish(){
        this.cards = new ArrayList<Card>();

    }

    public Card dealCard() {
        return this.cards.remove(0);
    }
}

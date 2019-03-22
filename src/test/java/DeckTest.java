import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;

    @Before
    public void setup(){
        deck = new Deck();
    }

    @Test
    public void canGetCards(){
        assertEquals(new ArrayList<Card>(), deck.getCards());
    }

    @Test
    public void deckStartsEmpty(){
        assertEquals(0, deck.countCards());
    }

    @Test
    public void deckCanBePopulated(){
        deck.populate();
        deck.populate();
        assertEquals(52, deck.countCards());
    }

    @Test
    public void deckCanDealCard(){
        deck.populate();
        ArrayList<Card> playersCards = new ArrayList<Card>();
        playersCards.add(deck.dealCard());
        assertEquals(1, playersCards.size());
    }
}

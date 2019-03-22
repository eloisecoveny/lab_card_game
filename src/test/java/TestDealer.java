import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestDealer {

    Dealer dealer;
    Player player1;
    Player player2;
    Deck deck;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void setup() {
        dealer = new Dealer("Jumbo Jack");
        deck = new Deck();
        deck.populate();
        player1 = new Player("Eloise");
        player2 = new Player("Heather");
        card1 = new Card(SuitType.HEARTS, RankType.ACE);
        card2 = new Card(SuitType.SPADES, RankType.THREE);
        card3 = new Card(SuitType.CLUBS, RankType.THREE);
    }

    @Test
    public void canAddPlayerToGame(){
        dealer.add(player1);
        assertEquals(1, dealer.countPlayers());
    }

    @Test
    public void dealerReceivesCardFromDeck(){
        dealer.dealsCard(deck, player1);
        assertEquals(51, deck.countCards());
        assertEquals(1, player1.countCards());

    }

    @Test
    public void dealerDealsCardToEachPlayer(){
        dealer.add(player1);
        dealer.add(player2);
        dealer.dealsCardToEachPlayer(deck);
        assertEquals(2, dealer.countPlayers());
        assertEquals(1, player1.countCards());
        assertEquals(1, player2.countCards());
        assertEquals(50, deck.countCards());
    }

    @Test
    public void canEvaluateScore(){
        dealer.add(player1);
        dealer.add(player2);
        player1.isDealtCard(card1);
        player2.isDealtCard(card2);
        assertEquals(player2, dealer.evaluatesScores(deck));
    }

    @Test
    public void whenDrawGameResets(){
        dealer.add(player1);
        dealer.add(player2);
        player1.isDealtCard(card2);
        player2.isDealtCard(card3);
        dealer.evaluatesScores(deck);
        deck.populate();
        assertEquals(0, player1.countCards());
        assertEquals(0, player2.countCards());
        assertEquals(52, deck.countCards());
    }

}

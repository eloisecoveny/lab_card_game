import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlayer {

    Player player1;
    Player player2;
    Card card1;
    Card card2;

    @Before
    public void setup(){
        player1 = new Player("Eloise");
        player2 = new Player("Heather");
        card1 = new Card(SuitType.HEARTS, RankType.ACE);
        card2 = new Card(SuitType.SPADES, RankType.THREE);
    }

    @Test
    public void handStartsEmpty(){
        assertEquals(0, player1.countCards());
    }

    @Test
    public void hasName(){
        assertEquals("Eloise", player1.getName());
    }

    @Test
    public void playerReceivesDealtCard(){
        player1.isDealtCard(card1);
        assertEquals(1, player1.countCards());
    }

    @Test
    public void returnsCardValue(){
        player1.isDealtCard(card1);
        assertEquals(1, player1.returnsCardValue());
    }

}

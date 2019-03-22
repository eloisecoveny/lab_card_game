import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {

    private String name;
    private ArrayList<Player> players;

    public Dealer(String name){
        this.name = name;
        this.players = new ArrayList<Player>();
    }

    public void dealsCard(Deck deck, Player player) {
        Card card = deck.dealCard();
        player.isDealtCard(card);
    }

    public int countPlayers() {
        return this.players.size();
    }

    public void add(Player player){
        this.players.add(player);
    }

    public void dealsCardToEachPlayer(Deck deck) {
        for(Player player : this.players){
            this.dealsCard(deck, player);
        }
    }

    public Player evaluatesScores(Deck deck) {
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for (Player player : this.players){
            scores.add(player.returnsCardValue());
        }
        Collections.sort(scores, Collections.reverseOrder());
        Player winner = null;
        if ((scores.get(0)) != (scores.get(1))){
            for (Player player : this.players){
                if (player.returnsCardValue() == (scores.get(0))){
                    winner = player;
                }
            }
            return winner;
        } else {
            resetGame(deck);
            return null;
        }
    }

    public void resetGame(Deck deck){
        for (Player player : this.players){
            player.emptyHand();
            deck.deckReplenish();
        }
    }

}

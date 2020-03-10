import java.util.*;
public class Deck
{
    private ArrayList<Card> deck;
    public Random gen = new Random();
    public Deck()
    {
        deck = new ArrayList<Card>();
        resetDeck();

    }   

    public void resetDeck()
    {   String[] suits={"Hearts", "Diamonds", "Spades", "Clubs"};
        String[] names={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        for(int i = 0; i<suits.length; i++)
            for(int k = 0; k<names.length; k++)
                deck.add(new Card(suits[i], names[k]));
    }

    public Card draw()
    {
        int drawNum=(int) (Math.random()*deck.size());
        Card draw = deck.get(drawNum);
        deck.remove(drawNum);
        return draw;
    }

}

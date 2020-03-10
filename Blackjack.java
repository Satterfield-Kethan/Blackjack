import java.util.*;
public class Blackjack
{
    public static void main (String [] args)
    {
        Scanner key= new Scanner (System.in);
        Deck deck = new Deck();
        ArrayList<Card> dealer = new ArrayList<Card>();
        ArrayList<Card> player = new ArrayList<Card>();
        String ans="n";
        int dealerAces=0;
        int playerAces=0;
        System.out.println("How much total money do you have? This is not your bet amount.");
        int totalAmount=key.nextInt();
        key.nextLine();
        do
        {
            System.out.println("\nHow much would you like to bet?");
            int betAmount=key.nextInt();
            while(betAmount>totalAmount)
            {
                System.out.println("You do not have enough money. You only have $"+totalAmount
                    +"\nHow much would you like to bet?");
                betAmount=key.nextInt();
            }

            key.nextLine();
            player.add(deck.draw());
            if(player.get(0).getName().equals("Ace"))
                playerAces++;
            dealer.add(deck.draw());
            if(dealer.get(0).getName().equals("Ace"))
                dealerAces++;
            player.add(deck.draw());
            if(player.get(1).getName().equals("Ace"))
                playerAces++;
            dealer.add(deck.draw());
            if(dealer.get(1).getName().equals("Ace"))
                dealerAces++;
            int dealerTotal=0;
            int playerTotal=0;

            playerTotal+=player.get(0).getValue();
            playerTotal+=player.get(1).getValue();
            dealerTotal+=dealer.get(0).getValue();
            dealerTotal+=dealer.get(1).getValue();

            System.out.println("The dealer has the "+dealer.get(0)
                +" and the other card is hidden.\n\nYour cards are the "
                +player.get(0)+" and the "+player.get(1)+".\nTheir sum is "
                +playerTotal+".");
            do
            {
                System.out.println("Would you like a hit? Y or N");
                String ans2=key.nextLine();
                while(!ans2.equalsIgnoreCase("y")&&(!ans2.equalsIgnoreCase("n")))
                {
                    System.out.println("Please respond with Y or N.\nWould you like a hit?");
                    ans2=key.nextLine();
                }
                if(ans2.equalsIgnoreCase("Y"))
                {
                    player.add(deck.draw());
                    playerTotal+=player.get(player.size()-1).getValue();
                    if(player.get(player.size()-1).getName().equals("Ace"))
                        playerAces++;
                    System.out.println("Your card is the "+player.get(player.size()-1));
                    if(playerTotal>21)
                    {
                        if(playerAces>0)
                        {
                            while(playerTotal<21 && playerAces>0)
                            {
                                playerTotal-=10;
                            }
                            System.out.println("\nYour new total is "+playerTotal);
                        }
                        else
                            System.out.println("\nYour new total is "+playerTotal+". You busted!(meaning you lost:()");
                    }
                    else if(playerTotal==21)
                        System.out.println("\nYour new total is "+playerTotal+". Blackjack!");
                    else
                        System.out.println("\nYour new total is "+playerTotal+".");
                }
                else
                    break;
            }while(playerTotal<21);
            System.out.println("\nNow it's time for the dealer to play.\nHe flips over his hidden card. It is the "
                +dealer.get(1)+". His total is "+dealerTotal);
            do
            {
                if(dealerTotal<17)
                {
                    System.out.println("Since the dealer has a value total of less than 17, he must continue to play.");
                    dealer.add(deck.draw());
                    dealerTotal+=dealer.get(dealer.size()-1).getValue();
                    if(dealer.get(dealer.size()-1).getName().equals("Ace"))
                        dealerAces++;
                    System.out.println("The dealer drew the "+dealer.get(dealer.size()-1));
                    if(dealerTotal>21)
                    {
                        if(dealerAces>0)
                        {
                            while(dealerTotal<21 && dealerAces>0)
                            {
                                dealerTotal-=10;
                            }
                            System.out.println("\nThe dealer's new total is "+dealerTotal);
                        }
                        else
                            System.out.println("\nThe dealer's new total is "+dealerTotal+". He busted!");
                    }
                    else if(dealerTotal==21)
                        System.out.println("\nThe dealer's new total is "+dealerTotal+". Blackjack!");
                    else
                        System.out.println("\nThe dealer's total is "+dealerTotal+".");
                }
                else
                    System.out.println("Since the dealer has a value total of more than 17, he is done.");
            }while(dealerTotal<17);

            if(playerTotal>21)
            {
                totalAmount-=betAmount;
                System.out.println("You lose!\nYou now have $"+totalAmount);
            }
            else if(dealerTotal>21)
            {
                totalAmount+=betAmount;
                System.out.println("You win!\nYou now have $"+totalAmount);

            }
            else if(playerTotal>dealerTotal)
            {
                totalAmount+=betAmount;
                System.out.println("You win!\nYou now have $"+totalAmount);

            }
            else if(playerTotal<dealerTotal)
            {
                totalAmount-=betAmount;
                System.out.println("You lose!\nYou now have $"+totalAmount);
            }
            else if(playerTotal==dealerTotal)
            {
                totalAmount-=betAmount;
                System.out.println("It's a tie, and since the casio likes to win, you lose!\nYou now have $"+totalAmount);
            }
            if(totalAmount<=0)
            {
                System.out.println("You are out of money. Its time to go home.");
                ans="n";
            }
            else
            {
                System.out.println("Would you like to play again? Y or N");
                ans=key.nextLine();
                while(!ans.equalsIgnoreCase("y")&&(!ans.equalsIgnoreCase("n")))
                {
                    System.out.println("Please respond with Y or N.\nWould you like to play again?");
                    ans=key.nextLine();
                }
                player.clear();
                dealer.clear();
                deck.resetDeck();
            }
        }while(ans.equalsIgnoreCase("y"));
        System.out.println("Thanks for playing!");
    }
}
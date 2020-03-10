
public class Card
{
    private String name;
    private String suit;
    private int value;
    public Card(String s, String n )
    {
        name=n;
        suit=s;
        switch(name)
        {
            case "2":
            value=2;
            break;
            case "3":
            value=3;
            break;
            case "4":
            value=4;
            break;
            case "5":
            value=5;
            break;
            case "6":
            value=6;
            break;
            case "7":
            value=7;
            break;
            case "8":
            value=8;
            break;
            case "9":
            value=9;
            break;
            case "Ace":
            value=11;
            break;
            default:
            value=10;
            break;
        }
    }

    public String getName()
    {
        return name;
    }

    public String getSuit()
    {
        return suit;
    }

    public int getValue()
    {
        return value;
    }

    public String toString()
    {
        return name + " of " + suit;
    }
}

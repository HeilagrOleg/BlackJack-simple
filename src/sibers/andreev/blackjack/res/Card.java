package sibers.andreev.blackjack.res;

public class Card {

    private String name;
    private String suit;
    private int points;
    private int number;

    public Card(String name, String suit, int points, int number) {
        this.name = name;
        this.points = points;
        this.suit = suit;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

}

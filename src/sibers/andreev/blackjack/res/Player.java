package sibers.andreev.blackjack.res;

import java.util.ArrayList;

public class Player {


    private int pointsForStop;
    private int pointsForContinuation;
    private int chanceTakeCard;
    private int money;
    private int points;
    private boolean isUser;
    private String name;

    private ArrayList<Card> cardsOnHand;

    public Player(String name) {
        this.pointsForStop = 0;
        this.pointsForContinuation = 0;
        this.chanceTakeCard = 0;
        this.cardsOnHand = new ArrayList<>();
        this.money = 10000;
        this.name = name;
        this.isUser = true;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Card> getCardsOnHand() {
        return cardsOnHand;
    }

    public boolean isUser() {
        return isUser;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getPointsForStop() {
        return pointsForStop;
    }

    public int getPointsForContinuation() {
        return pointsForContinuation;
    }

    public int getChanceTakeCard() {
        return chanceTakeCard;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String toString() {
        String cardsNames = "";
        for (Card e:getCardsOnHand()) {
            cardsNames += "|" + e.getName()+" "+e.getSuit();
        }
        cardsNames +="|%nОчки: " + getPoints() + "%n";
        return cardsNames;
    }
}

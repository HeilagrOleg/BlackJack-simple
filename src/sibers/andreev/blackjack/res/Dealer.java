package sibers.andreev.blackjack.res;

public class Dealer extends Robots {

    private int pointsForStop;
    private int pointsForContinuation;
    private int chanceTakeCard;
    private boolean isFirstRound;
    private boolean isUser;
    private String name;

    public Dealer(String name) {
        super(name);
        this.pointsForStop = 17;
        this.pointsForContinuation = 16;
        this.chanceTakeCard = 100;
        this.isFirstRound = true;
        this.name = name;
        isUser = false;
    }

    @Override
    public int getPointsForStop() {
        return pointsForStop;
    }

    @Override
    public int getPointsForContinuation() {
        return pointsForContinuation;
    }

    @Override
    public int getChanceTakeCard() {
        return chanceTakeCard;
    }

    public void setFirstRound(boolean firstRound) {
        this.isFirstRound = firstRound;
    }

    public boolean isFirstRound() {
        return isFirstRound;
    }

    public String firstToString() {

        return  "|" + getCardsOnHand().get(0).getName() + " " + getCardsOnHand().get(0).getSuit() +
                "|(Карта в темную" + ")|%nОчки: " + getCardsOnHand().get(0).getPoints() + "%n";
    }
}

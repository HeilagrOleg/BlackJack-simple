package sibers.andreev.blackjack.res;

public class Robots extends Player {

    private int pointsForStop;
    private int pointsForContinuation;
    private int chanceTakeCard;
    private boolean isUser;
    private String name;

    public Robots(String name) {
        super(name);
        pointsForStop = (int) (17 + Math.random()*19);
        pointsForContinuation = (int) (10 + Math.random()*16);
        chanceTakeCard = (int) (25 + Math.random()*75);
        isUser = false;
    }

    public boolean isUser() {
        return isUser;
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
}

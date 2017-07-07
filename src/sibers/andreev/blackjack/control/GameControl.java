package sibers.andreev.blackjack.control;

import sibers.andreev.blackjack.interfaces.GameAction;
import sibers.andreev.blackjack.res.Card;
import sibers.andreev.blackjack.res.Dealer;
import sibers.andreev.blackjack.res.Deck;
import sibers.andreev.blackjack.res.Player;

import java.util.ArrayList;
import java.util.Arrays;

import static sibers.andreev.blackjack.control.CardsControl.giveCard;
import static sibers.andreev.blackjack.control.CardsControl.isGiveCardBots;

public class GameControl {

    private int bet;
    private ArrayList<Card> gameDeck;
    private int moneyInBank;
    private Player firstPlayer;
    private Player secondPlayer;
    private Player thirdPlayer;
    private Dealer dealer;

    public GameControl(Player firstPlayer, Player secondPlayer, Player thirdPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.thirdPlayer = thirdPlayer;
        this.dealer = new Dealer("Диллер");
        gameDeck = new Deck().createDeck();
        bet = 1000;
    }

    private void setGameDeck(ArrayList<Card> gameDeck) {
        this.gameDeck = gameDeck;
    }

    public void playRound() {

        clearPlayersAndDeck(new ArrayList<>(Arrays.asList(firstPlayer, secondPlayer, thirdPlayer, dealer)),gameDeck);

        GameAction.startRound();
        placeBet(dealer, firstPlayer, secondPlayer, thirdPlayer);

        CardsControl.giveFirsCards(dealer, gameDeck);
        CardsControl.giveFirsCards(firstPlayer, gameDeck);
        CardsControl.giveFirsCards(secondPlayer, gameDeck);
        CardsControl.giveFirsCards(thirdPlayer, gameDeck);

        GameAction.showBank(moneyInBank);

        GameAction.getFirsRoundStatus(firstPlayer, dealer, secondPlayer, thirdPlayer);
        dealer.setFirstRound(false);

        ArrayList<Player> winnerList = WinnersControl.getWinnersListBlackJack(firstPlayer, secondPlayer, thirdPlayer, dealer);

        getWinners(winnerList, firstPlayer, secondPlayer, thirdPlayer, dealer, false);

        getAction(firstPlayer, gameDeck);
        getAction(secondPlayer, gameDeck);
        getAction(thirdPlayer, gameDeck);
        getAction(dealer, gameDeck);

        GameAction.getFirsRoundStatus(firstPlayer, dealer, secondPlayer, thirdPlayer);

        winnerList.clear();
        winnerList = WinnersControl.getFinalList(firstPlayer, secondPlayer, thirdPlayer, dealer);

        getWinners(winnerList, firstPlayer, secondPlayer, thirdPlayer, dealer, true);
    }

    private void placeBet(Dealer dealer, Player firstPlayer, Player secondPlayer, Player thirdPlayer) {
        int betCounter = 0;
        secondPlayer.setMoney(dealer.getMoney() - bet);
        betCounter++;
        thirdPlayer.setMoney(dealer.getMoney() - bet);
        betCounter++;
        dealer.setMoney(dealer.getMoney() - bet);
        betCounter++;
        firstPlayer.setMoney(firstPlayer.getMoney() - bet);
        betCounter++;
        moneyInBank = bet * betCounter;
    }

    private void getAction(Player player, ArrayList<Card> deck) {
        if (player.isUser()) {
            boolean isChoice = GameAction.isChoicePlayer(player, new boolean[]{true, false});
            while (isChoice) {
                isChoice = GameAction.isChoicePlayer(player, new boolean[]{true, giveCard(player, deck)});
            }
            return;
        }
        while (true) {
            boolean[] isChoiceBot = isGiveCardBots(player, deck);
            if (isChoiceBot[0]) {
                GameAction.showChoiceBot(isChoiceBot, player);
            } else {
                GameAction.showChoiceBot(isChoiceBot, player);
                return;
            }
        }
    }

    private void getWinners(ArrayList<Player> winnerList, Player firstPlayer, Player secondPlayer,
                            Player thirdPlayer, Dealer dealer, boolean isFinal) {
        if (winnerList.size() > 0) {
            if (winnerList.get(0).equals(dealer)) {
                moneyInBank = 0;
                GameAction.showWinnerDealer(dealer);
                if (GameAction.isStatusEndRound(firstPlayer, secondPlayer, thirdPlayer)) {
                    playRound();
                } else {
                    System.exit(0);
                }
            } else {
                int prize = moneyInBank / winnerList.size();
                moneyInBank = 0;
                for (Player e : winnerList) {
                    e.setMoney(e.getMoney() + prize);
                }
                GameAction.showWinners(winnerList);
            }
            if (GameAction.isStatusEndRound(firstPlayer, secondPlayer, thirdPlayer)) {
                playRound();
            } else {
                System.exit(0);
            }
        } else if (isFinal) {
            if (GameAction.showNoWinners()) {
                playRound();
            } else {
                System.exit(0);
            }
        }
    }

    private void clearPlayersAndDeck(ArrayList<Player> playersList, ArrayList<Card> deck) {
        for (Player e : playersList) {
            e.getCardsOnHand().clear();
            e.setPoints(0);
        }
        if (deck.size() <= 14) {
            setGameDeck(new Deck().createDeck());
        }
    }
}

package sibers.andreev.blackjack.interfaces;

import sibers.andreev.blackjack.res.Dealer;
import sibers.andreev.blackjack.res.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class GameAction {

    public static void startRound() {
        Scanner scanner = new Scanner(System.in);
        String roundText = "Игра начинается. Делаем ставки.%n1 - Сделать ставку%n";
        System.out.printf(roundText);
        int choice = scanner.nextInt();
        if (choice == 1) {
            roundText = "Ставки сделаны, начинается раздача карт.%n";
            System.out.printf(roundText);
        } else {
            String fail = "Неверная команда";
            System.out.println(fail);
            startRound();
        }
    }

    public static void getFirsRoundStatus(Player firstPlayer, Dealer dealer, Player secondPlayer, Player thirdPlayer) {
        String firstPlayerCards = "Карты (%s):%n" + firstPlayer.toString() + "%n";
        String dealerCards;
        if (dealer.isFirstRound()) {
            dealerCards = "Карты диллера:%n" + dealer.firstToString() + "%n";
        } else {
            dealerCards = "Карты диллера:%n" + dealer.toString() + "%n";
        }
        String secondPlayerCards = "Карты (%s):%n" + secondPlayer.toString() + "%n";
        String thirdPlayerCards = "Карты (%s):%n" + thirdPlayer.toString() + "%n";
        System.out.printf(firstPlayerCards, firstPlayer.getName());
        System.out.printf(secondPlayerCards, secondPlayer.getName());
        System.out.printf(thirdPlayerCards, thirdPlayer.getName());
        System.out.printf(dealerCards + "----------------%n");
    }

    public static void showWinners(ArrayList<Player> winnersList) {
        String winners = "Победители: ";
        for (Player e : winnersList) {
            winners += e.getName() + "|";
        }
        System.out.println("|" + winners);
    }

    public static void showWinnerDealer(Dealer dealer) {
        System.out.printf("Победил диллер%n" + dealer.toString());
    }

    public static void showBank(int bank) {
        System.out.printf("%nСумма в банке: %d%n", bank);
    }

    public static boolean showNoWinners() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Победителей нет%nПродолжить?%n1 - Да%n2 - Нет%n");
        int choice = scanner.nextInt();
        if (choice == 1) {
            return true;
        } else if (choice == 2) {
            return false;
        } else {
            System.out.printf("Неверная команда");
            showNoWinners();
        }
        return false;
    }

    public static void showChoicePlayer(boolean choice[], Player player) {
        if (choice.length != 3) {
            if (choice[1]) {
                if (choice[0]) {
                    System.out.printf("%n%s: взял карту%n", player.getName());
                    System.out.printf(player.toString());
                } else {
                    System.out.printf("%n%s: остановился%n______%n", player.getName());
                }
            } else {
                System.out.printf("%n%s: перебор%n______%n", player.getName());
            }
        }
    }

    public static boolean isChoicePlayer(Player player, boolean[] isChoice) {
        if (isChoice[1]) {
            GameAction.showChoicePlayer(new boolean[]{true, true}, player);
            GameAction.showChoicePlayer(new boolean[]{false, false}, player);
            return false;
        }
        Scanner scanner = new Scanner(System.in);
        String fail = "Неверная команда";
        String choiceText = "%n1 - Взять карту%n2 - Хватит%n";
        String cards = "%n%s%n" + player.toString() + choiceText;
        System.out.printf(cards, player.getName());
        int choice = scanner.nextInt();
        if (choice == 1) {
            return true;
        } else if (choice == 2) {
            System.out.printf("%n%s: остановился%n______%n", player.getName());
            return false;
        } else {
            System.out.println(fail);
            isChoicePlayer(player, isChoice);
        }
        return false;
    }

    public static boolean isStatusEndRound(Player firstPlayer, Player secondPlayer, Player thirdPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%n%s: %d фишек%n%s: %d фишек%n%s: %d фишек%n",
                firstPlayer.getName(),
                firstPlayer.getMoney(),
                secondPlayer.getName(),
                secondPlayer.getMoney(),
                thirdPlayer.getName(),
                thirdPlayer.getMoney());
        System.out.printf("%nПродолжить?%n1 - Да%n2 - Нет%n");
        int choice = scanner.nextInt();
        if (choice == 1) {
            return true;
        } else if (choice == 2) {
            return false;
        } else {
            System.out.printf("Неверная команда");
            isStatusEndRound(firstPlayer, secondPlayer, thirdPlayer);
        }
        return false;
    }
}

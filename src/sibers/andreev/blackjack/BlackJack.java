package sibers.andreev.blackjack;

import sibers.andreev.blackjack.control.GameControl;
import sibers.andreev.blackjack.interfaces.MenuAction;
import sibers.andreev.blackjack.res.Player;
import sibers.andreev.blackjack.res.Robots;

public class BlackJack {
    public static void main(String[] args) {

        GameControl GameControl;

        if (MenuAction.showMenu()) {
            int playersNumber = MenuAction.showPlayerSelection();
            if (playersNumber == 1) {
                GameControl = new GameControl(new Player("Первый игрок"), new Robots("Первый соперник"),
                        new Robots("Второй соперник"));
                GameControl.playRound();
            } else if (playersNumber == 2) {
                GameControl = new GameControl(new Player("Первый игрок"), new Player("Второй игрок"),
                        new Robots("Первый соперник"));
                GameControl.playRound();
            } else {
                GameControl = new GameControl(new Player("Первый игрок"), new Player("Второй игрок"),
                        new Player("Третий игрок"));
                GameControl.playRound();
            }
        } else {
            System.exit(0);
        }
    }
}

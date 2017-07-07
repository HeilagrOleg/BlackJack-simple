package sibers.andreev.blackjack.res;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cardsInDeck;

    public Deck() {
        this.cardsInDeck = createDeck();
    }

    public ArrayList<Card> createDeck() {

        cardsInDeck = new ArrayList<>(52);

        String suit;
        String name;
        int points;
        int number = 1;

        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    suit = "пик";
                    break;
                case 1:
                    suit = "крестей";
                    break;
                case 2:
                    suit = "червей";
                    break;
                default:
                    suit = "бубей";
                    break;
            }
            for (int j = 0; j < 13; j++) {
                switch (j) {
                    case 0:
                        name = "Туз";
                        points = 11;
                        break;
                    case 1:
                        name = "Двойка";
                        points = 2;
                        break;
                    case 2:
                        name = "Тройка";
                        points = 3;
                        break;
                    case 3:
                        name = "Четверка";
                        points = 4;
                        break;
                    case 4:
                        name = "Пятерка";
                        points = 5;
                        break;
                    case 5:
                        name = "Шестерка";
                        points = 6;
                        break;
                    case 6:
                        name = "Семерка";
                        points = 7;
                        break;
                    case 7:
                        name = "Восьмерка";
                        points = 8;
                        break;
                    case 8:
                        name = "Девятка";
                        points = 9;
                        break;
                    case 9:
                        name = "Десятка";
                        points = 10;
                        break;
                    case 10:
                        name = "Валет";
                        points = 10;
                        break;
                    case 11:
                        name = "Дама";
                        points = 10;
                        break;
                    default:
                        name = "Король";
                        points = 10;
                        break;
                }
                cardsInDeck.add(new Card(name, suit, points, number));
                number++;
            }
        }
        Collections.shuffle(cardsInDeck);
        return cardsInDeck;
    }

    public String toString(){
        String cardsNames = "";
        for (Card e:cardsInDeck) {
            cardsNames += e.getName()+" "+e.getSuit() + "%n";
        }
        return cardsNames;
    }
}

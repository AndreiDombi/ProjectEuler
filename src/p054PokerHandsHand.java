import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class p054PokerHandsHand {
    ArrayList<p054PokerHandsCard> hand;

    public p054PokerHandsHand(ArrayList<p054PokerHandsCard> hand) {
        this.hand = hand;
    }

    public p054PokerHandsHand() {
    }

    public ArrayList<p054PokerHandsCard> getHand() {
        return hand;
    }

    public void setHand(ArrayList<p054PokerHandsCard> hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "p054PokerHandsHand{" +
                "hand=" + hand +
                '}';
    }

    public int getHighCard() {
        return this.hand.stream()
                .mapToInt(p054PokerHandsCard::getNumericCardValue)
                .max()
                .orElse(0);
    }

    public boolean hasOnePair() {
        for (int i = 1; i <= 15; i++) {
            int finalI = i;
            if (this.hand.stream().filter(x -> x.getNumericCardValue() == finalI).count() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTwoPairs() {
        int count = 0;
        for (int i = 1; i <= 15; i++) {
            int finalI = i;
            if (this.hand.stream().filter(x -> x.getNumericCardValue() == finalI).count() == 2) {
                count++;
            }
        }
        return count == 2;
    }

    public boolean hasThreeOfAKind() {
        for (int i = 1; i <= 15; i++) {
            int finalI = i;
            if (this.hand.stream().filter(x -> x.getNumericCardValue() == finalI).count() == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean hasStraight() {
        ArrayList<Integer> cardsArray;
        cardsArray = (ArrayList<Integer>) this.hand.stream().map(p054PokerHandsCard::getNumericCardValue).collect(Collectors.toList());
        Collections.sort(cardsArray);
        for (int i = 0; i < cardsArray.size() - 1; i++) {
            if (cardsArray.get(i) + 1 != cardsArray.get(i + 1))
                return false;
        }
        return true;
    }

    public boolean hasFlush() {
        for (p054PokerHandsCard p054PokerHandsCard : this.hand) {
            if (this.hand.get(0).getCardSuite() != p054PokerHandsCard.getCardSuite())
                return false;
        }
        return true;
    }

    public boolean hasFullHouse() {
        return this.hasOnePair() && this.hasThreeOfAKind();
    }

    public boolean hasFourOfAKind() {
        for (int i = 1; i <= 15; i++) {
            int finalI = i;
            if (this.hand.stream().filter(x -> x.getNumericCardValue() == finalI).count() == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean hasStraightFlush() {
        return this.hasFlush() && this.hasStraight();
    }

    public boolean hasRoyalFlush() {
        ArrayList<Integer> cardsArray;
        cardsArray = (ArrayList<Integer>) this.hand.stream().map(p054PokerHandsCard::getNumericCardValue).collect(Collectors.toList());
        Collections.sort(cardsArray);
        return cardsArray.get(0) == 10 &&
                cardsArray.get(1) == 11 &&
                cardsArray.get(2) == 12 &&
                cardsArray.get(3) == 13 &&
                cardsArray.get(4) == 14 &&
                this.hasFlush();
    }
}

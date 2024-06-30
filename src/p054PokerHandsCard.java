import java.util.Objects;

public class p054PokerHandsCard {
    private Character cardValue;
    private Character cardSuite;
    private int numericCardValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof p054PokerHandsCard that)) return false;
        return getNumericCardValue() == that.getNumericCardValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumericCardValue());
    }

    public p054PokerHandsCard(Character cardValue, Character cardSuite) {
        this.cardValue = cardValue;
        this.cardSuite = cardSuite;
        this.numericCardValue = convertToNumericCardValue();
    }

    public p054PokerHandsCard() {
    }

    public Character getCardValue() {
        return cardValue;
    }

    public void setCardValue(Character cardValue) {
        this.cardValue = cardValue;
    }

    public void setCardSuite(Character cardSuite) {
        this.cardSuite = cardSuite;
    }

    public Character getCardSuite() {
        return cardSuite;
    }
    
    public int convertToNumericCardValue() {
        if (Character.isDigit(this.cardValue)) {
            return Integer.parseInt(String.valueOf(this.cardValue));
        } else if (this.cardValue == 'T') {
            return 10;
        } else if (this.cardValue == 'J') {
            return 11;
        } else if (this.cardValue == 'Q') {
            return 12;
        } else if (this.cardValue == 'K') {
            return 13;
        } else if (this.cardValue == 'A') {
            return 14;
        } else {
            return 0;
        }
    }

    public void setNumericCardValue(int numericCardValue) {
        this.numericCardValue = numericCardValue;
    }

    public int getNumericCardValue() {
        return numericCardValue;
    }

    @Override
    public String toString() {
        return "Card{" + cardValue +
                "," + cardSuite +
                "," + numericCardValue +
                '}';
    }
}

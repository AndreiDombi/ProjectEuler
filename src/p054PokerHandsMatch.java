public class p054PokerHandsMatch {
    private p054PokerHandsHand player1;
    private p054PokerHandsHand player2;

    public p054PokerHandsMatch(p054PokerHandsHand player1, p054PokerHandsHand player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public p054PokerHandsMatch() {
    }

    public p054PokerHandsHand getPlayer1() {
        return player1;
    }

    public void setPlayer1(p054PokerHandsHand player1) {
        this.player1 = player1;
    }

    public p054PokerHandsHand getPlayer2() {
        return player2;
    }

    public void setPlayer2(p054PokerHandsHand player2) {
        this.player2 = player2;
    }

    @Override
    public String toString() {
        return "p054PokerHandsMatch{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }
    public boolean isPLayer1Winner() {
        int scorePlayer1 = 0;
        int scorePlayer2 = 0;
        if (player1.hasOnePair())
            scorePlayer1 += 10;
        if (player2.hasOnePair())
            scorePlayer2 += 10;

        if (player1.hasTwoPairs())
            scorePlayer1 += 100;
        if (player2.hasTwoPairs())
            scorePlayer2 += 100;

        if (player1.hasThreeOfAKind())
            scorePlayer1 += 1000;
        if (player2.hasThreeOfAKind())
            scorePlayer2 += 1000;

        if (player1.hasStraight())
            scorePlayer1 += 10000;
        if (player2.hasStraight())
            scorePlayer2 += 10000;

        if (player1.hasFlush())
            scorePlayer1 += 100000;
        if (player2.hasFlush())
            scorePlayer2 += 100000;

        if (player1.hasFullHouse())
            scorePlayer1 += 1000000;
        if (player2.hasFullHouse())
            scorePlayer2 += 1000000;

        if (player1.hasFourOfAKind())
            scorePlayer1 += 10000000;
        if (player2.hasFourOfAKind())
            scorePlayer2 += 10000000;

        if (player1.hasStraightFlush())
            scorePlayer1 += 100000000;
        if (player2.hasStraightFlush())
            scorePlayer2 += 100000000;

        if (player1.hasRoyalFlush())
            scorePlayer1 += 1000000000;
        if (player2.hasRoyalFlush())
            scorePlayer2 += 1000000000;

        if (scorePlayer1 > scorePlayer2)
            return true;
        if (scorePlayer1 == scorePlayer2) {
            return player1.getHighCard() > player2.getHighCard();
        }
        return false;
    }

}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p054PokerHandsMain {
    static ArrayList<p054PokerHandsMatch> matches = new ArrayList<>();
    public static void readFile() {
        String data;
        try {
            File myObj = new File("p054Input.in");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                ArrayList<String> cards = new ArrayList<>(Arrays.asList(data.split("\\s+")));
                ArrayList<p054PokerHandsCard> cardsPlayer1 = new ArrayList<>();
                ArrayList<p054PokerHandsCard> cardsPlayer2 = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    cardsPlayer1.add(new p054PokerHandsCard(cards.get(i).charAt(0), cards.get(i).charAt(1)));
                }
                for (int i = 5; i < 10; i++) {
                    cardsPlayer2.add(new p054PokerHandsCard(cards.get(i).charAt(0), cards.get(i).charAt(1)));
                }
                p054PokerHandsMatch match = new p054PokerHandsMatch(new p054PokerHandsHand(cardsPlayer1),
                        new p054PokerHandsHand(cardsPlayer2));
                matches.add(match);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void main(String[] args) {
        readFile();
        int count=0;
        ArrayList<p054PokerHandsCard> cards = new ArrayList<>();
        cards.add(new p054PokerHandsCard('A','H'));
        cards.add(new p054PokerHandsCard('T','H'));
        cards.add(new p054PokerHandsCard('K','H'));
        cards.add(new p054PokerHandsCard('J','H'));
        cards.add(new p054PokerHandsCard('Q','H'));
        p054PokerHandsHand hand = new p054PokerHandsHand(cards);
        System.out.println(hand.hasRoyalFlush());

        for (p054PokerHandsMatch match : matches) {
            if(match.getPlayer1().hasStraightFlush())
                System.out.println(match.getPlayer1());
            if(match.getPlayer2().hasStraightFlush())
                System.out.println(match.getPlayer2());
            if(match.isPLayer1Winner())
                count++;
        }
        System.out.println(count);
    }
}

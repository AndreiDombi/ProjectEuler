import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class p042CodedTriangleNumbers {
    static ArrayList<String> words = new ArrayList<>();

    public static String readFile() {
        String data = "";
        try {
            File myObj = new File("p042Input.in");
            Scanner myReader = new Scanner(myObj);
            data = myReader.nextLine();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return data;
    }

    public static void processData() {
        String data = readFile();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if (Character.isLetter(data.charAt(i))) {
                temp.append(data.charAt(i));
            } else {
                if (!temp.isEmpty()) {
                    words.add(String.valueOf(temp));
                }
                temp = new StringBuilder();
            }
        }
    }

    public static int convertStringToInt(String word) {
        return word.chars().sum()-(word.length()*64);
    }

    public static boolean checkTriangleSequence(int x) {
        double discriminant = 1 + 8 * x;
        double sqrtDiscriminant = Math.sqrt(discriminant);
        if (sqrtDiscriminant == (int) sqrtDiscriminant) {
            double n1 = (-1 + sqrtDiscriminant) / 2;
            double n2 = (-1 - sqrtDiscriminant) / 2;
            return n1 == (int) n1 || n2 == (int) n2;
        } else {
            return false;
        }
    }

    public static int countTriangleWords() {
        return (int) words.stream()
                .mapToInt(p042CodedTriangleNumbers::convertStringToInt)
                .filter(p042CodedTriangleNumbers::checkTriangleSequence)
                .count();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        processData();
        System.out.println(countTriangleWords()); //75 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

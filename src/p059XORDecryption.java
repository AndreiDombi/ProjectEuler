import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class p059XORDecryption {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(getTextValue(Objects.requireNonNull(findKey()))); //79 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }

    public static String readFile() {
        String data = "";
        try {
            File myObj = new File("p059Input.in");
            Scanner myReader = new Scanner(myObj);
            data = myReader.nextLine();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return data;
    }

    public static ArrayList<Integer> parseData() {
        return Arrays.stream(readFile().split(","))
                .toList()
                .stream()
                .mapToInt(Integer::parseInt)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static boolean isValid(char d) {
        return ('a' <= d && d <= 'z') ||
                ('A' <= d && d <= 'Z') ||
                ('0' <= d && d <= '9') ||
                d == ' ' || d == '.' || d == ';' ||
                d == ':' || d == '/' || d == ',' ||
                d == '\'' || d == '+' || d == '!' ||
                d == '?' || d == '\"' || d == '-' ||
                d == '(' || d == ')' || d == '[' || d == ']';
    }

    public static int getTextValue(String text) {
        return text.chars().mapToObj(ch -> (char) ch).mapToInt(ch -> (int) ch).sum();
    }

    public static String findKey() {
        ArrayList<Integer> codedText = parseData();
        for (char a = 'a'; a <= 'z'; a++) {
            for (char b = 'a'; b <= 'z'; b++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    ArrayList<Character> keys = new ArrayList<>(Arrays.asList(a, b, c));
                    StringBuilder text = new StringBuilder();
                    boolean valid = true;
                    for (int i = 0; i < codedText.size(); i++) {
                        char xorValue = (char) (codedText.get(i) ^ (int) keys.get(i % 3));
                        if (!isValid(xorValue))
                            valid = false;
                        text.append(xorValue);
                        if (!valid)
                            break;
                    }
                    if (valid)
                        return text.toString();
                }
            }
        }
        return null;
    }
}

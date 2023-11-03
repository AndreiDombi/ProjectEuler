import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p022NamesScores {
    static ArrayList<String> names = new ArrayList<>();

    public static String readFile() {
        String data = "";
        try {
            File myObj = new File("p022Input.in");
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
                    names.add(String.valueOf(temp));
                }
                temp = new StringBuilder();
            }
        }
    }

    public static void sortData() {
        processData();
        Collections.sort(names);
    }

    public static int getNameValue(String name) {
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            sum += (name.charAt(i) - 'A' + 1);
        }
        return sum;
    }

    public static BigInteger getSumNamesValue() {
        sortData();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < names.size(); i++) {
            BigInteger tempNameValue = BigInteger.ZERO;
            tempNameValue = tempNameValue.add(BigInteger.valueOf(getNameValue(names.get(i)))).
                    multiply(BigInteger.valueOf(i + 1));
            sum = sum.add(tempNameValue);
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(getSumNamesValue()); // 125 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

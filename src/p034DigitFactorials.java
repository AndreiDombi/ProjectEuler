import java.math.BigInteger;
import java.util.ArrayList;

public class p034DigitFactorials {
    static ArrayList<Integer> curiosNumbers = new ArrayList<>();

    public static BigInteger factorial(int n) {
        BigInteger f = new BigInteger("1");
        for (int i = n; i > 0; i--)
            f = f.multiply(BigInteger.valueOf(i));
        return f;
    }

    public static boolean checkIfCuriosNumber(int n) {
        BigInteger sumOfFactorials = BigInteger.ZERO;
        int temp = n;
        while (temp > 0) {
            sumOfFactorials = sumOfFactorials.add(factorial(temp % 10));
            temp = temp / 10;
        }
        return sumOfFactorials.equals(BigInteger.valueOf(n));
    }

    public static void findAllCuriosNumbers() {
        for (int i = 3; i <= 100000; i++) {
            if (checkIfCuriosNumber(i)) {
                curiosNumbers.add(i);
            }
        }
    }

    public static int getSumOfList() {
        return curiosNumbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        findAllCuriosNumbers();
        System.out.println(getSumOfList()); //177 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

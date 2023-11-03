import java.math.BigInteger;
import java.util.ArrayList;

public class p023NonAbundantSums {
    static ArrayList<Integer> abundantNumbers = new ArrayList<>();

    public static int getSumDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static boolean isAbundantNumber(int number) {
        return getSumDivisors(number) > number;
    }

    public static void initiateAbundantList() {
        for (int i = 12; i < 28123; i++) {
            if (isAbundantNumber(i)) {
                abundantNumbers.add(i);
            }
        }
    }

    public static boolean isASumOfTwoAbundantNumbers(int number) {
        for (int i = 0; i < abundantNumbers.size(); i++) {
            for (Integer abundantNumber : abundantNumbers) {
                if (abundantNumbers.get(i) + abundantNumber == number) {
                    return true;
                }
                if (abundantNumbers.get(i) > number && abundantNumber > number) {
                    return false;
                }
                if (abundantNumber > number) {
                    break;
                }
            }
        }
        return false;
    }

    public static BigInteger getSumOfNonAbundantNumbers() {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i < 28123; i++) {
            if (!isASumOfTwoAbundantNumbers(i)) {
                sum = sum.add(BigInteger.valueOf(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        initiateAbundantList();
        System.out.println(getSumOfNonAbundantNumbers()); //22.4 seconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

import java.math.BigInteger;

public class p025ThousandDigitFibonacciNumber {
    public static int generateFibonacciNumber() {

        BigInteger f1 = BigInteger.ONE;
        BigInteger f2 = BigInteger.ONE;
        int index = 2;
        while (f2.toString().length() < 1000) {
            BigInteger temp;
            temp = f2;
            f2 = f2.add(f1);
            f1 = temp;
            index++;
            System.out.println(f2.toString().length());
        }
        return index;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(generateFibonacciNumber()); //610 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}


import java.util.stream.IntStream;

public class p046GoldbachsOtherConjecture {
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num <= 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0)
            return false;
        for (int i = 5; i * i <= num; i += 6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        return true;
    }

    public static int nextPrime(int num) {
        return IntStream.range(num + 1, Integer.MAX_VALUE).
                filter(p046GoldbachsOtherConjecture::isPrime).
                findFirst().orElse(0);
    }

    public static boolean sumOfPrimeAnTwiceSquare(int num) {
        for (int i = 2; ; i = nextPrime(i)) {
            for (int j = 1; ; j++) {
                if (i + 2 * j * j == num)
                    return true;
                if (i + 2 * j * j > num)
                    break;
            }
            if (i > num)
                return false;

        }
    }

    public static int findSolution() {
        return IntStream.range(3, Integer.MAX_VALUE).
                filter(value -> !isPrime(value)).
                filter(value -> value % 2 == 1).
                filter(value -> !sumOfPrimeAnTwiceSquare(value)).findFirst().orElse(0);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(findSolution()); //97 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

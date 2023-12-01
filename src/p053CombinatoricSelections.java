import java.math.BigInteger;
import java.util.stream.IntStream;

public class p053CombinatoricSelections {
    public static BigInteger factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    public static BigInteger combinatorFormula(int n, int r) {
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }

    public static int findCombinatoricPairs() {
        return (int) IntStream.rangeClosed(1, 100)
                .flatMap(n -> IntStream.rangeClosed(1, n)
                        .filter(r -> combinatorFormula(n, r).compareTo(BigInteger.valueOf(1000000)) > 0))
                .count();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(findCombinatoricPairs()); //161 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

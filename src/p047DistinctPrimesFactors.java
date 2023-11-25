import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p047DistinctPrimesFactors {
    public static ArrayList<Integer> primes = new ArrayList<>();

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

    public static void generatePrimes() {
        primes = (ArrayList<Integer>) IntStream.range(2, 1000000).
                filter(p047DistinctPrimesFactors::isPrime).
                boxed().collect(Collectors.toList());
    }

    public static boolean numberOfDistinctPrimes(int number) {
        return primes.stream().filter(value -> (number) % value == 0).count() >= 4 &&
                primes.stream().filter(value -> (number + 1) % value == 0).count() >= 4 &&
                primes.stream().filter(value -> (number + 2) % value == 0).count() >= 4 &&
                primes.stream().filter(value -> (number + 3) % value == 0).count() >= 4;
    }

    public static int findConsecutivePrimeCompositeFactors() {
        return IntStream.range(2, Integer.MAX_VALUE)
                .filter(p047DistinctPrimesFactors::numberOfDistinctPrimes)
                .findFirst().orElse(0);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        generatePrimes();
        System.out.println(findConsecutivePrimeCompositeFactors()); //91 seconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p050ConsecutivePrimeSum {
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
        primes = (ArrayList<Integer>) IntStream.range(1, 1000000)
                .filter(p050ConsecutivePrimeSum::isPrime)
                .boxed().collect(Collectors.toList());
    }

    public static int findLongestSequence(int number) {
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i; j < primes.size(); j++) {
                int x = primes.subList(i, j).stream().mapToInt(Integer::intValue).sum();
                if (x == number)
                    return j - i;
                if (x > number)
                    break;
            }
            if (primes.get(i) > number)
                break;
        }
        return 0;
    }

    public static int findLargestPrimesSequenceSum() {
        int max = 0, returnValue = 0;
        for (int i = 10; i < primes.size(); i++) {
            int temp = findLongestSequence(primes.get(i));
            if (temp > max) {
                max = temp;
                returnValue = primes.get(i);
            }
        }
        return returnValue;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        generatePrimes();
        System.out.println(findLargestPrimesSequenceSum()); //46.5 minutes

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

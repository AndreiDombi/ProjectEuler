import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class p060PrimePairSets {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(getAll5Sets());

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Execution time:" + timeElapsed + " milliseconds");

    }

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

    public static ArrayList<Integer> createPrimeList() {
        return IntStream.range(2, 10000).
                filter(p060PrimePairSets::isPrime).
                collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static boolean concatenatingPrime(int a, int b) {
        return isPrime(Integer.parseInt(a + String.valueOf(b))) &&
                isPrime(Integer.parseInt(b + String.valueOf(a)));
    }

    public static boolean concatenatingPrime5(ArrayList<Integer> primes) {
        for (int i = 0; i < primes.size(); i++) {
            for (Integer prime : primes) {
                if (!Objects.equals(primes.get(i), prime)) {
                    if (!concatenatingPrime(primes.get(i), prime)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static int getAll5Sets() {
        ArrayList<Integer> primes = createPrimeList();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < primes.size() - 4; i++) {
            for (int j = i + 1; j < primes.size() - 3; j++) {
                for (int k = j + 1; k < primes.size() - 2; k++) {
                    if (!concatenatingPrime5(new ArrayList<>(
                            Arrays.asList(primes.get(i), primes.get(j)))))
                        break;
                    for (int l = k + 1; l < primes.size() - 1; l++) {
                        if (!concatenatingPrime5(new ArrayList<>(
                                Arrays.asList(primes.get(i), primes.get(j), primes.get(k)))))
                            break;
                        for (int m = l + 1; m < primes.size(); m++) {
                            ArrayList<Integer> fiveSet = new ArrayList<>(Arrays.asList(
                                    primes.get(i),
                                    primes.get(j),
                                    primes.get(k),
                                    primes.get(l),
                                    primes.get(m)));
                            if (concatenatingPrime5(fiveSet)) {
                                if (fiveSet.stream().mapToInt(Integer::intValue).sum() < min) {
                                    min = fiveSet.stream().mapToInt(Integer::intValue).sum();
                                    System.out.println("\n" + fiveSet + " sum:" + min + '\n');
                                }
                            }
                        }
                    }
                }
            }
        }
        return min;
    }
}
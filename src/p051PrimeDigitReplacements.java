import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p051PrimeDigitReplacements {
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
                .filter(p051PrimeDigitReplacements::isPrime)
                .boxed().collect(Collectors.toList());
    }

    static Set<Set<Integer>> generateSubsets(List<Integer> arrayList, int size) {
        Set<Set<Integer>> choices = new HashSet<>();
        for (int i = 0; i < (1 << arrayList.size()); i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = 0; j < arrayList.size(); j++)
                if ((i & (1 << j)) > 0)
                    temp.add(arrayList.get(j));

            if (temp.size() == size)
                choices.add(temp);
        }
        return choices;
    }

    public static Integer find8FamilyPrime() {
        for (int i = 100; i < primes.size(); i++) {
            List<Integer> indexes = IntStream.range(0, String.valueOf(primes.get(i)).length() - 1).boxed().toList();
            for (int j = 1; j < indexes.size(); j++) {
                for (Set<Integer> integerSet : generateSubsets(indexes, j + 1)) {
                    StringBuilder s = new StringBuilder(primes.get(i).toString());
                    integerSet.forEach(integer -> s.setCharAt(integer, '*'));
                    String s1 = s.toString();

                    long count = IntStream.rangeClosed(0, 9)
                            .mapToObj(k -> s1.replaceAll("\\*", String.valueOf(k)))
                            .mapToInt(Integer::parseInt)
                            .filter(probablePrime -> isPrime(probablePrime) && String.valueOf(probablePrime).length() == s1.length())
                            .count();

                    if (count == 8) {
                        return IntStream.rangeClosed(0, 9)
                                .mapToObj(k -> s1.replaceAll("\\*", String.valueOf(k)))
                                .mapToInt(Integer::parseInt)
                                .filter(probablePrime -> isPrime(probablePrime) && String.valueOf(probablePrime).length() == s1.length())
                                .findFirst()
                                .orElse(0);
                    }
                }
            }

        }
        return null;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        generatePrimes();
        System.out.println(find8FamilyPrime()); //1.5 seconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

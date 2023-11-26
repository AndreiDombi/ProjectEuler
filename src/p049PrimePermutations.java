import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p049PrimePermutations {
    public static List<String> generatePermutations(String input) {
        List<String> result = new ArrayList<>();
        generatePermutationsHelper("", input, result);
        return result;
    }

    private static void generatePermutationsHelper(String prefix, String remaining, List<String> result) {
        int length = remaining.length();
        if (length == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < length; i++) {
                char chosenChar = remaining.charAt(i);
                String newPrefix = prefix + chosenChar;
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                generatePermutationsHelper(newPrefix, newRemaining, result);
            }
        }
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

    public static boolean isPrimePermutation(int number) {
        return generatePermutations(String.valueOf(number))
                .stream()
                .filter(value -> isPrime(Integer.parseInt(value)))
                .count() >= 3;
    }

    public static List<Integer> generatePermutationPrimeList(int number) {
        return generatePermutations(String.valueOf(number))
                .stream()
                .filter(value -> isPrime(Integer.parseInt(value)))
                .filter(value -> isPrimePermutation(Integer.parseInt(value)))
                .filter(value -> Integer.parseInt(value) > 1000 && Integer.parseInt(value) < 9999)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static ArrayList<Integer> generatePrimesPermutation() {
        return (ArrayList<Integer>) IntStream.range(1000, 9999)
                .filter(p049PrimePermutations::isPrimePermutation)
                .filter(p049PrimePermutations::isPrime)
                .boxed().collect(Collectors.toList());
    }

    public static String FindSolution() {
        return generatePrimesPermutation().stream()
                .filter(value -> generatePermutationPrimeList(value).contains(value + 3330) &&
                        generatePermutationPrimeList(value).contains(value + 6660))
                .filter(value -> value != 1487).map(value -> String.valueOf(value) +
                        (value + 3330) +
                        (value + 6660)).
                findFirst().orElse(String.valueOf(0));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(FindSolution()); //244 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}
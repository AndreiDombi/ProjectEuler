import java.util.*;

public class p024LexicographicPermutations {

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

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        List<String> permutations = generatePermutations("0123456789");
        System.out.println(permutations.get(1000000)); //1.1 seconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

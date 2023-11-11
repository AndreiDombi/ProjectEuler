import java.util.HashSet;
import java.util.Set;

public class p032PandigitalProducts {
    static Set<Integer> pandigitalProducts = new HashSet<>();

    public static boolean isPandigital(int a, int b, int c) {
        StringBuilder allDigits = new StringBuilder();
        allDigits.append(a).append(b).append(c);
        return allDigits.
                chars().
                sorted().
                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).
                toString().equals("123456789");

    }

    public static void generatePandigitalProducts() {
        for (int a = 1; a < 10000; a++) {
            for (int b = 1; b < 10000; b++) {
                if (isPandigital(a, b, a * b)) {
                    pandigitalProducts.add(a * b);
                }
            }
        }
    }

    public static int calculateSumPandigital() {
        return pandigitalProducts.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        generatePandigitalProducts();
        System.out.println(calculateSumPandigital()); //38 seconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}


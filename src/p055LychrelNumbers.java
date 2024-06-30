import java.math.BigInteger;
import java.util.stream.IntStream;

public class p055LychrelNumbers {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(findSolution()); //150 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static String getNumberReverse(String number) {
        StringBuilder reverse = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            if (!(number.charAt(i) == '0' && reverse.isEmpty()))
                reverse.append(number.charAt(i));
        }
        return reverse.toString();
    }

    private static boolean isLychrelNumber(String number) {
        BigInteger lychrelNumber = new BigInteger(number);
        int iteration = 0;
        while (iteration < 50) {
            lychrelNumber = lychrelNumber.add(new BigInteger(getNumberReverse(lychrelNumber.toString())));
            iteration++;
            if (isPalindrome(lychrelNumber.toString())) {
                return false;
            }
        }
        return true;
    }

    private static int findSolution() {
        return (int) IntStream.range(1, 10000).filter(i -> isLychrelNumber(String.valueOf(i))).count();
    }
}

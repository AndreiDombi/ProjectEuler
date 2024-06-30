import java.math.BigInteger;

public class p056PowerfulDigitSum {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(findSolution()); //204 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }

    private static int digitSum(String number) {
        return number.chars().
                mapToObj(ch -> (char) ch).
                mapToInt(ch -> Integer.parseInt(String.valueOf(ch))).
                sum();
    }

    private static int findSolution() {
        int max = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                String bigInteger = BigInteger.valueOf(i).pow(j).toString();
                if (digitSum(bigInteger) > max)
                    max = digitSum(bigInteger);
            }
        }
        return max;
    }
}


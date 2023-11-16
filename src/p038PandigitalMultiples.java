import java.math.BigInteger;

public class p038PandigitalMultiples {

    public static boolean isPandigital(BigInteger a) {
        return String.valueOf(a).
                chars().
                sorted().
                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).
                toString().equals("123456789");
    }

    public static BigInteger concatenate(BigInteger a, BigInteger b) {
        return new BigInteger(a.toString() + b.toString());
    }

    public static int findMaxPandigitalNumber() {
        for (int i = 100000; ; i--) {
            BigInteger temp = BigInteger.valueOf(i);
            BigInteger concat = BigInteger.valueOf(i);
            for (int j = 2; j < 10; j++) {
                concat = concatenate(concat, temp.multiply(BigInteger.valueOf(j)));
                if (isPandigital(concat)) {
                    return Integer.parseInt(concat.toString());
                }
                if (concat.toString().length() > 10) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(findMaxPandigitalNumber()); //370 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

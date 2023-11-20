import java.math.BigInteger;

public class p043SubstringDivisibility {
    public static boolean isPandigital(BigInteger a) {
        return String.valueOf(a).
                chars().
                sorted().
                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).
                toString().equals("0123456789");
    }

    public static boolean checkDivisibility(BigInteger number) {
        return Integer.parseInt(number.toString().substring(1, 4)) % 2 == 0 &&
                Integer.parseInt(number.toString().substring(2, 5)) % 3 == 0 &&
                Integer.parseInt(number.toString().substring(3, 6)) % 5 == 0 &&
                Integer.parseInt(number.toString().substring(4, 7)) % 7 == 0 &&
                Integer.parseInt(number.toString().substring(5, 8)) % 11 == 0 &&
                Integer.parseInt(number.toString().substring(6, 9)) % 13 == 0 &&
                Integer.parseInt(number.toString().substring(7, 10)) % 17 == 0;
    }

    public static BigInteger generateSumSubstringDivisibility() {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i = BigInteger.valueOf(1023456789); i.compareTo(new BigInteger("9999999999")) < 0; i = i.add(BigInteger.ONE)) {
            if (isPandigital(i) && checkDivisibility(i)) {
                sum = sum.add(i);
                System.out.print(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(generateSumSubstringDivisibility()); //1.8 hours

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

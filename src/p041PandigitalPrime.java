import java.math.BigInteger;

public class p041PandigitalPrime {
    public static boolean isPrime(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) < 1)
            return false;
        if (num.compareTo(BigInteger.valueOf(3)) < 1)
            return true;
        if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO) || num.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO))
            return false;
        for (BigInteger i = BigInteger.valueOf(5); i.multiply(i).compareTo(num) < 1; i = i.add(BigInteger.valueOf(6)))
            if (num.mod(i).equals(BigInteger.ZERO) || num.mod(i.add(BigInteger.TWO)).equals(BigInteger.ZERO))
                return false;
        return true;
    }

    public static boolean isPandigital(BigInteger a) {
        return String.valueOf(a).
                chars().
                sorted().
                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).
                toString().equals("123456789".substring(0,a.toString().length()));
    }

    public static BigInteger generateBiggestPandigitalPrime() {
        for (BigInteger i = BigInteger.valueOf(987654321); ; i = i.subtract(BigInteger.ONE)) {
            if (isPandigital(i) && isPrime(i))
                return i;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(generateBiggestPandigitalPrime()); //11 minutes

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

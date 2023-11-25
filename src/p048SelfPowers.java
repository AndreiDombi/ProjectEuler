import java.math.BigInteger;
import java.util.stream.IntStream;

public class p048SelfPowers {
    public static String selfPowers() {
        return IntStream.range(1, 1000)
                .mapToObj(i -> BigInteger.valueOf(i).pow(i))
                .reduce(BigInteger.ZERO, BigInteger::add).toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(selfPowers().substring(selfPowers().length()-10)); //81 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }

}

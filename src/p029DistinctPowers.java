import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p029DistinctPowers {
    static Set<BigInteger> sequence = new HashSet<>();

    public static void populateArray() {
        sequence = IntStream.rangeClosed(2, 100).boxed()
                .flatMap(i -> IntStream.rangeClosed(2, 100)
                        .mapToObj(j -> new BigInteger(String.valueOf(BigInteger.valueOf(i).pow(j)))))
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        populateArray();
        System.out.println(sequence.size()); //176 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}
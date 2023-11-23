import java.util.stream.IntStream;

public class p045TriangularPentagonalHexagonal {

    static boolean checkTriangle(long number) {
        return (1 + Math.sqrt(1 + 8 * number)) % 2 == 0 &&
                (int) Math.sqrt(1 + 8 * number) * Math.sqrt(1 + 8 * number) == 1 + 8 * number;
    }

    static boolean checkPentagon(long number) {
        return (1 + Math.sqrt(1 + 24 * number)) % 6 == 0 &&
                (int) Math.sqrt(1 + 24 * number) * Math.sqrt(1 + 24 * number) == 1 + 24 * number;
    }

    static boolean checkHexagonal(long number) {
        return (1 + Math.sqrt(1 + 8 * number)) % 4 == 0 &&
                (int) Math.sqrt(1 + 8 * number) * Math.sqrt(1 + 8 * number) == 1 + 8 * number;
    }

    static int findTriangularPentagonalHexagonal() {
        return IntStream.range(40756, Integer.MAX_VALUE).
                filter(p045TriangularPentagonalHexagonal::checkTriangle).
                filter(p045TriangularPentagonalHexagonal::checkPentagon).
                filter(p045TriangularPentagonalHexagonal::checkHexagonal).
                findFirst().orElse(0);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(findTriangularPentagonalHexagonal()); //66 seconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

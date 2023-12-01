import java.util.stream.IntStream;

public class p052PermutedMultiples {
    public static boolean checkMultiplesDigits(int number) {
        return String.valueOf(number).chars().sorted().
                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString().contentEquals(String.valueOf(number * 2).chars().sorted().
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)) &&
                String.valueOf(number).chars().sorted().
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString().contentEquals(String.valueOf(number * 3).chars().sorted().
                                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)) &&
                String.valueOf(number).chars().sorted().
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString().contentEquals(String.valueOf(number * 4).chars().sorted().
                                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)) &&
                String.valueOf(number).chars().sorted().
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString().contentEquals(String.valueOf(number * 5).chars().sorted().
                                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)) &&
                String.valueOf(number).chars().sorted().
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString().contentEquals(String.valueOf(number * 6).chars().sorted().
                                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append));
    }

    public static int findInteger() {
        return IntStream.range(1, Integer.MAX_VALUE / 6).filter(p052PermutedMultiples::checkMultiplesDigits).findFirst().orElse(0);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(findInteger()); //299 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

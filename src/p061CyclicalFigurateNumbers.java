import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class p061CyclicalFigurateNumbers {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        getSolution(); //229 minutes

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Execution time:" + (timeElapsed / 60000) + " minutes");
    }

    private static boolean isTriangle(int x) {
        return IntStream.range(1, x).anyMatch(i -> i * (i + 1) / 2 == x);
    }

    private static boolean isSquare(int x) {
        return IntStream.range(1, x).anyMatch(i -> i * i == x);
    }

    private static boolean isPentagonal(int x) {
        return IntStream.range(1, x).anyMatch(i -> i * (3 * i - 1) / 2 == x);
    }

    private static boolean isHexagonal(int x) {
        return IntStream.range(1, x).anyMatch(i -> i * (2 * i - 1) == x);
    }

    private static boolean isHeptagonal(int x) {
        return IntStream.range(1, x).anyMatch(i -> i * (5 * i - 3) / 2 == x);
    }

    private static boolean isOctagonal(int x) {
        return IntStream.range(1, x).anyMatch(i -> i * (3 * i - 2) == x);
    }

    private static ArrayList<Integer> generateTriangles() {
        return IntStream.range(999, 10000).filter(p061CyclicalFigurateNumbers::isTriangle).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private static ArrayList<Integer> generateSquares() {
        return IntStream.range(999, 10000).filter(p061CyclicalFigurateNumbers::isSquare).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private static ArrayList<Integer> generatePentagonals() {
        return IntStream.range(999, 10000).filter(p061CyclicalFigurateNumbers::isPentagonal).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private static ArrayList<Integer> generateHexagonals() {
        return IntStream.range(999, 10000).filter(p061CyclicalFigurateNumbers::isHexagonal).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private static ArrayList<Integer> generateHeptagonals() {
        return IntStream.range(999, 10000).filter(p061CyclicalFigurateNumbers::isHeptagonal).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private static ArrayList<Integer> generateOctogonals() {
        return IntStream.range(999, 10000).filter(p061CyclicalFigurateNumbers::isOctagonal).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private static boolean checkIfDifferent(ArrayList<Integer> cyclic) {
        Set<Integer> set = new HashSet<>(cyclic);
        return set.size() == cyclic.size();
    }

    private static boolean checkCyclicString(ArrayList<Integer> cyclic) {
        ArrayList<String> parts1 = new ArrayList<>();
        ArrayList<String> parts2 = new ArrayList<>();
        for (Integer integer : cyclic) {
            parts1.add(String.valueOf(integer % 100));
            parts2.add(String.valueOf(integer / 100));
        }
        for (String s : parts1) {
            if (!parts2.remove(s))
                return false;
        }
        return parts2.isEmpty();
    }

    public static void getSolution() {
        int min = Integer.MAX_VALUE;

        ArrayList<Integer> triangles = generateTriangles();
        ArrayList<Integer> squares = generateSquares();
        ArrayList<Integer> pentagonals = generatePentagonals();
        ArrayList<Integer> hexagonals = generateHexagonals();
        ArrayList<Integer> heptagonals = generateHeptagonals();
        ArrayList<Integer> octogonals = generateOctogonals();

        for (Integer triangle : triangles) {
            for (Integer square : squares) {
                for (Integer pentagon : pentagonals) {
                    for (Integer hexagon : hexagonals) {
                        for (Integer heptagon : heptagonals) {
                            for (Integer octogon : octogonals) {
                                ArrayList<Integer> solution = new ArrayList<>(Arrays.asList(triangle, square, pentagon, hexagon, heptagon, octogon));
                                if (checkIfDifferent(solution)) {
                                    if (checkCyclicString(solution)) {
                                        System.out.println(solution + " " + solution.stream().mapToInt(Integer::valueOf).sum());
                                        if (min > solution.stream().mapToInt(Integer::valueOf).sum()) {
                                            min = solution.stream().mapToInt(Integer::valueOf).sum();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

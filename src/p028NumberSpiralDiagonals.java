import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class p028NumberSpiralDiagonals {
    static ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

    public static void initializeMatrix() {
        for (int i = 0; i < 1001; i++) {
            matrix.add(Stream.generate(() -> 0).limit(1001).collect(Collectors.toCollection(ArrayList::new)));
        }
    }

    public static void populateMatrix() {
        initializeMatrix();
        int n = 1001;
        int value = 1001 * 1001;
        int minCol = 0, maxCol = n - 1, minRow = 0, maxRow = n - 1;
        while (value >= 1) {
            for (int i = minCol; i <= maxCol; i++) {
                matrix.get(minRow).set(i, value);
                value--;
            }
            for (int i = minRow + 1; i <= maxRow; i++) {
                matrix.get(i).set(maxCol, value);
                value--;
            }
            for (int i = maxCol - 1; i >= minCol; i--) {
                matrix.get(maxRow).set(i, value);
                value--;
            }
            for (int i = maxRow - 1; i >= minRow + 1; i--) {
                matrix.get(i).set(minCol, value);
                value--;
            }
            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }
    }

    public static int sumOfDiagonals() {
        int sum = 0;
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if (i == j || i + j + 1 == 1001)
                    sum += matrix.get(i).get(j);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        populateMatrix();
        System.out.println(sumOfDiagonals()); //134 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

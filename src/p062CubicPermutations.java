import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;

public class p062CubicPermutations {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(findCubePermutation(generateCubes())); //1369 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Execution time:" + (timeElapsed) + " milliseconds");
    }

    public static String findCubePermutation(ArrayList<ArrayList<String>> listOfCubes) {
        for (int i = 0; i < listOfCubes.size() - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < listOfCubes.size(); j++) {
                if (Objects.equals(listOfCubes.get(i).get(1), listOfCubes.get(j).get(1)))
                    count++;
            }
            if (count == 4)
                return (new BigInteger(listOfCubes.get(i).get(0)).pow(3).toString());
        }
        return null;
    }

    public static ArrayList<ArrayList<String>> generateCubes() {
        ArrayList<ArrayList<String>> listOfCubes = new ArrayList<>();
        for (int i = 10; i < 10000; i++) {
            ArrayList<String> temp = new ArrayList<>();
            BigInteger cube = new BigInteger(String.valueOf(i)).pow(3);
            temp.add(String.valueOf(i));
            temp.add(cube.toString().
                    chars().
                    sorted().
                    collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).
                    toString());
            listOfCubes.add(temp);
        }
        return listOfCubes;
    }
}

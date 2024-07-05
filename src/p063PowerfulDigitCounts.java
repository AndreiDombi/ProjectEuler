import java.math.BigInteger;

public class p063PowerfulDigitCounts {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(findSolution()); //7.2 seconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Execution time:" + (timeElapsed) + " milliseconds");
    }

    public static int findSolution() {
        int count = 0;
        for (int i = 1; i < 5000; i++) {
            for (int j = 1; j < Integer.MAX_VALUE; j++) {
                String s = new BigInteger(String.valueOf(j)).pow(i).toString();
                if (s.length() == i)
                    count++;
                else if (s.length() > i)
                    break;
            }
        }
        return count;
    }
}

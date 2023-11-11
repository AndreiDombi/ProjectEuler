import java.util.ArrayList;

public class p037TruncatablePrimes {
    static ArrayList<Integer> truncatePrimes = new ArrayList<>();

    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num <= 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0)
            return false;
        for (int i = 5; i * i <= num; i += 6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        return true;
    }

    public static ArrayList<Integer> generateTruncateValues(int n) {
        int temp1 = n, temp2 = n;
        ArrayList<Integer> values = new ArrayList<>();
        values.add(n);
        while (true) {
            String x = String.valueOf(temp1).substring(1);
            String y = String.valueOf(temp2).substring(0, String.valueOf(temp2).length() - 1);
            values.add(Integer.valueOf(x));
            values.add(Integer.valueOf(y));
            temp1 = Integer.parseInt(x);
            temp2 = Integer.parseInt(y);
            if (temp1 < 10 && temp2 < 10)
                return values;
        }
    }

    public static boolean checkIfTruncatePrime(ArrayList<Integer> truncateValues) {
        return truncateValues.stream().allMatch(p037TruncatablePrimes::isPrime);
    }

    public static void generateTruncatePrimes() {
        for (int i = 10; i <= 1000000; i++) {
            if (!String.valueOf(i).contains("0") && checkIfTruncatePrime(generateTruncateValues(i))) {
                truncatePrimes.add(i);
            }
        }
    }

    public static int getSumOfList() {
        return truncatePrimes.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        generateTruncatePrimes();
        System.out.println(getSumOfList()); //972 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

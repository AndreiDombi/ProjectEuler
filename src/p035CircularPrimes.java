import java.util.ArrayList;

public class p035CircularPrimes {
    static ArrayList<Integer> circularPrime = new ArrayList<>();

    public static ArrayList<Integer> getCircularValues(int n) {
        int copy = n;
        ArrayList<Integer> circularValues = new ArrayList<>();
        circularValues.add(n);
        while (true) {
            String temp = String.valueOf(copy);
            temp = temp.substring(1) + temp.charAt(0);
            copy = Integer.parseInt(temp);
            if (copy != n) {
                circularValues.add(copy);
            } else {
                return circularValues;
            }
        }
    }

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

    public static boolean checkIfCircularPrime(ArrayList<Integer> circularValues) {
        return circularValues.stream().allMatch(p035CircularPrimes::isPrime);
    }

    public static void generateCircularPrimes() {
        for (int i = 2; i <= 1000000; i++) {
            if (!String.valueOf(i).contains("0") && checkIfCircularPrime(getCircularValues(i)))
                circularPrime.add(i);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        generateCircularPrimes();
        System.out.println(circularPrime.size()); //543 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

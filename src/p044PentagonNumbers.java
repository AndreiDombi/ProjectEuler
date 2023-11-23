public class p044PentagonNumbers {

    static boolean checkPentagon(int number) {
        return (1 + Math.sqrt(1 + 24 * number)) % 6 == 0;
    }

    static int findMinimalPentagonSumDif() {
        int i = 0;
        while (true) {
            i++;
            int k = i * (3 * i - 1) / 2;
            for (int v = 1; v < i; v++) {
                int j = v * (3 * v - 1) / 2;
                if (checkPentagon(k - j) && checkPentagon(k + j)) {
                    return k - j;
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(findMinimalPentagonSumDif()); //160 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

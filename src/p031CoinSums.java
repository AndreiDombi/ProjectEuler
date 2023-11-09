public class p031CoinSums {

    public static int generateCoinCombinations() {
        int count = 0;
        for (int penny_200 = 0; penny_200 <= 1; penny_200++) {
            for (int penny_100 = 0; penny_100 <= 2; penny_100++) {
                for (int penny_50 = 0; penny_50 <= 40; penny_50++) {
                    for (int penny_20 = 0; penny_20 <= 10; penny_20++) {
                        for (int penny_10 = 0; penny_10 <= 20; penny_10++) {
                            for (int penny_5 = 0; penny_5 <= 40; penny_5++) {
                                for (int penny_2 = 0; penny_2 <= 100; penny_2++) {
                                    for (int penny_1 = 0; penny_1 <= 200; penny_1++) {
                                        if (((penny_1) + (2 * penny_2) + (5 * penny_5) + (10 * penny_10) + (20 * penny_20) + (50 * penny_50) + (100 * penny_100) + (200 * penny_200)) == 200)
                                            count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(generateCoinCombinations()); //2.22 minutes

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

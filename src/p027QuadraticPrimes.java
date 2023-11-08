public class p027QuadraticPrimes {
    public static int calculateQuadraticValue(int a,int b,int n) {
        return (int) (Math.pow(n, 2) + a * n + b);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int generateQuadraticCombinations() {
        int bestStreak = 0;
        int coefficientsProduct = 0;
        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b < 1001; b++) {
                int streakPrime = 0;
                for (int n = 2; ; n++) {
                    if (isPrime(calculateQuadraticValue(a, b, n)))
                        streakPrime++;
                    else
                        break;
                }
                if (streakPrime > bestStreak) {
                    bestStreak = streakPrime;
                    coefficientsProduct = a * b;
                }
            }
        }
        return coefficientsProduct;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(generateQuadraticCombinations()); //96 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }


}

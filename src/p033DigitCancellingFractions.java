public class p033DigitCancellingFractions {

    public static int gcd(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int generateFraction() {

        int dp = 1;
        int np = 1;
        for (int c = 1; c <= 9; c++) {
            for (int d = 1; d < c; d++) {
                for (int n = 1; n < d; n++) {
                    if ((n * 10 + c) * d == (c * 10 + d) * n) {
                        np *= n;
                        dp *= d;
                    }
                }
            }
        }
        return dp / gcd(np, dp);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(generateFraction()); //1 millisecond

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

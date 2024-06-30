public class p058SpiralPrimes {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int initialValue = 1;
        int increment = 2;
        int sideLength = 3;
        int diagonalsSize = 1;
        int diagonalsPrime = 0;
        while (true)
        {
            for(int i=0;i<4;i++) {
                initialValue += increment;
                diagonalsSize++;
                if (isPrime(initialValue))
                    diagonalsPrime++;
            }
            if((double) diagonalsPrime /diagonalsSize<.10)
                break;
            increment+=2;
            sideLength+=2;
        }

        System.out.println(sideLength); //190 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);

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

}

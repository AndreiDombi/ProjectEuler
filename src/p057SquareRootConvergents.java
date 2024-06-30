import java.math.BigInteger;

public class p057SquareRootConvergents {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.TWO;
        int count = 2;
        int result = 0;
        while(count<=1000) {
            numerator = numerator.add(denominator.multiply(BigInteger.TWO)); //add 2

            BigInteger temp = numerator; // switch
            numerator = denominator;
            denominator = temp;

            BigInteger tempNominator = numerator.add(denominator);
            if(tempNominator.toString().length()>denominator.toString().length())
                result++;
            count++;
        }
        System.out.println(result); //82 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

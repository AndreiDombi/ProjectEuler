import java.util.ArrayList;

public class p030DigitFifthPowers {

    public static ArrayList<Integer> splitNumberIntoArray(int num) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        while (num > 0) {
            integerArrayList.add(num % 10);
            num = num / 10;
        }
        return integerArrayList;
    }

    public static int getFifthPower(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (Integer num : arrayList) {
            sum += (int) Math.pow(num, 5);
        }
        return sum;
    }

    public static int getSumOfAllFifthPower() {
        int sum = 0;
        for (int i = 2; i <= 200000; i++) {
            if (i == getFifthPower(splitNumberIntoArray(i)))
                sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(getSumOfAllFifthPower()); //64 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

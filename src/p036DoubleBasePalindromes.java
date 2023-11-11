import java.util.ArrayList;

public class p036DoubleBasePalindromes {
    static ArrayList<Integer> doubleBasePalindromes = new ArrayList<>();

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isDoublePalindrome(int n) {
        return (isPalindrome(String.valueOf(n)) && isPalindrome(Integer.toBinaryString(n)));
    }

    public static void generateDoublePalindromes() {
        for (int i = 1; i <= 1000000; i++)
            if (isDoublePalindrome(i))
                doubleBasePalindromes.add(i);
    }

    public static int getSumOfList() {
        return doubleBasePalindromes.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        generateDoublePalindromes();
        System.out.println(getSumOfList()); //68 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

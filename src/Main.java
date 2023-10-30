import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static int problem001(int range, int multiply1, int multiply2) {
        int sum = 0;
        for (int i = 1; i < range; i++) {
            if (i % multiply1 == 0 || i % multiply2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int problem002(int maxValue) {
        int n1 = 1, n2 = 1, sum = 0;
        while (n1 < maxValue) {
            int temp = n2;
            n2 = n1 + n2;
            n1 = temp;
            if (n2 > maxValue)
                break;
            if (n2 % 2 == 0) {
                sum += n2;
            }
        }
        return sum;
    }

    public static BigInteger problem003(BigInteger range) {
        BigInteger factor = BigInteger.TWO;
        while (range.compareTo(BigInteger.ONE) > 0) {
            if (range.mod(factor).compareTo(BigInteger.ZERO) == 0) {
                range = range.divide(factor);
            } else {
                factor = factor.add(BigInteger.ONE);
            }
        }
        return factor;
    }

    public static boolean isPalindrome(int n) {
        int r, sum = 0, temp = n;
        while (n > 0) {
            r = n % 10;
            sum = (sum * 10) + r;
            n = n / 10;
        }
        return temp == sum;
    }

    public static int problem004() {
        int largestPalindrome = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= 100; j--) {
                if (isPalindrome(i * j)) {
                    if (i * j > largestPalindrome) {
                        largestPalindrome = i * j;
                    }
                }
            }
        }
        return largestPalindrome;
    }

    public static int problem005() {
        for (int i = 1; true; i++) {
            boolean check = true;
            for (int j = 1; j <= 20; j++) {
                if (i % j != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                return i;
            }
        }
    }

    public static int problem006() {
        int sum = 0, sum1 = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            sum1 += (i * i);
        }
        return (sum * sum) - sum1;
    }

    public static boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static int problem007() {
        int numberOfPrimes = 0;
        for (int i = 1; true; i++) {
            if (isPrime(i)) {
                numberOfPrimes++;
            }
            if (numberOfPrimes == 10001)
                return i;
        }
    }

    public static BigInteger problem008() {
        String bigNumber = "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";
        BigInteger biggestProduct = BigInteger.ZERO;
        for (int i = 0; i < bigNumber.length() - 13; i++) {
            BigInteger product = BigInteger.ONE;
            for (int j = i; j < i + 13; j++) {
                product = product.multiply(BigInteger.valueOf(Integer.parseInt(String.valueOf(bigNumber.charAt(j)))));
            }
            if (product.compareTo(biggestProduct)>0) {
                biggestProduct = product;
            }
        }
        return biggestProduct;
    }

    public static int problem009() {
        for (int c = 3; c < 1000; c++) {
            for (int b = 2; b < c; b++) {
                for (int a = 1; a < b; a++) {
                    if ((a + b + c) == 1000 && (a * a + b * b) == (c * c)) {
                        return a * b * c;
                    }
                }
            }
        }
        return 0;
    }

    public static BigInteger problem010() {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 2000000; i++) {
            if (isPrime(i)) {
                sum = sum.add(new BigInteger(String.valueOf(i)));
            }
        }
        return sum;
    }

    public static int problem011() {
        ArrayList<String> input = new ArrayList<>(Arrays.asList(
                "08", "02", "22", "97", "38", "15", "00", "40", "00", "75", "04", "05", "07", "78", "52", "12", "50", "77", "91", "08",
                "49", "49", "99", "40", "17", "81", "18", "57", "60", "87", "17", "40", "98", "43", "69", "48", "04", "56", "62", "00",
                "81", "49", "31", "73", "55", "79", "14", "29", "93", "71", "40", "67", "53", "88", "30", "03", "49", "13", "36", "65",
                "52", "70", "95", "23", "04", "60", "11", "42", "69", "24", "68", "56", "01", "32", "56", "71", "37", "02", "36", "91",
                "22", "31", "16", "71", "51", "67", "63", "89", "41", "92", "36", "54", "22", "40", "40", "28", "66", "33", "13", "80",
                "24", "47", "32", "60", "99", "03", "45", "02", "44", "75", "33", "53", "78", "36", "84", "20", "35", "17", "12", "50",
                "32", "98", "81", "28", "64", "23", "67", "10", "26", "38", "40", "67", "59", "54", "70", "66", "18", "38", "64", "70",
                "67", "26", "20", "68", "02", "62", "12", "20", "95", "63", "94", "39", "63", "08", "40", "91", "66", "49", "94", "21",
                "24", "55", "58", "05", "66", "73", "99", "26", "97", "17", "78", "78", "96", "83", "14", "88", "34", "89", "63", "72",
                "21", "36", "23", "09", "75", "00", "76", "44", "20", "45", "35", "14", "00", "61", "33", "97", "34", "31", "33", "95",
                "78", "17", "53", "28", "22", "75", "31", "67", "15", "94", "03", "80", "04", "62", "16", "14", "09", "53", "56", "92",
                "16", "39", "05", "42", "96", "35", "31", "47", "55", "58", "88", "24", "00", "17", "54", "24", "36", "29", "85", "57",
                "86", "56", "00", "48", "35", "71", "89", "07", "05", "44", "44", "37", "44", "60", "21", "58", "51", "54", "17", "58",
                "19", "80", "81", "68", "05", "94", "47", "69", "28", "73", "92", "13", "86", "52", "17", "77", "04", "89", "55", "40",
                "04", "52", "08", "83", "97", "35", "99", "16", "07", "97", "57", "32", "16", "26", "26", "79", "33", "27", "98", "66",
                "88", "36", "68", "87", "57", "62", "20", "72", "03", "46", "33", "67", "46", "55", "12", "32", "63", "93", "53", "69",
                "04", "42", "16", "73", "38", "25", "39", "11", "24", "94", "72", "18", "08", "46", "29", "32", "40", "62", "76", "36",
                "20", "69", "36", "41", "72", "30", "23", "88", "34", "62", "99", "69", "82", "67", "59", "85", "74", "04", "36", "16",
                "20", "73", "35", "29", "78", "31", "90", "01", "74", "31", "49", "71", "48", "86", "81", "16", "23", "57", "05", "54",
                "01", "70", "54", "71", "83", "51", "54", "69", "16", "92", "33", "48", "61", "43", "52", "01", "89", "19", "67", "48"));
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int count = 0;
        int maxValue = 0;
        for (int i = 0; i < 20; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                temp.add(Integer.parseInt(input.get(count)));
                count++;
            }
            matrix.add(temp);
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20 - 3; j++) {
                int a = matrix.get(i).get(j);
                int b = matrix.get(i).get(j + 1);
                int c = matrix.get(i).get(j + 2);
                int d = matrix.get(i).get(j + 3);
                if (a * b * c * d > maxValue) {
                    maxValue = a * b * c * d;
                }
            }
        }
        for (int i = 0; i < 20 - 3; i++) {
            for (int j = 0; j < 20; j++) {
                int a = matrix.get(i).get(j);
                int b = matrix.get(i + 1).get(j);
                int c = matrix.get(i + 2).get(j);
                int d = matrix.get(i + 3).get(j);
                if (a * b * c * d > maxValue) {
                    maxValue = a * b * c * d;
                }
            }
        }
        for (int i = 0; i < 20 - 3; i++) {
            for (int j = 0; j < 20 -3; j++) {
                int a = matrix.get(i).get(j);
                int b = matrix.get(i + 1).get(j+1);
                int c = matrix.get(i + 2).get(j+2);
                int d = matrix.get(i + 3).get(j+3);
                if (a * b * c * d > maxValue) {
                    maxValue = a * b * c * d;
                }
            }
        }
        for (int i = 0; i < 20 - 3; i++) {
            for (int j = 3; j < 20; j++) {
                int a = matrix.get(i).get(j);
                int b = matrix.get(i + 1).get(j-1);
                int c = matrix.get(i + 2).get(j-2);
                int d = matrix.get(i + 3).get(j-3);
                if (a * b * c * d > maxValue) {
                    maxValue = a * b * c * d;
                }
            }
        }
        return maxValue;
    }




    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        /**
         * System.out.println(problem001(1000, 3, 5)); //1 millisecond
         * System.out.println(problem002(4000000)); //1 millisecond
         * System.out.println(problem003(new BigInteger("600851475143"))); //10 milliseconds
         * System.out.println(problem003(new BigInteger("600851475143"))); //10 milliseconds
         * System.out.println(problem004()); //18 milliseconds
         * System.out.println(problem005()); //22 seconds
         * System.out.println(problem006()); //1 millisecond
         * System.out.println(problem007()); //819 milliseconds
         * System.out.println(problem008()); //16 milliseconds
         * System.out.println(problem009()); //19 milliseconds
         * System.out.println(problem010()); //4.15 minutes
         * */
        System.out.println(problem011());
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}
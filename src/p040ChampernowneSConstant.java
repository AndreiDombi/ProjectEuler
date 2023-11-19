public class p040ChampernowneSConstant {
    public static int product() {
        int tenMultiplier = 1;
        int totalDigits = 0;
        int product = 1;
        for (int i = 1; ; i++) {
            if (totalDigits + String.valueOf(i).length() == tenMultiplier) {
                product = product * Integer.parseInt(String.valueOf(String.valueOf(i).charAt(String.valueOf(i).length() - 1)));
                tenMultiplier = tenMultiplier * 10;
                totalDigits = totalDigits + String.valueOf(i).length();
            } else if (totalDigits + String.valueOf(i).length() > tenMultiplier) {
                product = product * Integer.parseInt(String.valueOf(String.valueOf(i).charAt(tenMultiplier - totalDigits - 1)));
                tenMultiplier = tenMultiplier * 10;
                totalDigits = totalDigits + String.valueOf(i).length();
            } else {
                totalDigits = totalDigits + String.valueOf(i).length();
            }
            if (tenMultiplier == 10000000)
                return product;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(product()); //42 milliseconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

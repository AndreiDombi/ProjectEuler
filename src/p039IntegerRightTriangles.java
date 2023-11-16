public class p039IntegerRightTriangles {

    public static int numberOfSolutionsPerimeter(int p) {
        int count = 0;
        for (int a = 1; a <= p; a++) {
            for (int b = a; b <= p; b++) {
                for (int c = b; c <= p; c++) {
                    if ((a + b + c == p) && (c * c == a * a + b * b)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int maxSolutionPerimeter() {
        int max = 0, returnValue = 0;
        for (int i = 10; i <= 1000; i++) {
            int temp = numberOfSolutionsPerimeter(i);
            if (temp > max) {
                max = temp;
                returnValue = i;
            }
        }
        return returnValue;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(maxSolutionPerimeter()); //12.7 seconds

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}

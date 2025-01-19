package method.ex;

public class MethodEx1 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        printAverage(a, b, c);

        int x = 15, y = 25, z = 35;
        printAverage(x, y, z);
    }

    public static void printAverage(int a, int b, int c) {
        int sum = a + b + c;
        double average = sum / 3.0;
        System.out.println("평균값: " + average);
    }
}

package operator;

public class Operator1 {
    public static void main(String[] args) {
        int a = 5, b = 2;

        // 덧셈
        int sum = a + b;
        System.out.println("a + b = " + sum);

        // 뺄셈
        int diff = a - b;
        System.out.println("a - b = " + diff);

        // 곱셈
        int multi = a * b;
        System.out.println("a * b = " + multi);

        // 나눗셈
        int divInt = a / b;
        System.out.println("a / b = " + divInt); // 2.5 아니고 2

        double divDouble = (double)a / b;
        System.out.println("a / b = " + divDouble); // 2.5 아니고 2

        // 나머지
        double remainder = a % b;
        System.out.println("a % b = " + remainder); // 2.5 아니고 2


        System.out.println(16 / 8);

//        int i = 10 / 0; // ZeroDivisionException
    }
}

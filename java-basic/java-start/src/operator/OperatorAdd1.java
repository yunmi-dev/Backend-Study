package operator;

public class OperatorAdd1 {
    public static void main(String[] args) {
        int a = 0;

        // 후위 증감 연산자 (postfix)
        int b = a++; // a = 1, b = 0

        System.out.println("a = " + a);
        System.out.println("b = " + b);


        // 전위 증감 연산자 (prefix)
        b = ++a; // a = 2, b = 2

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        ++a;
        ++a;
        ++a;
        System.out.println("a = " + a); // a = 5
    }
}

package scanner.ex;

public class ChangeVarEx {

    public static void main(String[] args) {
        int a = 10, b = 20;
        int temp;

        temp = a; // a값 사라지지 않게 temp에 보관해둠
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

package method;

public class MethodReturn1 {

    public static void main(String[] args) {
        boolean result = odd(2);
        System.out.println("result = " + result);

        boolean result1 = odd(133);
        System.out.println("result = " + result1);


    }

    public static boolean odd(int a) {
        if (a % 2 == 1) {
            return true;
        }
        return false;
    }
}

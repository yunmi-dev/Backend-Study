package scope;

public class Scope1 {

    public static void main(String[] args) {
        int m = 10; // main 메서드의 local 변수
        if (true) {
            int x = 20; // if 블록의 local 변수

            System.out.println("if m = " + m);
            System.out.println("if x = " + x);
        }

        System.out.println("main m = " + m);
//        System.out.println("main x = " + x); // 접근 불가
    }
}
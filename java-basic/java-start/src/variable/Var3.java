package variable;

public class Var3 {
    public static void main(String[] args) {
        // 1. 변수 선언, 초기화 각각 따로
        int a;
        a = 1;
        System.out.println(a);

        // 2. 변수 선언과 초기화 한번에
        int b = 2;
        System.out.println(b);

        // 3. 변수 여러개 선언과 초기화 한번에
        int c = 3, d = 4;
        System.out.println(c);
        System.out.println(d); // sout 메소드는 단일 파라미터만 받음
    }
}

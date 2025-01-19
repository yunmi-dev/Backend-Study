package overloading;

public class Overloading3 {

    public static void main(String[] args) {
        System.out.println("1: " + add(2, 5));
        // 1번은 두 메서드 다 들어갈 수 있지만, 상식적으로 파라미터 타입까지 전부 동일한 첫번째 메서드를 호출함.
        // 이 상태에서 첫번째 메서드만 지운다면, 자동 형변환을 통해 들어갈 수 있는 2번 메소드를 호출하게 된다.
        System.out.println("2: " + add(1.3, 2.4));
    }

//    public static int add(int a, int b) {
//        System.out.println("1번 호출");
//        return a + b;
//    }

    public static double add(double a, double b) {
        System.out.println("2번 호출");
        return a + b;
    }
}

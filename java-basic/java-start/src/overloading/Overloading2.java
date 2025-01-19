package overloading;

public class Overloading2 {

    public static void main(String[] args) {
        System.out.println("1: " + add(1, 2.55));
        System.out.println("2: " + add(1.55, 2));
    }

    public static int add(int a, double b) {
        System.out.println("1번 호출");
        return (int)(a + b);
    }

    // 오버로딩: 함수이름 같아도 파라미터 형식 다르면 여러개 정의 가능. 근데 반환 타입만 다른건 오버로딩 안됨.
    public static int add(double a, int b) {
        System.out.println("2번 호출");
        return (int)(a + b);
    }
    // 파라미터 타입 다르니까 오버로딩 됨
}

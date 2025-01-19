package method;

public class Method1 {

    public static void main(String[] args) {
        // 메소드 하나 만들면 같은 역할 필요할때 그거 호출만 하면 됨

        int sum1 = add(5, 10); // 메서드 호출
        // 호출할 때 넘기는 5, 10 의 값 자체를 Argument, 인수, 인자 라고 함
        System.out.println("결과1: " + sum1 + "\n");

        int sum2 = add(-100, 500);
        System.out.println("결과2: " + sum2 + "\n");

        add(100, 200); //반환값 안 받고 그냥 메서드 실행만 해도 됨
    }

    // add 메서드 정의
    public static int add(int a, int b) { // 메서드 선언 부분
        // 메서드 본문 부분: 전달받은 파라미터값으로 수행함
        // 호출하는 곳에선 메서드 선언은 알지만 본문은 모름.
        System.out.println(a + " + " + b + " 연산 수행");
        return a + b;
        // 메서드에서 쓰이는 변수인 a, b 를 파라미터(매개변수)라고 함.
        // 넘어온 인수가 매개변수(파라미터)에 대입됨.
    }
    /*
    public - 다른 클래스에서 호출할 수 있는 메서드라는 뜻. (접근 제어 개념)
    static - 객체를 생성하지 않고 호출할 수 있는 정적 메서드라는 뜻.
    아직은 메서드 만들 때 단순하게 이 둘 쓰자.

    파라미터, 반환값 등의 타입들 다 선언부분에서 지정함.
    메서드 호출할때 전달되는 입력값(= 파라미터)은 메서드 안에서만 사용되고,
    메서드 종료되면 사라짐.
     */
}
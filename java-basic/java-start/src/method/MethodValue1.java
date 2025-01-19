package method;

public class MethodValue1 {
    // 자바는 항상 변수의 값을 복사해서 대입함.

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = num1; // 이 부분에서 num1의 값을 복사해서 num2에 넣음.
        // num1의 값을 읽는다고 해서 값이 바뀌지 않음. (너무 당연함)
        num2 = 10;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

    }
}

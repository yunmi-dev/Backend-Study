package method;

public class MethodCasting1 {

    public static void main(String[] args) {
        double doubleNumber = 1.55;

        int intNumber = 100;

//        printNumber(doubleNumber); // 컴파일 오류 double을 int에 쑤셔넣을 수 없음.
        printNumber((int) doubleNumber); // 개발자가 직접 형변환하면 ㄱㄴ
        printNumber(intNumber);
        printNumber2(doubleNumber);
        printNumber2(intNumber); // int를 double로 넣는건 자동 형변환 해주니까 ㄱㅊ
    }

    public static void printNumber(int n) {
        System.out.println("n = " + n);
    }

    public static void printNumber2(double n) {
        System.out.println("n = " + n);
    }
}

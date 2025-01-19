package casting;

public class Casting1 {

    public static void main(String[] args) {
        int intValue = 10;
        long longValue;
        double doubleValue;

        longValue = intValue; // longValue = (long) intValue; 가 자동으로 된거임
        System.out.println("longValue = " + longValue);

        doubleValue = intValue; // doubleValue = (double) intValue; 가 묵시적으로 된거임
        System.out.println("doubleValue = " + doubleValue);

        // int형을 long형과 double형에 할당하는 것처럼 더 작은 범위를 큰범위에 집어넣는건 가능
        // 자연스러운 것이므로 자바가 알아서 형변환을 해주는 거임. 그래서 묵시적 형변환이라고 함

        doubleValue = 200L; // double형에 long형 넣는것도 자연스럽
        System.out.println("doubleValue = " + doubleValue);

        // 범위가 대략 int형 < long형 < double형
        // double은 부동소수점을 사용하기 때문에 더 큰 숫자 범위를 표현함.
    }
}

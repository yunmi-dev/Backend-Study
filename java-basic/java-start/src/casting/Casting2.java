package casting;

public class Casting2 {

    public static void main(String[] args) {
        double doubleValue = 1.5;
        int intValue;

        //intValue = doubleValue; //라고 하면 컴파일 오류 발생함
        intValue = (int)doubleValue; // 명시적 형변환!!

        System.out.println(intValue);
        // 1.5에 int를 취해서 1이 됨

        System.out.println(10.899);
        System.out.println((int) 10.899);
    }
}

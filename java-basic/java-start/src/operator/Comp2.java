package operator;

public class Comp2 {
    public static void main(String[] args) {
        String str1 = "문자열1";
        String str2 = "문자열2";

        boolean result1 = "hello".equals("hello"); // 리터럴 vs. 리터럴
        boolean result2 = str1.equals("문자열1"); // String 변수 vs. 리터럴
        boolean result3 = str1.equals(str2); // String 변수 vs. 변수

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
    }
}

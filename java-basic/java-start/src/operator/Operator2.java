package operator;

public class Operator2 {
    public static void main(String[] args) {
        String result1 = "hello" + " " + "world";
        System.out.println(result1);

        String s1 = "string1", s2 = "string2";
        String result2 = s1 + s2;
        System.out.println(result2);

        // 문자열이랑 숫자를 더하면?
        String result3 = "a + b = " + 10; // 자바가 알아서 10 -> "10" 바꿔줌
        System.out.println(result3);
    }
}

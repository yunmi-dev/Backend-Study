package method.ex;

public class MethodEx2 {

    public static void main(String[] args) {
        String message = "Hello, world!";

        repeatedOutput("졸려", 3);
        repeatedOutput("배고팡", 5);
        repeatedOutput("건형이 바봉", 7);
    }

    public static void repeatedOutput(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
        System.out.println();
    }
}

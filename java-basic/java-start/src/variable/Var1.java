package variable; // 소속된 패키지를 선언해줘야 함

public class Var1 {

    public static void main(String[] args) {
        System.out.println(10);
        System.out.println(10);
        System.out.println(10);

        String str = "Hello";
        String a = "";
        System.out.println(str.length());



    }

    public static int solution(String[] s1, String[] s2) {
        int count = 0;

        for (String s : s1) {
            for (String string : s2) {
                if (s.equals(string)) {
                    count++;
                }
            }
        }

        return count;
    }
}

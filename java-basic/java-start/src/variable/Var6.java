package variable;

public class Var6 {
    public static void main(String[] args) {
        // 정수
        byte b = 127; // -127 ~ 127
        short s = 32767; // -32768 ~ 32767
        int i = 2147483647; // -2147483648 ~ 2147483647 (거의 21억 정도)

        long l = 9223372036854775807L; // 롱이 제일 긴 정수 넣을 수 있음
        // 소문자 l은 1 같아보이니까 L 쓰는 게 관례


        // 실수
        float f = 10.0f;
        double d = 10.0;

//        long z = 2147483648;
        long z = 2147483648L; // int 범위 넘어가면 L 붙여서 long으로


        /*
        실무에서 사용하는 타입

        정수 - int, long: 기본이 int, 20억 넘을 것 같으면 long
            - 파일 다룰땐 (전송 등) byte 쓰고. 파일은 단위가 byte

        실수 - double

        문자열 - String: 문자 하나도 걍 String으로 사용하는 게 편하다.
         */
    }
}
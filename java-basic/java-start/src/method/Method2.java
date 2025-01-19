package method;

public class Method2 {

    public static void main(String[] args) {
        printHeader();

        System.out.println("\n프로그램 실행중\n");

        printFooter();
    }

    public static void printHeader() {
        System.out.println("=== 프로그램을 시작합니다. ===");
        return;
    }
    // 반환하는 것도 없고, 매개변수도 없음.

    public static void printFooter() {
        System.out.println("=== 프로그램을 종료합니다. ===");
    }
    // 명시적으로 중간에 메서드 종료하고 싶을때 return; 쓰면 되고 메서드 가장 끝엔 굳이 return; 안써줘도 됨 (컴파일러가 알아서 넣어줌)
}
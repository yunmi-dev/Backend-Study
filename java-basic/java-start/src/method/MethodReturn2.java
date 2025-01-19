package method;

public class MethodReturn2 {

    public static void main(String[] args) {
        checkAge(10);
        checkAge(20);
    }

    public static void checkAge(int age) {
        if (age < 18) {
            System.out.println(age + "살 미성년자는 출입이 불가능합니다.");
            return; // return 만나면 메서드는 즉시 종료됨
        }
        System.out.println("입장하세요.");
    }
}

package loop;

public class Break2 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; ; i++) { // i는 해당 for문 안에서만 쓸 수 있게 된다.
            sum += i;
            if (sum > 10) {
                System.out.println("합이 처음 10보다 커질 때 종료");
                System.out.println("i = " + i);
                break;
            }
        }
        // for문 없이 while로도 모든 반복 다룰 수 있지만,
        // 카운터 변수 명확하거나, 반복 횟수 정해진 경우엔 for문이 깔끔하고, 유지보수 하기 좋다.
    }
}

package loop;

public class Continue1 {

    public static void main(String[] args) {
        int num = 1;

        while (num <= 5) {
            if (num == 3) {
                num++;
                continue;
            } // 숫자가 3일 땐 출력 건너뛰도록 함
            System.out.println("num = " + num);
            num++;
        }
    }
}
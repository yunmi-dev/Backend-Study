package loop;

public class Break1 {

    public static void main(String[] args) {
        int count = 1, sum = 0;
        while (true) {
            sum += count;
            if (sum > 10) {
                System.out.println("합이 10보다 크면 종료, sum = " + sum);
                break;
            }
            count++;
        }

        System.out.println("count = " + count);
    }
}

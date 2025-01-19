package loop.ex;

public class LoopEx3 {

    public static void main(String[] args) {
        // 1. while문
        int count = 1, max = 10, sum = 0;
        while (count <= max) {
            sum += count;
            count++;
        }
        System.out.println("sum = " + sum);
        
        
        // 2. for문
        sum = 0;
        for (int count1 = 1; count1 <= max; count1++) {
            sum += count1;
        }
        System.out.println("sum = " + sum);
    }
}

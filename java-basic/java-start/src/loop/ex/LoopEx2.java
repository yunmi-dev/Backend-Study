package loop.ex;

public class LoopEx2 {

    public static void main(String[] args) {
        // 1. while문
        int num = 2;
        int count1 = 1;
        while (count1 <= 10) {
            System.out.println(num);
            num += 2;
            count1++;
        }


        // 2. for문
        num = 2;
        for (int count2 = 0; count2 < 10; count2++) {
            System.out.println(num);
            num += 2;
        }
    }
}
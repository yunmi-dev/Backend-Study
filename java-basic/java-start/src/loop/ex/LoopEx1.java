package loop.ex;

public class LoopEx1 {

    public static void main(String[] args) {
        //1. while문
        int count1 = 1;
        while (count1 <= 10) {
            System.out.println(count1++);
        }

        //2. for문
        for (int count2 = 0; count2 < 10; count2++) {
            System.out.println(count2 + 1);
        }
    }
}

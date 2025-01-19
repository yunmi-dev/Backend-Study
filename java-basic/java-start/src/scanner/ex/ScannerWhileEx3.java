package scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("숫자를 입력하세요. 입력을 중단하려면 -1을 입력하세요:");

        int sum = 0, count = 0;
//        while (true) {
//            int num = input.nextInt();
//            if (num == -1) {
//                break;
//            }
//
//            sum += num;
//            count++;
//        } // 이 while문을 축약한 형식도 보여주심.

        int num;
        while ((num = input.nextInt()) != -1) {
            sum += num;
            count++;
        } // -1을 입력받을때까지 반복 실행

        double average = (double) sum / count;
        System.out.println("입력한 숫자들의 합계: " + sum);
        System.out.println("입력한 숫자들의 평균: " + average);
    }
}

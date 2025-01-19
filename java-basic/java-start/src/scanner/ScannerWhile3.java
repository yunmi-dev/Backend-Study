package scanner;

import java.util.Scanner;

public class ScannerWhile3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        System.out.println("0을 입력하면 프로그램을 종료합니다.");

        while (true) {
            System.out.print("숫자 입력: ");
            int inputNum = scanner.nextInt();
            if (inputNum == 0) {
                System.out.println("최종 sum = " + sum);
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            sum += inputNum;
        }
    }
}
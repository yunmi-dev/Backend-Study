package scanner;

import java.util.Scanner;

public class ScannerWhile2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("두 수 모두 0 입력하면 프로그램을 종료합니다.");

        while (true) {
            System.out.print("더할 첫번째 수: ");
            int operand1 = scanner.nextInt();

            System.out.print("더할 두번째 수: ");
            int operand2 = scanner.nextInt();

            if (operand1 == 0 && operand2 == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.println("더한 결과: " + (operand1 + operand2));
        }
    }
}

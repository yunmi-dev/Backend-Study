package method.ex;

import java.util.Scanner;

public class MethodEx4 {

    public static void main(String[] args) {
        int balance = 0;

        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("1. 입금 | 2. 출금 | 3. 잔액 확인 | 4. 종료");
            System.out.println("-------------------------------------");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // 입금
                    System.out.print("입금액을 입력하세요: ");
                    int depositAmount = scanner.nextInt();
                    scanner.nextLine();

                    balance += depositAmount;
                    System.out.println(depositAmount + "원을 입금하였습니다. 현재 잔액: " + balance + "원");
                    break;
                case 2:
                    // 출금
                    System.out.print("출금액을 입력하세요: ");
                    int withdrawAmount = scanner.nextInt();
                    scanner.nextLine();

                    if (balance >= withdrawAmount) {
                        balance -= withdrawAmount;
                        System.out.println(withdrawAmount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
                    } else {
                        System.out.println(withdrawAmount + "원을 출금하려 했으나 잔액이 부족합니다.");
                    }
                    break;
                case 3:
                    // 잔액 확인
                    System.out.println("현재 잔액: " + balance + "원");
                    break;
                case 4:
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 숫자를 입력하세요.");
                    break;
            }
        }
    }
}

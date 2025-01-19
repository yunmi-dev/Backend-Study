package scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("이름을 입력하세요 (종료를 입력하면 종료): ");
            String name = input.nextLine();

            if (name.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.print("나이를 입력하세요: ");
            int age = input.nextInt(); // 여기서 숫자만 읽고 enter키 누르면서 생성된 "\n"는 버퍼에 그대로 남아있어서 다음 nextLine()이 실행되자마자 바로 개행 문자를 만나고 빈 스트링 받고 끝내버림...
            input.nextLine(); // 버퍼에 남은 개행 문자를 처리해줘야 함...!!!!!
            // 라인 한번 읽어줘서 개행문자 버리면 됨.

            System.out.println("입력한 이름: " + name + ", 나이: " + age);

            // nextLine()은 개행문자를 만날때까지의 모든 String 다 가져감.
            // nextInt()는 10\n이 입력됐으면, 거기서 10만 가져가고 개행문자는 버퍼에 남음.
            // 버퍼에 "\n"가 남아있는 상태로 nextLine() 실행되면 바로 개행문자를 만나서 빈 String을 가져가고 끝나버림. 이 부분 처리를 해줘야 함.
        }
    }
}

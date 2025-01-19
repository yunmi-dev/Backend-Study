package scanner;

import java.util.Scanner;

public class Scanner1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Scanner는 System.in을 사용해 사용자의 입력을 받도록 해줌
        // scanner 변수 선언해놓으면, 이제 이걸 통해서 Scanner 사용할 수 있음

        System.out.print("문자열을 입력하세요: ");
        String stringInput = scanner.nextLine(); // 입력을 String으로 가져옴

        System.out.println("입력한 문자열: " + stringInput);


        System.out.print("정수를 입력하세요: ");
        int intInput = scanner.nextInt();
        System.out.println("입력한 정수: " + intInput);

        System.out.print("실수를 입력하세요: ");
        double doubleInput = scanner.nextDouble();
        System.out.println("입력한 실수: " + doubleInput);

    }
}

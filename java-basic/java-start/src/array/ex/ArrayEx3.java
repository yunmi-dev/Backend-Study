package array.ex;

import java.util.Scanner;


public class ArrayEx3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("5개의 정수를 입력하세요:");
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        System.out.println("출력");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[(numbers.length - 1) - i]);
            if (i != numbers.length - 1) {
                System.out.print(", ");
            }
        }
    }
}

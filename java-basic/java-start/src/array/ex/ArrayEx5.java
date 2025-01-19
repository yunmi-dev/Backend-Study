package array.ex;

import java.util.Scanner;

public class ArrayEx5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("입력할 숫자의 개수를 입력하세요: ");
        int count = input.nextInt();

        System.out.println(count + "개의 정수를 입력하세요:");
        int[] numbers = new int[count];
        for (int i = 0; i < count; i ++) {
            numbers[i] = input.nextInt();
        }

        int min = numbers[0], max = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        System.out.println("가장 작은 정수: " + min);
        System.out.println("가장 큰 정수: " + max);
    }
}

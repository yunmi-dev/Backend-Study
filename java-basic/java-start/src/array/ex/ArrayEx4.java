package array.ex;

import java.util.Scanner;

public class ArrayEx4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("입력받을 숫자의 개수를 입력하세요: ");
        int count = input.nextInt();

        System.out.println(count + "개의 정수를 입력하세요:");
        int[] numbers = new int[count];
        int sum = 0;

//        for (int number : numbers) {
//            number = input.nextInt();
//        }  // Enhanced for문 (for-each문) 으로는 배열의 요소를 수정(할당) 할 수 없음...!

        for (int i = 0; i < count; i++) {
            numbers[i] = input.nextInt();
        }
        for (int number : numbers) {
            sum += number;
            System.out.print(number + " ");
        }
        System.out.println();

        double average = (double) sum / count;
        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
    }
}

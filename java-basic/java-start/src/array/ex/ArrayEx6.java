package array.ex;

import java.util.Scanner;

public class ArrayEx6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] scores = new int[4][3];
        String[] subjects = {"국어", "영어", "수학"};

        for (int row = 0; row < scores.length; row++) {
            System.out.println((row+1) + "번 학생의 성적을 입력하세요:");

            for (int col = 0; col < scores[row].length; col++) {
                System.out.print(subjects[col] + " 점수: ");
                scores[row][col] = input.nextInt();
            }
        }

        for (int i = 0; i < 4; i++) {
            int sumScore = scores[i][0] + scores[i][1] + scores[i][2];
            double averageScore = (double) sumScore / 3;
            System.out.println((i+1) + "번 학생의 총점: " + sumScore
            + ", 평균: " + averageScore);
        }
    }
}

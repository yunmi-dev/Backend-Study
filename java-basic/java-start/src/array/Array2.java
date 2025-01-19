package array;

public class Array2 {

    public static void main(String[] args) {
        int[] students = new int[]{90, 80, 70, 60, 50}; // 이렇게 값 직접 넣으면서 배열 생성 & 초기화 가능

        for (int i = 0; i < students.length; i++) {
            System.out.println("students[" + i + "] = " + students[i]);
        }
    }
}

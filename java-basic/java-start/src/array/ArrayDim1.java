package array;

public class ArrayDim1 {

    public static void main(String[] args) {
        int[][] arr = new int[2][3]; // 2 x 3 배열

        int count = 0;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                arr[row][col] = ++count;
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}

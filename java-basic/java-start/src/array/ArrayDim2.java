package array;

public class ArrayDim2 {

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 2, 3, 4},
                {7, 8, 9},
                {13, 14, 15, 16, 17, 18}
        };

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}
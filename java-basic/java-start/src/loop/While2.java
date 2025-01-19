package loop;

public class While2 {

    public static void main(String[] args) {
        int number = 10, endNum = 12, sum = 0;

        while (number <= endNum) {
            sum += number;
            number++;
        }

        System.out.println("sum = " + sum);
    }
}

package cond;

public class If3 {
    public static void main(String[] args) {
        int price = 10000;
        int age = 10;
        int price_sum = price;

        if (price >= 10000) {
            price_sum -= 1000;
        }

        if (age <= 10){
            price_sum -= 1000;
        }

        // 각각 독립된 if문 -> 해당하는 할인을 각각 전부 적용

        System.out.printf("Price is %d.", price_sum);
    }
}

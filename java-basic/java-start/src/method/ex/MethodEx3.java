package method.ex;

public class MethodEx3 {

    public static void main(String[] args) {
        int balance = 10000;

        balance = deposit(balance, 1000);

        balance = withdraw(balance, 2500);
        balance = withdraw(balance, 1500);

        balance = deposit(balance, 4000);

        // 이런식으로 잔액에서 얼마를 입금하고, 출금하고, 마지막에 최종잔액 보여주는구나. 하고 코드만 봐도 전부 읽혀야 좋은 코드.
        // 이게 뭘 짠거지? 하고 들여다보게 되면 안 좋은 코드.


        System.out.println("최종 잔액: " + balance + "원");
    }

    public static int deposit(int balance, int amount) {
        balance += amount;
        System.out.println(amount + "원을 입금하였습니다. 현재 잔액: " + balance + "원");

        return balance;
    }

    public static int withdraw(int balance, int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println(amount + "원을 출금하려 했으나 잔액이 부족합니다.");
        }
        return balance;
    }
}

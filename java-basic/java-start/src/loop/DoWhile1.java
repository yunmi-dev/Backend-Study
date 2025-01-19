package loop;

public class DoWhile1 {

    public static void main(String[] args) {
        int i = 10;

        do {
            System.out.println("i = " + i);
        } while (i < 3);
        // 최초 한번은 항상 실행됨.
        // i < 3 조건은 못 충족하므로 최초실행 후 바로 빠져나옴
    }
}

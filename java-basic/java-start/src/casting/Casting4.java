package casting;

public class Casting4 {

    public static void main(String[] args) {
        int div1 = 3 / 2; //1.5를 int로 받으니까 1
        System.out.println("div1 = " + div1);

        double div2 = 3 / 2; // 1.5 나올것같지만 1.0 나옴...
        System.out.println("div2 = " + div2);
        // 3 / 2 자체가 int과 int의 계산이니까 int값인 1 을 냄
        // 그 1을 double로 받아서 자동 형변환으로 1.0 이 됨

        double div3 = 3.0 / 2; // 1.5
        System.out.println("div3 = " + div3);
        // double과 int 계산이므로 double값인 1.5가 나옴

        double div4 = (double) 3 / 2; // 1.5
        System.out.println("div4 = " + div4);

        /*
        같은 타입끼리의 계산 -> 같은 타입의 결과가 나옴

        다른 타입끼리의 계산 -> 더 큰 범위로 자동 형변환되어 계산됨
        3.0 / 2 이면, 2가 더 큰 범위인 double로 형변환되어, 2.0이 되고 계산됨
         */
    }
}

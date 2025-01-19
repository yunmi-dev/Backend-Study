package scope;

public class Scope3_1 {

    public static void main(String[] args) {
        int m = 10;
        int temp = 0;

        if (m > 0) {
            temp = m * 2;
            System.out.println("temp = " + temp);
        }

        // temp는 m값의 두배를 출력할때 잠깐 쓸 건데 main에 선언해놓으면 if문 끝나도 프로그램 내내 남아있어서 메모리적으로도, 관리 면으로도 비효율적
        // if문 안에서 선언해야 if문 끝나면서 scope 끝나고 사라지기 때문에 깔끔
    }
}

package cond;

public class If4 {

    public static void main(String[] args) {
        if (false) {
            System.out.println("중괄호를 쓰면 이 문장도 포함되고");
            System.out.println("이 문장도 포함됨.");
        }

        if (false)
            System.out.println("중괄호 안쓰면 이 문장만 if구문이고");
            System.out.println("이건 그냥 실행됨.");




    }
}

package method;

public class MethodValue3 {

    public static void main(String[] args) {
        int number = 5;
        System.out.println("changeNumber 넣기 전 number = " + number);
        number = changeNumber(number);
        // 이렇게 계산결과 반환을 받도록 하면 값이 2배가 되겠지
        System.out.println("changeNumber 넣은 후 number = " + number);

        // 메서드로 인수 전달할 때 copy 로 넘기기 때문에... 원 변수 값은 안 바뀜
    }

    public static int changeNumber(int number) {
        System.out.println("changeNumber로 받은 인수: " + number);
        number *= 2;
        System.out.println("changeNumber로 받은 인수를 2배 시킴: " + number);
        return number;
    }
}
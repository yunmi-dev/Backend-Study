package casting;

public class Casting3 {

    public static void main(String[] args) {
        long maxIntValue = 2147483647; // int로 표현가능한 최고값
        long maxIntOver = 2147483648L; // int 최고값 + 1
        int intValue = 0;

        intValue = (int) maxIntValue;
        System.out.println("maxIntValue를 int 타입으로 casting = " + intValue);
        intValue = (int) maxIntOver;
        System.out.println("maxIntOver를 int 타입으로 casting = " + intValue);
        // 헐 오버플로우...

        intValue = (int) 2147483649L;
        System.out.println("intValue = " + intValue);
        intValue = (int) 2147483650L;
        System.out.println("intValue = " + intValue);

        /*
        범위를 넘어서면, 시계 한바퀴 돌듯이 다시 처음부터 시작하는 엉뚱한 수가 나옴 = 오버플로우.
        근데 이 오버플로우를 계산해서 사용하려고 하면 안되고, 애초에
        오버플로우 자체가 일어나지 않게 해야함.

        오버플로우 발생한걸 활용할 생각X. 애초에 오버플로우 자체가 problem임.
        고민하지 말고 걍 int 말고 long 변수로 바꿔서 오버플로우 없애야 하는거임.
         */
    }
}

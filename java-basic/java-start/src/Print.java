public class Print {
    public static void main(String[] args) {
        System.out.println("Hello"); // 줄바꿈 O
        System.out.println("World");

        System.out.print("Hello"); // 줄바꿈 X
        System.out.print("World");
        // 수동으로 \n 넣어서 줄바꿈

        int month = 2, day = 26;
        System.out.printf("My birthday is %d월 %d일.", month, day); // 줄바꿈 X

        System.out.printf("Hello%nWorld");
        // 수동으로 %n 넣어서 줄바꿈 (OS 독립적인 줄바꿈 위해 % 씀)
    }
}

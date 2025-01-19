package array;

public class Array3 {

    public static void main(String[] args) {
        int[] students = {90, 80, 70, 60, 50, 65, 75, 85, 95, 0, 12};
        // 이렇게 간략하게 new int[] 생략 가능!
        /*
        int[] students;
        students = {90, 80, 70, 60, 50};
        이렇게는 안됨. 같은 라인 내에 int[] 를 지정해서 int형 배열임을 바로 알수있을때만 가능
         */

        for (int i = 0; i < students.length; i++) {
            System.out.println("students[" + i + "] = " + students[i]);
        }

        // 이제 {} 안에 값을 추가, 삭제만 하면 나머지 코드 수정안해도 됨
    }
}
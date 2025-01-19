package array;

public class Array1 {

    // 배열은 같은 타입의 변수들을 하나로 묶어둔 것
    public static void main(String[] args) {
        int[] students;         // 배열 변수 선언
        students = new int[5];  // 배열 생성
        // new int[5]를 하면서 int형 5개 넣으려고 마련한 메모리 주소 참조값을 배열의 변수에 반환함.

        // students 배열변수에 무슨 값 있는지 보자
        System.out.println("students = " + students);
        /*
        students = [I@7b23ec81
        [I 는 int형 배열을 뜻함
        @ 뒤가 메모리 참조값 (16진수로 표현)
         */

        // 변수 값 대입
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        // 변수 값 사용하기
        for (int i = 0; i < students.length; i++) {
            System.out.println("학생" + (i + 1) + " 점수: " + students[i]);
        }
    }
}
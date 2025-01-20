package hello.hello_spring.controller;

// HTML form에서 넘어오는 데이터를 임시로 담아두는 객체가 필요함
// 나중에 추가 정보(이메일, 비밀번호 등)가 필요할 때 MemberForm만 수정하면 됨
// 웹 계층에서만 사용되는 객첼, 화면에서 넘어오는 데이터 임시로 담는 용도이므로 Controller들과 같은 패키지에 위치
public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

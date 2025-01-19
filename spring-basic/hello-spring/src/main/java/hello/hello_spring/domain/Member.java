package hello.hello_spring.domain;

public class Member {

    private Long id;        // DB가 부여하는 고유 식별자 (sequence를 통해 부여함)
    private String name;    // 회원가입할 때 사용자가 입력하는 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
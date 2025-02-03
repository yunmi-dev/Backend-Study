package hello.hello_spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// JPA가 관리하는 엔티티가 됨
// 이 클래스는 DB 테이블과 매핑될 거라고 JPA에게 알려줌
@Entity
public class Member {

    // PK 매핑
    @Id // 이 필드가 PK(Primary Key)야!
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 아이덴티티 전략을 사용중 (데이터 저장할 때 id를 직접 설정 안하고, DB가 자동으로 1씩 증가시켜서 넣어주고 있음)
    private Long id;        // PK 필드         // DB가 부여하는 고유 식별자 (sequence를 통해 부여함)
    private String name;    // 일반 필드        // 회원가입할 때 사용자가 입력하는 이름

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
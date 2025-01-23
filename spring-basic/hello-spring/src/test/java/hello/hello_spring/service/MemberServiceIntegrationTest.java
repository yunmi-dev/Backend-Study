package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

/// 테스트케이스에 @Transactional 어노테이션 달아주면,
/// 1. 각 테스트 시작 전에 트랜잭션 시작함
/// 2. 테스트 내용 실행
/// 3. 테스트 완료 후 롤백 실행 (DB 변경사항을 자동으로 원래 상태로 되돌림)
/// 즉, DB 트랜잭션 관리를 통해 자동으로 롤백함. -> 테스트 데이터가 실제 DB에 남지 않아 테스트 격리성이 보장됨

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    /// 기존 코드들은 생성자 injection이 좋은데, 테스트케이스는 편하게 필드로 주입하는 경우가 많음
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        Member member = new Member();
        member.setName("yunmi");

        Long savedId = memberService.join(member);

        Member findMember = memberService.findOne(member.getId()).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_이름_예외() {
        Member member1 = new Member();
        member1.setName("yunmi");

        Member member2 = new Member();
        member2.setName("yunmi");

        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThatThrownBy(() -> memberService.join(member2))
                .isInstanceOf(IllegalStateException.class);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 이름입니다.");

    }
}
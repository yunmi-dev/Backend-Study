package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    /**
    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    // class MemberService에서의 memberRepository와 다른 인스턴스임 (각각 new 해서 생성했으니까) -> 내용물 달라서 문제 생길 가능성 O
    // 같은 인스턴스 쓰게 바꾸려면 여기서 new 하는 걸 지우고
    */

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); // 외부에서 repository 넘어가도록 해서 같은 memberRepository 사용하도록 함.
    } // 테스트 실행할때마다 생성해줌

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() { // 테스트는 과감하게 한국어 써도 됨
        // given (테스트 준비)
        Member member = new Member();
        member.setName("yunmi");

        // when (테스트하려는 동작 실행)
        Long savedId = memberService.join(member);

        // then (결과 검증)
        Member findMember = memberService.findOne(member.getId()).get(); // 명확하니까 Optional 벗김
        assertThat(member.getName()).isEqualTo(findMember.getName()); // 두 객체 이름 같은지 확인
    }

    @Test
    void 중복_이름_예외() {
        // given
        Member member1 = new Member();
        member1.setName("yunmi");

        Member member2 = new Member();
        member2.setName("yunmi");

        // when
        memberService.join(member1);
//        memberService.join(member2);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2)); // JUnit
        // () -> memberService.join(member2)를 실행하면 IllegalAccessError 예외가 터져야 함. = 예외 터질테니까 초록불

        assertThatThrownBy(() -> memberService.join(member2))
                .isInstanceOf(IllegalStateException.class); // AssertJ

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // 발생한 예외 객체를 e에 담음 - 예외가 발생하는지 확인하고
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 이름입니다.");
        // 예외 객체 e를 가지고 추가 검증 (우리가 설정한 메시지가 맞는지 확인) - 발생한 예외의 메시지가 우리가 원하는 메시지가 맞는지도 확인

    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}
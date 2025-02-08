package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given (이런 환경 주어졌을 때)
        Member member = new Member(1L, "yunmi", Grade.VIP);

        // when (이렇게 됐을 때)
        memberService.join(member);
        Member foundMember = memberService.findMember(1L);

        // then (이렇게 된다)
        Assertions.assertThat(member).isEqualTo(foundMember); // 둘아 똑같냐
    }
}

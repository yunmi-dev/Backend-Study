package hello.core.member;

// MemberService는 비즈니스 로직 담당
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}

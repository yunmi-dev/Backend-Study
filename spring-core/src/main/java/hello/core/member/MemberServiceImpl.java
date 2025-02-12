package hello.core.member;

// 구현체가 하나뿐일 땐 '인터페이스명+Impl'로 네이밍 컨벤션 많이 사용함
public class MemberServiceImpl implements MemberService {

    // 회원 가입과 조회에 MemberRepository 인터페이스가 필요
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // MemberRepository 인터페이스의 구현체를 선택해서 할당해줘야 함
    // 인터페이스만 선언하고 구현체를 할당하지 않으면 null pointer exception 발생
    // 이 코드는 DIP(의존관계 역전 원칙)를 위반하는 코드임. 나중에 DI로 개선 예정

    private final MemberRepository memberRepository;
    // 인터페이스만 남김. 이제 추상화에만 의존함 (구체화는 생성자 주입으로)

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

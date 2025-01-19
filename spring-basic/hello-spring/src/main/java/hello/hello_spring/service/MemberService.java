package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    // 외부에서 memberRepository를 넣어줌 = Dependency Injection (DI)
//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {

        // 같은 이름의 회원은 받지 않는다는 조건
        validateDuplicateName(member); // 중복 이름 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateName(Member member) {
        memberRepository.findByName(member.getName()) // Optional (값 있을수도 없을수도 있는 컨테이너) 반환
                .ifPresent(m -> { // Optional의 메소드: 값이 없으면 실행 안함
                    throw new IllegalStateException("이미 존재하는 회원 이름입니다."); // 예외 발생시킴
                }); // findByName의 반환값이 Optional이라서 가능. result에 값이 있다면 동작하는 코드
        // null이 가능할 것 같으면 Optional로 감싸고, 감싼 덕분에 쓸 수 있는 코드 중 하나임
        // 코드 너무 길어서 command+option+m 눌러서 메소드로 뽑아냄
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

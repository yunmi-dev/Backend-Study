package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        // MemberService (인터페이스) 타입의 변수를 선언하고 new MemberServiceImpl() (구현체)의 인스턴스를 생성해서 할당 (다형성 활용을 위해)
        // 아직도 구현체 직접 선택하는 코드가 있어서 DIP 어기는 중
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); // 회원가입

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
        // 이 둘이 같은지 단순 확인
    }
    // 현재까지 순수 자바 코드 (스프링X)
}

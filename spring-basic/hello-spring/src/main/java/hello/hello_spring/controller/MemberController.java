package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // MemberController 객체 생성해서 스프링에 넣어두고 스프링 컨테이너가 관리함.
public class MemberController {

//    private final MemberService memberService = new MemberService();
    /*
    1. 효율성 문제:
    - 여러 컨트롤러들이 MemberService를 가져다 쓸때마다 각각 new로 생성해서 쓰게 되면, 불필요한 중복 인스턴스가 생김
    - 하나의 인스턴스를 공유해서 써도 충분함

    2. 의존성 관리 문제:
    - new로 직접 생성하면 나중에 MemberService 구현이 바뀌었을 때 모든 컨트롤러를 수정해야 함
    - 스프링 컨테이너에 등록하고 주입받아 쓰면 변경에 유연해짐

    => 해결: 스프링 컨테이너에 등록하고, 컨테이너에게서 의존성 주입(DI) 받아 사용

     */

    private final MemberService memberService;

    @Autowired // 어노테이션 있으면 스프링이 관리함
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    } // 지금 MemberService 의존성 주입할라고 하는거임 (주입할라면 MemberService를 빈으로 등록해야함)

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @PostMapping("/members/new")            // HTML form 데이터를 MemberForm 객체로 변환: name 속성값과 MemberForm 필드명이 일치하면(여기선 name) 스프링이 자동으로 데이터 채워줌
    public String create(MemberForm form) { // 여기의 MemberForm으로 자동 바인딩됨
        Member member = new Member();
        member.setName(form.getName()); // 새 Member 객체에 form 데이터 가져옴

//        System.out.println("member.getName() = " + member.getName()); // 잘 전달됐는지 확인해봄

        memberService.join(member); // 회원가입 서비스 호출

        return "redirect:/"; // 홈 화면으로 리다이렉트
    }

    @GetMapping("/members")
    public String list(Model model) { // Medel: 화면에 데이터를 전달하기 위한 객체 -> 컨트롤러에서 화면(view)으로 데이터 전달해야 할 때 씀 (특히 동적으로 변하는 데이터 화면에 표시할 때)
        List<Member> members = memberService.findMembers(); // 모든 회원 조회하는 서비스 호출
        model.addAttribute("members", members); // "members"라는 이름으로 회원 목록을 모델에 추가
        return "members/memberList";
    }
}
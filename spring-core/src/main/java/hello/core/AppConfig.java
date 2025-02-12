package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
        // 생성자를 통해 객체가 들어감
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
/// AppConfig는 애플리케이션의 실제 동작에 필요한 '구현 객체를 생성'한다.
/// AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 '생성자를 통해서 주입(연결)'해준다.
// 지금은 각 클래스에 생성자가 없어서 컴파일 오류 발생함.
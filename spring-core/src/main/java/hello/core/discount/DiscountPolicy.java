package hello.core.discount;

import hello.core.member.Member;

/// 할인 정책 역할 (Discount Policy Interface)
public interface DiscountPolicy {

    /**
     * 할인 금액을 계산한다.
     * @param member 할인 대상 회원
     * @param price 원래 가격
     * @return 할인될 금액
     */
    int discount(Member member, int price);
}

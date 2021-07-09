package developia.core;

import developia.core.discount.DiscountPolicy;
import developia.core.discount.FixDiscountPolicy;
import developia.core.member.MemberRepository;
import developia.core.member.MemberService;
import developia.core.member.MemberServiceImpl;
import developia.core.member.MemoryMemberRepository;
import developia.core.order.OrderService;
import developia.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}

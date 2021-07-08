package developia.core;

import developia.core.discount.FixDiscountPolicy;
import developia.core.member.MemberService;
import developia.core.member.MemberServiceImpl;
import developia.core.member.MemoryMemberRepository;
import developia.core.order.OrderService;
import developia.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}

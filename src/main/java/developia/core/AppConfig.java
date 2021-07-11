package developia.core;

import developia.core.discount.DiscountPolicy;
import developia.core.discount.FixDiscountPolicy;
import developia.core.discount.RateDiscountPolicy;
import developia.core.member.MemberRepository;
import developia.core.member.MemberService;
import developia.core.member.MemberServiceImpl;
import developia.core.member.MemoryMemberRepository;
import developia.core.order.OrderService;
import developia.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

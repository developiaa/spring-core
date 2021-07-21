package developia.core.order;

import developia.core.discount.FixDiscountPolicy;
import developia.core.member.Grade;
import developia.core.member.Member;
import developia.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceImplTest {
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "iteamA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}

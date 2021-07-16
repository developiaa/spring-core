package developia.core.singleton;

import developia.core.AppConfig;
import developia.core.member.MemberRepository;
import developia.core.member.MemberServiceImpl;
import developia.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository2 = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository = memberService.getMemberRepository();
        MemberRepository memberRepository1 = orderService.getMemberRepository();

        System.out.println("MemberService -> memberRepository = " + memberRepository);
        System.out.println("OrderService -> memberRepository1 = " + memberRepository1);
        System.out.println("MemberRepository -> memberRepository2 = " + memberRepository2);

        Assertions.assertThat(memberService.getMemberRepository()).isEqualTo(memberRepository2);
        Assertions.assertThat(orderService.getMemberRepository()).isEqualTo(memberRepository2);
    }
    
    @Test
    void configurationDeep(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
    }
    
}

package developia.core;

import developia.core.member.Grade;
import developia.core.member.Member;
import developia.core.member.MemberService;
import developia.core.member.MemberServiceImpl;
import developia.core.order.Order;
import developia.core.order.OrderService;
import developia.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}

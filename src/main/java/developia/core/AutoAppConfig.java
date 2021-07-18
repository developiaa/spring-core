package developia.core;

import developia.core.member.MemberRepository;
import developia.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "developia.core",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // 자동 빈 등록과 수동 빈 등록이 중복될 경우
    // 수동 빈 등록이 자동 빈 등록을 오버라이딩 한다.
    // >> 이런 부분은 사실 굉장히 잡기 어려운 부분이기 때문에 테스트가 아닌 부분에서 실행할 경우 기본값으로 에러가 나는 부분으로 변경됨
    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}

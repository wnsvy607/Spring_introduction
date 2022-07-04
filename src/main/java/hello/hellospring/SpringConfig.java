package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    //    @Autowired   생성자가 1개일 경우 생략 가능하다.
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean   //Bean을 등록한다는 의미
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    스프링 JPA는 상속한 부모 클래스를 자동으로 매핑해준다. SpringDataJpaMemberRepositoy 인터페이스가
//    MemberRepository를 상속받기 때문에, 해당 구현체를 만들어 위의 생성자에 매핑해준다.
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//
//    }

}

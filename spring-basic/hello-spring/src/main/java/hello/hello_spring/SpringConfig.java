package hello.hello_spring;

import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//import javax.sql.DataSource;

// 자바 코드로 직접 스프링 빈 등록하기

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); // 스프링 빈에 등록된 memberRepository를 넣어줌
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
    // 컴포넌트 스캔을 쓰면 Repository 구현체만 바꾸는 게 불가능한데,
    // 이렇게 설정 파일을 쓰게 되면 다른 코드 수정 없이 리포지토리만 바꿀 수 있음 (설정 파일 쓰는 이유)
}

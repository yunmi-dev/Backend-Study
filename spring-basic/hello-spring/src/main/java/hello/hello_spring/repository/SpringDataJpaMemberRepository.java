package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {  // 인터페이스가 다른 인터페이스 상속할 땐 extends
                                                                                                        // 인터페이스는 다중 상속 가능
    @Override
    Optional<Member> findByName(String name);
} // Spring data JPA가 구현체를 만들어서 스프링 빈에 등록해줌 -> 우린 가져다 쓰기만 하면 됨

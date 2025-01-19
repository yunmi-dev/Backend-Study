package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    // 필요한 기능들 선언만 해두는 인터페이스
}

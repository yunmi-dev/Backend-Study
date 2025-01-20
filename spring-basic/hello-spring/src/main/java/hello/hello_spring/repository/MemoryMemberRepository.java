package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// 원래 코드는 메모리에 데이터를 저장하는 방식 -> 애플리케이션 종료되면 데이터 다 사라짐
//@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);           // 새로운 회원에게 고유 식별자 부여 -> 저장할 때 id 자동 부여되도록
        store.put(member.getId(), member);  // 부여된 번호를 key로 하여 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // id로 찾아서 반환, 없으면 Optional.empty() 반환
        // null safety 위해 (찾는 값 없을 때를 대비해 Optional로 감싸서 안전성 높임)
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

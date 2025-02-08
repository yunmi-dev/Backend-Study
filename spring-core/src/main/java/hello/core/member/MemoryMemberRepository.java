package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// MemberRepository는 데이터 접근 담당
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // 동시성 문제 때문에 ConcurrentHashMap 사용이 더 안전 (하지만 대부분 실무에선 RDB, NoSQL, 캐시 서버 사용)
    // 서버 재시작하면 데이터 모두 사라짐 -> 테스트용으로만 써야 함
    // 모든 데이터를 메모리에 들고 있음 -> 데이터 많아지면 서버 부하 증가

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); // 객체 자체를 저장 -> 완전한 정보 보존 + 확장성과 유지보수성
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

package hello.hello_spring.repository;


import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*; // static import

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        repository.clearStore();
        // 테스트들은 순서 의존관계가 없어야 함
        // 테스트 끝날 때마다 repository나 공용 데이터 비워주는 작업
    }

    @Test
    void save() {
        // given: 이런 데이터가 주어졌을 때
        Member member = new Member();
        member.setName("yunmi jeong");

        // when: 이런 동작을 하면
        repository.save(member); // 테스트해볼 지점인가?

        // then: 이런 결과가 나와야 돼
        Member result = repository.findById(member.getId()).get();

        Assertions.assertEquals(member, result); // expected(예상값)와 actual(실제값)이 같은지 비교해줘
        assertThat(result).isEqualTo(member); // result가 member와 같은지 비교해줘 (이게 더 쉬워서 요즘 이걸 더 선호)
        // 그냥 출력 할 경우
        // → 사람이 눈으로 직접 비교해야 함 😱
        // → 테스트가 100개면 100번을 눈으로 봐야 함 😱

        // assert로 할 경우
        // → 자동으로 비교해서 다르면 테스트 실패라고 알려줌
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("yunmi");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("meeok");
        repository.save(member2);

        assertThat(repository.findByName("yunmi").get()).isEqualTo(member1);
//        assertThat(repository.findByName("yunmi").get()).isEqualTo(member2); // AssertionFailedError

        // AfterEach 처리 없이 전체 테스트케이스 실행하면 다른 테스트케이스에서 할당한 게 남아있어서 AssertionFailedError
        // 테스트 하나 끝날 때마다 데이터 clear 해줄 필요 O
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("yunmi");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("meeok");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
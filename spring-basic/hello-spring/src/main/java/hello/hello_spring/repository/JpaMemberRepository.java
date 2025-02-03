package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import jakarta.persistence.EntityManager; // javax에서 패키지명 변경됨

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    // JPA는 EntityManager에게 DB 3 - 이렇게 만들어진 걸 injection 받으면 됨
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // persist(): 데이터 저장
        // JPA가 이런 SQL 생성: INSERT INTO member(name) VALUES('김철수')
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // id가 PK여서 가능
        Member member = em.find(Member.class, id);  // find(): PK로 데이터 찾기
        // JPA가 이런 SQL 생성: SELECT * FROM member WHERE id = ?
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)   // :name은 파라미터 나타내는 문법 (나중에 실제 값 넣을 자리)
                .setParameter("name", name) // :name 자리에 실제 값 넣어줌
                .getResultList();   // 동명이인도 있을 수 있고 모종의 이유로 List로 받음

        return result.stream().findAny(); // List에서 아무 값이나 하나만 가져오기, Optional로 자동 변환됨, 결과가 없으면 빈 Optional 반환
    }

    @Override
    public List<Member> findAll() {
        // JPQL: 일반 SQL처럼 테이블을 대상으로 하는게 아닌, 객체를 대상으로 쿼리를 날림. (JPA가 이 JPQL을 실제 SQL로 변환해서 실행함)
        return em.createQuery("select m from Member m", Member.class)   // createQuery(): JPQL로 복잡한 조회
                .getResultList();
        // select m from Member (as) m: Member 엔티티 전체를 가져와 (여기서 m은 alias) = 전체 데이터 조회 = 자바 객체 자체를 select함
        // JPA가 이런 SQL 생성: SELECT * FROM member
    }
}
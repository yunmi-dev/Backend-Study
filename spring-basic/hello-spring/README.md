# Spring 기반 회원 관리 시스템

## 프로젝트 소개
Spring Boot를 활용한 회원 관리 시스템입니다. Spring MVC, JPA, AOP 등 다양한 스프링 요소들을 실제로 적용해보며 각 개념의 활용법을 이해하는 데 중점을 두었습니다.


## 구현 기능
- 회원 가입 및 회원 정보 관리
- 회원 목록 조회
- H2 데이터베이스 연동
- AOP를 활용한 메서드 실행 시간 측정


### 사용 기술
`Spring Boot` `Spring MVC` `Spring Data JPA` `H2 Database` `Thymeleaf` `JUnit5` `Gradle`


## 학습 내용 정리

### 1. IoC/DI
- 스프링 컨테이너를 통한 객체 관리
- 생성자 주입을 통한 의존성 관리
```java
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
```

### 2. AOP
공통 관심사를 분리하여 모듈화하는 방법을 학습했습니다.
```java
@Aspect
@Component
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
```

### 3. Spring MVC
- 컨트롤러를 통한 웹 요청 처리
- Thymeleaf를 활용한 뷰 템플릿 구현
```java
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
}
```

### 4. JPA 활용
객체와 테이블을 매핑하여 객체지향적인 데이터 접근 구현
```java
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
```


## 프로젝트 구조
```
hello-spring
 ├── src
 │   ├── main
 │   │   ├── java
 │   │   │   └── hello.hellospring
 │   │   │       ├── SpringConfig.java
 │   │   │       ├── controller
 │   │   │       ├── domain
 │   │   │       ├── repository
 │   │   │       ├── service
 │   │   │       └── aop
 │   │   └── resources
 │   │       ├── static
 │   │       └── templates
 │   └── test
 │       └── java
 │           └── hello.hellospring
 │               ├── service
 │               └── repository
 └── build.gradle
```
  

## 실행 방법

1. 프로젝트 위치로 이동
```bash
cd Backend-Study/hello-spring
```

2. H2 데이터베이스 실행
```bash
cd h2/bin
./h2.sh
```

3. 애플리케이션 실행
```bash
./gradlew bootRun
```

4. 웹 브라우저에서 접속
```
http://localhost:8080
```

## 배운 점
- Spring Framework의 핵심 개념들을 실제 코드로 구현하며 깊이 있게 이해
- 웹 애플리케이션 개발의 전체적인 흐름 파악
- 테스트 코드 작성의 중요성과 방법
- JPA를 통한 객체지향적 데이터 접근 방법


## 참고 문서
- [Spring 공식 문서](https://docs.spring.io/spring-framework/reference/)
- [Spring Boot 공식 문서](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [JPA 공식 문서](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)

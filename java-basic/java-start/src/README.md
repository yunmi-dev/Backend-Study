# Java 기초 학습 정리

> Java의 기본 문법과 객체지향 프로그래밍 개념을 학습하고 실습한 내용 정리

## 학습 내용

### 1. 자바 기초 문법

#### 1.1 변수와 타입
```java
// 기본형 타입
byte b = 127;
short s = 32767;
int i = 2147483647;
long l = 9223372036854775807L;
float f = 3.14f;
double d = 3.14;
char c = 'A';
boolean bool = true;

// 참조형 타입
String str = "Hello Java";
Date date = new Date();
Object obj = new Object();
```

#### 1.2 연산자
```java
// 산술 연산자
int sum = 10 + 20;
int diff = 20 - 10;
int multi = 10 * 20;
int div = 20 / 10;
int mod = 20 % 3;

// 비교 연산자
boolean isEqual = (10 == 20);
boolean isNotEqual = (10 != 20);
boolean isGreater = (20 > 10);

// 논리 연산자
boolean and = true && false;
boolean or = true || false;
boolean not = !true;
```

#### 1.3 조건문
```java
// if-else
if (score >= 90) {
    grade = 'A';
} else if (score >= 80) {
    grade = 'B';
} else {
    grade = 'C';
}

// switch
switch (grade) {
    case 'A':
        System.out.println("우수");
        break;
    case 'B':
        System.out.println("좋음");
        break;
    default:
        System.out.println("보통");
}
```

#### 1.4 반복문
```java
// for
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

// while
int i = 0;
while (i < 10) {
    System.out.println(i);
    i++;
}

// do-while
do {
    System.out.println(i);
    i++;
} while (i < 10);

// for-each
String[] fruits = {"apple", "banana", "orange"};
for (String fruit : fruits) {
    System.out.println(fruit);
}
```

### 2. 객체지향 프로그래밍

#### 2.1 클래스와 객체
```java
public class Car {
    // 필드
    private String brand;
    private String model;
    private int year;
    
    // 생성자
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    
    // 메서드
    public void start() {
        System.out.println("차가 출발합니다.");
    }
}

// 객체 생성
Car myCar = new Car("현대", "쏘나타", 2023);
```

#### 2.2 상속
```java
public class Vehicle {
    protected String brand;
    
    public void start() {
        System.out.println("출발");
    }
}

public class Car extends Vehicle {
    private int wheels;
    
    @Override
    public void start() {
        System.out.println("자동차가 출발합니다.");
    }
}
```

#### 2.3 인터페이스
```java
public interface Movable {
    void move();
    void stop();
}

public class Car implements Movable {
    @Override
    public void move() {
        System.out.println("자동차가 움직입니다.");
    }
    
    @Override
    public void stop() {
        System.out.println("자동차가 멈춥니다.");
    }
}
```

#### 2.4 추상 클래스
```java
public abstract class Animal {
    protected String name;
    
    public abstract void makeSound();
    
    public void sleep() {
        System.out.println("잠을 잡니다.");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("멍멍!");
    }
}
```

### 3. 컬렉션 프레임워크

#### 3.1 List
```java
// ArrayList
List<String> list = new ArrayList<>();
list.add("apple");
list.add("banana");
list.remove("apple");

// LinkedList
List<String> linkedList = new LinkedList<>();
linkedList.add("first");
linkedList.add("second");
```

#### 3.2 Set
```java
Set<String> set = new HashSet<>();
set.add("apple");
set.add("apple"); // 중복 저장 안됨
```

#### 3.3 Map
```java
Map<String, Integer> map = new HashMap<>();
map.put("apple", 1000);
map.put("banana", 2000);
int price = map.get("apple"); // 1000
```

### 4. 예외 처리
```java
try {
    // 예외가 발생할 수 있는 코드
    int result = 10 / 0;
} catch (ArithmeticException e) {
    // 예외 처리
    System.out.println("0으로 나눌 수 없습니다.");
} finally {
    // 항상 실행되는 코드
    System.out.println("연산 종료");
}
```

### 5. 람다식과 스트림
```java
// 람다식
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.forEach(n -> System.out.println(n));

// 스트림
int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
```

## 프로젝트 구조
```
java-basic
 ├── src
 │   ├── basic
 │   │   ├── Variable.java
 │   │   ├── Operator.java
 │   │   ├── Conditional.java
 │   │   └── Loop.java
 │   ├── oop
 │   │   ├── inheritance
 │   │   ├── interface
 │   │   └── abstract
 │   └── collection
 │       ├── ListExample.java
 │       ├── SetExample.java
 │       └── MapExample.java
 └── test
     └── ...
```

## 실행 방법

1. 프로젝트 위치로 이동
```bash
cd Backend-Study/java-basic
```

2. Java 파일 컴파일
```bash
javac Source.java
```

3. 실행
```bash
java Source
```

## 배운 점
- Java의 기본 문법과 객체지향 프로그래밍의 개념을 이해
- 다양한 자료구조와 알고리즘의 활용법 학습
- 실제 프로그래밍에서 자주 사용되는 패턴과 기법 습득
- 클린 코드 작성의 중요성 인식

## 참고 자료
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Java Language Specification](https://docs.oracle.com/javase/specs/)

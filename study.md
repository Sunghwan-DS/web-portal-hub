# 1. 프로젝트 생성
## 1.1. Environment
- Project: Gradle - Groovy
- Language: Java 17
- Spring Boot: 3.2.0

# 2. 디자인 패턴
## 2.1. Transaction Script Pattern
비즈니스 로직을 간단한 스크립트로 구현하는 방식.
- 간단한 비지니스 로직 구현의 경우
- 절차 지향 스크립트로 구현, 데이터베이스 직접 접근도 가능
- 각 작업은 성공하거나 실패할 수 있지만 유효하지 않은 상태를 만들면 안된다.
- 단순한 지원 하위 도메인, 연동 어댑터, 충돌 방지 계층

특히, 데이터베이스 트랜잭션을 중심으로 하는 비즈니스 로직을 처리할 떄 유용하게 사용된다.

- 장점
    - 단순함, 이해하기 쉽다.
- 단점
    - 비즈니스 로직이 복잡할수록 트랜잭션 간 비즈니스 로직이 중복되기 쉽고, 결과적으로 중복된 코드가 동기화되지 않으면 일관성 없는 동작이 발생한다.
        - 유지보수가 불가능한 거대한 진흙 덩어리가 될 가능성이 높다

핵심 하위 도메인에는 사용하지 않는 것이 좋다.

## 2.2. Active Record Pattern
객체 지향 프로그래밍에서 데이터베이스와의 상호 작용을 추상화하는데 사용되는 소프트웨어 디자인 패턴.
- 비즈니스 로직이 단순한 경우
- Active Record 라는 전용 객체를 사용하여 복잡한 자료 구조를 표현, 자료 구조 외에도 CRUD 구현, ORM 구현
- 즉, Active Record 는 데이터 접근 로직 구현
- Entity 에 약간의 비즈니스 로직 포함 가능하지만 대부분의 비지니스 로직 및 흐름은 응용서비스의 행위에 의해 처리됨

## 2.3. Domain Model Pattern
- 행위(behavior) + 자료구조(data)를 통해 비지니스 로직 구현
- POJO로 구성: 이미 본질적으로 복잡하므로 인프라, 기술적 관심사를 피해야 함
- 응용서비스에서는 대부분 업무 흐름 제어만 하며 주요 비지니스 로직은 도메인 모델이 위임하여 처리

### 2.3.1. 도메인주도 설계의 Aggregate패턴
- 도메인 모델 패턴 적용 시 도메인 모델이 점점 복잡하고 비대해짐(Big ball of mud)
- 이에 그 복잡성을 관리할 단위를 구분해 냄 (도메인 주도의 Aggregate)
- 대부분 한 개의 Entity 와 여러 개의 VO 구성

### 2.3.2. Value Object
- 개념적으로 완전한 하나를 표현
- 고유의 식별자를 가지지 않음
- 명료성 향상, 의도를 명확히 전달, 유효성 검사, 비즈니스 로직 표현, 유비쿼터스 언어 사용, 비즈니스 도메인 개념 표현


- 상태를 변경할 수 없는(불변: immutable) 단순히 값만을 갖는 객체
- 객체를 변경할 떄는 객체 자체를 완전히 교체하는 것을 의미
- 읽기 전용 객체
- 분산되기 쉬운 비즈니스 로직을 한데 묶어줄 뿐 아니라 안전한 코드를 작성할 수 있음


- 가능한 모든 경우에 사용, 다른 객체(Entity, VO)의 속성을 표현하는 요소로 사용
- Ex) ID, 이름, 전화번호, 이메일, 받는 사람(Receiver), 주소(Address), 화폐(Money)
- 의미가 잘 드러나도록 식별자를 VO로 표현


DTO와 헷갈리지 말 것, DTO는 프레젠테이션 계층과 도메인 계층에서 사용되는 구조체 개념

### 2.3.3. Entity
- 모든 도메인의 필수 구성요소
- 도메인의 고유 개념 표현
- 다른 객체와 구별할 수 있는 식별자(고유 식별자)를 갖는 객체
- 주문에서 배송지 정보가 변경되어도 주문번호는 변경되지 않음.
- 자신의 생명주기를 가짐
- Ex) 주문, 회원, 상품
- DB Entity 와의 차이: 데이터와 함께 기능을 제공

### 2.3.4. Aggregate
- 관련 객체를 하나로 묶은 군집
- Aggregate는 Entity, 목적은 데이터 일관성을 보호, 데이터 변경 시 Aggregate 단위로 처리
- Aggregate Root를 통해 Aggregate 내의 다른 Entity 및 VO 접근
- 데이터 변경의 단위, 트랜잭션 단위가 되는 연관된 객체 묶음

- 설계 고려사항 #1
  - 하나의 Transaction에서는 하나의 Aggregate만 수정함
  - Transaction 일관성과 성공을 보장하도록 Aggregate 구성요소들을 설계해야 함
- 특징
  - 각 Aggregate은 일관성 있는 Transaction 경계를 형성함
  - 즉, Transaction 제어가 DB에 Commit 될 때, 한 Aggregate 내의 모든 구성요소들은 비즈니스 규칙을 따르면서 일관성 있게 처리되어야 함


- 설계 고려사항 #2
  - 하나의 일을 잘 수행할 수 있도록 작게 설계해야 함
  - 작게 설계할수록 성능이 좋고 확장에 용이함, 변경사항 Commit할 때 문제도 거의 발생되지 않음
- 큰 Aggregate의 문제점
  - 시간이 지날수록 하위의 객체의 인스턴스의 증가가 결국 엄청난 크기로 불어날 수 있음
  - 따라서 하나의 일을 잘 수행할 수 있는 작은 Aggregate로 분리해야 함


- 설계 고려사항 #3
  - 한 Aggregate에서 다른 Aggregate의 참조는 식별자를 통해서만 참조해야 함
  - 하나의 Transaction 내에서 여러 개의 Aggregate이 수정되는 것을 방지할 수 있음


- 설계 고려사항 #4
  - 하나의 Transaction에서 여러 개의 Aggregate이 갱신되어야 하는 경우, 다른 Aggregate의 갱신은 비동기 통신을 활용하여 결과적 일관성을 맞춰야 함
  - 결과적 일관성이란,
    - 일관성을 유지시켜야 하는 데이터가 일정시간 다른 데이터와 일치하지 않을수도 있지만 어느 시점이 되면 결국 일치하게 된다.


### 2.3.5. Domain Event
- 비즈니스 도메인에서 일어난 중요한 이벤트를 설명하는 메시지
- 과거형으로 명명
- Aggregate의 퍼블릭 인터페이스의 일부, Aggregate는 자신의 Domain Event를 발행

### 2.3.6. Repository
- 정의: 도메인 모델의 영속성을 처리
- 도메인 모델을 사용하기 위해서 Repository를 통해 도메인 객체를 조회한 후 도메인 객체의 기능을 실행
- 도메인 객체(Aggregate)에 대한 생명주기, 즉 영속성 관리(등록, 조회, 수정, 삭제 시 Aggregate의 일관성 유지)
- Spring Data JPA의 Repository 인터페이스



# 3. 프로젝트 구조 설계
## 3.1. 요구사항
### 3.1.1. 블로그 검색
#### 1. 키워드를 통해 블로그 검색
- 검색 결과에서 Sorting(정확도순, 최신순) 기능을 지원
- 검색 결과는 Pagination 형태로 제공

#### 2. 인기 검색어 목록
- 사용자들이 많이 검색한 순서대로, 최대 10개의 검색 키워드를 제공
- 검색어 별로 검색된 횟수도 함께 표기

## 3.2. 도메인 모델 식별
- 검색 객체
  - 검색어
  - 검색 타입(enum)
  - 검색 조건
    - 기간
- 검색 결과 
- 블로그(blog)
- 인기검색어(popularKeyword)
  - 검색어
  - 검색 횟수
- 키워드(keyword)

## 3.3. 도메인 이벤트 식별
- 블로그 검색 이벤트
  - searchBlog
  - Blog 검색타입으로 검색되었을 때 발생하는 이벤트

## 3.4. 도메인 서비스 식별
- 검색 서비스
  - SearchService
  - 검색과 관련된 작업을 수행하는 서비스
- 블로그 검색 서비스
  - BlogSearchService
  - 블로그 검색과 관련된 작업을 수행하는 서비스

## 3.5. 도메인 객체 구현

## 3.6. 도메인 서비스 구현

## 3.7. 인프라스트럭처 계층 구현

## 3.8. 응용 계층 구현

## 3.9. 인터페이스 계층 구현

# 4. DB 생성
## 4.1. MySQL Docker 컨테이너 설정
1. docker 설치
2. $ docker pull mysql
3. $ docker run --name web-portal-hub -e MYSQL_ROOT_PASSWORD=pass -d -p 3306:3306 mysql
4. $ docker start web-portal-hub
5. $ docker exec -it web-portal-hub bash
6. $ mysql -u root -p

## 4.2. DB 생성
$ CREATE DATABASE web_portal_hub default CHARACTER SET UTF8

## 4.3. 테이블 생성
CREATE TABLE search_keywords (
  id INT AUTO_INCREMENT PRIMARY KEY,
  keyword VARCHAR(255) NOT NULL,
  search_count BIGINT NOT NULL
);





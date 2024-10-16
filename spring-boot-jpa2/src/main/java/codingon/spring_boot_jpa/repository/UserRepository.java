package codingon.spring_boot_jpa.repository;

import codingon.spring_boot_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// 해당 인터페이스가 Repository 컴포넌트임을 명시
public interface UserRepository extends JpaRepository<User, Long> {
    // ㄴ JpaRepository<User, Long> 을 상속받아 기본적인 CRUD 작업을 위한 메서드들을 제공 받음
    // ex. findAll(), findById(), save(), deleteById(), ... 등

    // JpaRepository<User, Long> 의미
    // - 제네릭 첫번째 타입: 관련 테이블
    // - 제네렉 두번째 타입: 관련 테이블 PK 의 타입

    /*
    // case1. repository 메서드 사용
    // 1. 사용자 이름으로 n 명 조회
    // => select * from user where username = ?
    List<User> findByUsername(String username);

    // 2. 검색어 보냈을 때 사용자 이름/이메일에 특정 문자열이 포함된 모든 사용자 n명 찾기
    // => select * from user where username like %XX% or email like %XX%
    List<User> findByUsernameContainingOrEmailContaining(String username, String email);

    // 3. 이름이 존재하는지 확인
    boolean existsByUsername(String username);
    */

    // case2. @Query 어노테이션 사용
    // - JpaRepository 인터페이스에 내장된 메소드 만으로는 해결이 안되는 경우, (raw query 작성해야 함)
    // - 단, JPA 는 테이블명이 아니라 객체 위주로 돌아가니 객체(Entity) 이름을 사용해야 함
    // - nativeQuery 옵션
    //  : 찐 SQL 문을 사용하는 거라 DBMS 에 종속적이게 됨 (ORM 특징을 활용하기 어려움)
    //  ex. @Query(nativeQuery=true, value="setlect * from users")
    // case1. repository 메서드 사용

    // 1. 사용자 이름으로 n 명 조회
    @Query("SELECT u FROM User u WHERE u.username = :username")
    // - User: entity 이름
    // - @Param: 해당 어노테이션을 이용해 파라미터 바인딩
    List<User> findByUsername(@Param("username") String username);

    // 2. 검색어 보냈을 때 사용자 이름/이메일에 특정 문자열이 포함된 모든 사용자 n명 찾기
    @Query("SELECT u FROM User u WHERE u.username LIKE %:keyword% OR u.email LIKE %:keyword%")
    List<User> findByUsernameContainingOrEmailContaining(@Param("keyword") String keyword);

    // 3. 이름이 존재하는지 확인
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.username = :username")
    // 참고. CASE WHEN (조건식) THEN (결과1) ELSE (결과2) END : SQL 조건문
    boolean existsByUsername(String username);

}

package com.lima.battleofmyeongnyang.domains.member.repository;

import com.lima.battleofmyeongnyang.domains.member.dto.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  List<Member> findByEmail(String email);
  Member save(Member member);

  // LIM: 어노테이션 알아보기
  @Transactional
  void deleteMemberByUserNo(long userNo);

  Member readMemberByUserNo(long userNo);

  // 고민중
  void readMemberByEmailAndPassword();
  Member searchMemberByEmailAndPassword(String email, String password);
}

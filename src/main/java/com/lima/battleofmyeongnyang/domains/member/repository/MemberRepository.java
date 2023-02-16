package com.lima.battleofmyeongnyang.domains.member.repository;

import com.lima.battleofmyeongnyang.domains.member.dto.Member;
import com.lima.battleofmyeongnyang.domains.member.dto.ResponseMemberDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  List<Member> findByEmail(String email);
  Member save(Member member);

  // LIM: 어노테이션 알아보기
  @Transactional
  void deleteMemberByUserNo(long userNo);

  Member readMemberByUserNo(long userNo);

  Member searchMemberByEmailAndPassword(String email, String password);

  List<Member> readMembersBy();
}

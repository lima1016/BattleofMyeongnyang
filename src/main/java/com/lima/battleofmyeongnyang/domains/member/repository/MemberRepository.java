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

  @Transactional
  void deleteMemberByUserNo(long userNo);
}

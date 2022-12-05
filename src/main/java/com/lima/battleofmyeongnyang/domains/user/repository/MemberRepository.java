package com.lima.battleofmyeongnyang.domains.user.repository;

import com.lima.battleofmyeongnyang.domains.user.dto.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  List<Member> findByEmail(String email);
  Member save(Member member);
}

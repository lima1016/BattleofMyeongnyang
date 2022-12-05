package com.lima.battleofmyeongnyang.domains.user;

import com.lima.battleofmyeongnyang.domains.user.dto.Member;
import com.lima.battleofmyeongnyang.domains.user.repository.MemberRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
  @Resource
  MemberRepository memberRepository;

  public void createUser(Member member) {
    memberRepository.save(member);
  }
}

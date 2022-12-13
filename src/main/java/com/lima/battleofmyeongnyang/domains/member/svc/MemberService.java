package com.lima.battleofmyeongnyang.domains.member.svc;

import com.lima.battleofmyeongnyang.domains.member.dto.Member;
import com.lima.battleofmyeongnyang.domains.member.repository.MemberRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
  @Resource
  MemberRepository memberRepository;

  public void createMember(Member member) {
    memberRepository.save(member);
  }

  public void readMember() {

  }

  public void deleteMember(long userNo) {
    memberRepository.deleteMemberByUserNo(userNo);
  }
}

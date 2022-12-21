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

  public Member readMemberByUserNo(long userNo) {
    return memberRepository.readMemberByUserNo(userNo);
  }

  public void checkLoginMember(String email, String password) {
    memberRepository.
}

  public void deleteMember(long userNo) {
    memberRepository.deleteMemberByUserNo(userNo);
  }
}

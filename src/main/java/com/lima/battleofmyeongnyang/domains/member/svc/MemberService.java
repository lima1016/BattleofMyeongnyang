package com.lima.battleofmyeongnyang.domains.member.svc;

import com.lima.battleofmyeongnyang.domains.geoip.MemberLoginHistoryDto;
import com.lima.battleofmyeongnyang.domains.member.dto.Member;
import com.lima.battleofmyeongnyang.domains.member.dto.ResponseMemberDto;
import com.lima.battleofmyeongnyang.domains.member.repository.MemberRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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

  public Member checkLoginMember(String email, String password) {
    return memberRepository.searchMemberByEmailAndPassword(email, password);
}

  public void deleteMember(long userNo) {
    memberRepository.deleteMemberByUserNo(userNo);
  }

  public List<MemberLoginHistoryDto> getLoginHistory(long userNo) {
    // LIM: GEO IP로 어디서 접속했는지 확인 하고 로그인 기록 남기기 (유저가 볼수있음)
    return memberRepository.getMemberLoginHistory();
  }

  public List<Member> readMembers() {
    return memberRepository.readMembersBy();
  }
}

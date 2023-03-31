package com.lima.battleofmyeongnyang.domains.member.svc;

import com.lima.battleofmyeongnyang.domains.geoip.GeoEnum;
import com.lima.battleofmyeongnyang.domains.geoip.GeoIPUtility;
import com.lima.battleofmyeongnyang.domains.history.dto.LoginHistoryDto;
import com.lima.battleofmyeongnyang.domains.history.repository.LoginHistoryRepository;
import com.lima.battleofmyeongnyang.domains.history.service.LoginHistoryService;
import com.lima.battleofmyeongnyang.domains.member.LoginMember;
import com.lima.battleofmyeongnyang.domains.member.dto.Member;
import com.lima.battleofmyeongnyang.domains.member.repository.MemberRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;

@Service
public class MemberService {
  @Resource
  MemberRepository memberRepository;
  @Resource
  LoginHistoryService historyService;

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

  public List<Member> readMembers() {
    return memberRepository.readMembersBy();
  }

  public Object getMemberInfo(long userNo) {
    historyService.getLoginHistory(userNo);
    return null;
  }

  public void createMemberHistory(Member member) {
    historyService.createLoginHistory(member.getUserNo());
  }

  public void createToken(long userNo) {
    
  }
}

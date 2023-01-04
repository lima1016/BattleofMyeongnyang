package com.lima.battleofmyeongnyang.domains.member.ctl;

import com.lima.battleofmyeongnyang.domains.member.dto.Member;
import com.lima.battleofmyeongnyang.domains.member.svc.MemberService;
import com.lima.battleofmyeongnyang.response.ResponseConfig;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/v1/member")
@Validated
public class MemberController {
  @Resource
  MemberService memberService;

  @Resource
  RedisTemplate redisTemplate;

  /**
   * Member 회원 가입
   * @param member
   * @return
   */
  @PostMapping("/create/new")
  public ResponseConfig createMember(@RequestBody Member member) {
    memberService.createMember(member);
    return new ResponseConfig();
  }

  /**
   * 사용자 정보 조회
   * @param userNo
   */
  @GetMapping("/read/my-info")
  public ResponseConfig findByMemberId(long userNo) {
    // user가 로그인 했을때만 정보를 1번 불러오고 redis 에서 user 정보 갖고있다가 변경사항이 있을때 다시 redis로 정보 로드
    return new ResponseConfig().getResponse(memberService.readMemberByUserNo(userNo));
  }

  /**
   * 사용자 탈퇴
   * @param memberNo
   * @return
   */
  @GetMapping("/delete")
  public ResponseConfig deleteMember(long memberNo) {
    memberService.deleteMember(memberNo);
    return ResponseConfig.isHelloEmpty();
  }

  @PostMapping("/login/member")
  public ResponseConfig loginMember(@RequestBody String email, String password) {
    Member member = memberService.checkLoginMember(email, password);
    // LIM: 로그인시 어떤 젇보를 redis에서 갖고있을지 정책 정하기
    redisTemplate.opsForValue().set(member.getUserNo(), member);
    return null;
  }
}

package com.lima.battleofmyeongnyang.domains.member.ctl;

import com.lima.battleofmyeongnyang.domains.member.dto.Member;
import com.lima.battleofmyeongnyang.domains.member.dto.RequestLoginMemberDto;
import com.lima.battleofmyeongnyang.domains.member.svc.MemberService;
import com.lima.battleofmyeongnyang.domains.geoip.GeoEnum;
import com.lima.battleofmyeongnyang.domains.geoip.GeoIPUtility;
import com.lima.battleofmyeongnyang.response.BattleJsonResponse;
import com.lima.battleofmyeongnyang.response.ResponseConfig;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

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

  @GetMapping("/read/members")
  public List<Member> readMembers() {
    return memberService.readMembers();
  }

  /**
   * 사용자 정보 조회
   * @param userNo
   */
  @GetMapping("/read/my-info")
  public BattleJsonResponse findByMemberId(long userNo) {
    // user가 로그인 했을때만 정보를 1번 불러오고 redis 에서 user 정보 갖고있다가 변경사항이 있을때 다시 redis로 정보 로드
    // login history
    // 로그인한 유저 정보

    return ResponseConfig.getResponse(memberService.getLoginHistory(userNo));
  }

  /**
   * 사용자 탈퇴
   * @param memberNo
   * @return
   */
  @GetMapping("/delete")
  public ResponseConfig deleteMember(long memberNo) {
    // LIM: 사용자 탈퇴시 정보를 갖고있을지 정책 정하기
    memberService.deleteMember(memberNo);
    return ResponseConfig.isHelloEmpty();
  }

  @PostMapping("/login/member")
  public ResponseConfig loginMember(@RequestBody RequestLoginMemberDto request) {
    log.info("MemberController.loginMember.request :" + request);
    // 로그인한 유저 IP 정보 가져오기
    HttpServletRequest http = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
    // 로그인한 유저 국가 정보 가져와서 login history 남기기
    EnumMap<GeoEnum, Object> geoIP = GeoIPUtility.getGeoIP(http.getRemoteAddr());

    // 로그인 실패는 어떻게 체크를 할 것 인가?
    Member member = memberService.checkLoginMember(request.getEmail(), request.getPassword());
    if ( Objects.nonNull(member)) {
      // redis에 로그인한 user 정보 저장
      redisTemplate.opsForValue().set(member.getUserNo(), member);
    } else {
      // 실패했을 경우 exception 던지기
    }
    return ResponseConfig.isHelloEmpty();
  }
}

package com.lima.battleofmyeongnyang.domains.member.ctl;

import com.lima.battleofmyeongnyang.config.RedisConfig;
import com.lima.battleofmyeongnyang.domains.member.svc.MemberService;
import com.lima.battleofmyeongnyang.domains.member.dto.Member;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/v1/member")
@Validated
public class MemberController {
  @Resource
  MemberService memberService;

  @PostMapping("/create")
  public void createMember(@RequestBody Member member) {
    memberService.createMember(member);
  }

  @GetMapping("/read")
  public void findByMemberId(int memberId) {
    // user가 로그인 했을때만 정보를 1번 불러오고 redis 에서 user 정보 갖고있다가 변경사항이 있을때 다시 redis로 정보 로드

  }
}

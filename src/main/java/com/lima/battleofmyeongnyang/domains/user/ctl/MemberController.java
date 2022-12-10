package com.lima.battleofmyeongnyang.domains.user.ctl;

import com.lima.battleofmyeongnyang.config.BeansUtils;
import com.lima.battleofmyeongnyang.domains.user.MemberService;
import com.lima.battleofmyeongnyang.domains.user.dto.Member;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1/member")
public class MemberController {
  @Resource
  MemberService memberService;

  @PostMapping("/create")
  public void createMember() {
    Member member =
        Member.builder()
                .userNo((long) 1)
                .email("hello@gmail.com")
                .name("hello")
                .password("1111").build();
    memberService.createUser(member);
  }

  @GetMapping("/read")
  public void readUser() {

  }
}

package com.lima.battleofmyeongnyang.domains.user.ctl;

import com.lima.battleofmyeongnyang.domains.user.UserService;
import com.lima.battleofmyeongnyang.domains.user.dto.UserDto;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1/user")
public class UserController {
  @Resource
  UserService userService;

  @PostMapping("/create")
  public void createUser(UserDto userDto) {
    log.info("UserController.createUser.userDto : " + userDto);
    userService.createUser(userDto);
  }

  @GetMapping("/read")
  public void readUser() {
  }
}

package com.lima.battleofmyeongnyang.domains.user;

import com.lima.battleofmyeongnyang.domains.user.dto.UserDto;
import com.lima.battleofmyeongnyang.domains.user.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Resource
  UserRepository userRepository;

  public void createUser(UserDto userDto) {
    userRepository.save(userDto);
  }
}

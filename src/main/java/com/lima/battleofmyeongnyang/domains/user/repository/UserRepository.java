package com.lima.battleofmyeongnyang.domains.user.repository;

import com.lima.battleofmyeongnyang.domains.user.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {
  List<UserDto> findByEmail(String email);
  UserDto save(UserDto userDto);
}

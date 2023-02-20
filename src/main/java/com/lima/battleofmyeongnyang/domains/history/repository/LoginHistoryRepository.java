package com.lima.battleofmyeongnyang.domains.history.repository;

import com.lima.battleofmyeongnyang.domains.history.dto.LoginHistoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistoryDto, Long> {
  List<LoginHistoryDto> findLoginHistoryDtoByMemberNo(long userNo);

}

package com.lima.battleofmyeongnyang.domains.history.service;

import com.lima.battleofmyeongnyang.domains.geoip.GeoEnum;
import com.lima.battleofmyeongnyang.domains.geoip.GeoIPUtility;
import com.lima.battleofmyeongnyang.domains.history.dto.LoginHistoryDto;
import com.lima.battleofmyeongnyang.domains.history.repository.LoginHistoryRepository;
import com.lima.battleofmyeongnyang.domains.member.LoginMember;
import io.hypersistence.utils.hibernate.type.basic.Inet;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.EnumMap;
import java.util.List;

@Service
public class LoginHistoryService {

  @Resource
  LoginHistoryRepository historyRepository;

  public List<LoginHistoryDto> getLoginHistory(long userNo) {
    // LIM: GEO IP로 어디서 접속했는지 확인 하고 로그인 기록 남기기 (유저가 볼수있음)
    return historyRepository.findLoginHistoryDtoByMemberNo(userNo);
  }

  public void createLoginHistory(long userNo) {
    Inet loginIp = LoginMember.getInstance().getLoginIp();
    EnumMap<GeoEnum, Object> geoIP = GeoIPUtility.getGeoIP(loginIp);
    System.out.println(geoIP);
    historyRepository.saveAndFlush(LoginHistoryDto.builder()
        .memberNo(userNo)
        .memberIp(loginIp)
        .country(geoIP.get(GeoEnum.COUNTRY_NAME).toString())
        .city(geoIP.get(GeoEnum.CITY_NAME).toString())
        .build());
  }
}

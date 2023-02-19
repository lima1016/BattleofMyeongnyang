package com.lima.battleofmyeongnyang.geoip;

import com.lima.battleofmyeongnyang.domains.geoip.GeoEnum;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.EnumMap;

@SpringBootTest
public class GeoIPUtilityTest {

  @Test
  void getGeoIPTest() throws IOException, GeoIp2Exception {
    String ip = "1.1.1.1";
    HttpServletRequest http = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    EnumMap<GeoEnum, Object> resultMap = new EnumMap<>(GeoEnum.class);
    File file = new File("D:\\git\\BattleofMyeongnyang\\src\\geoip\\GeoLite2-City.mmdb");
    DatabaseReader reader = new DatabaseReader.Builder(file).build();

    CityResponse response = reader.city(InetAddress.getByName(http.getLocalAddr()));
    resultMap.put(GeoEnum.COUNTRY_NAME, response.getCountry().getName());
    resultMap.put(GeoEnum.STATE, response.getLeastSpecificSubdivision().getName());
    resultMap.put(GeoEnum.CITY_NAME, response.getCity().getNames().get("en"));
    resultMap.put(GeoEnum.POSTAL, response.getPostal().getCode());

    System.out.println(resultMap);

    Assertions.assertThat(resultMap);
  }

}
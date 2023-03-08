package com.lima.battleofmyeongnyang.domains.geoip;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.AddressNotFoundException;
import com.maxmind.geoip2.model.CityResponse;
import io.hypersistence.utils.hibernate.type.basic.Inet;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.EnumMap;

@Slf4j
public class GeoIPUtility {

  public static EnumMap<GeoEnum, Object> getGeoIP(Inet ip) {
    EnumMap<GeoEnum, Object> resultMap = new EnumMap<>(GeoEnum.class);
    try {
      File file = new File("D:\\git\\BattleofMyeongnyang\\src\\geoip\\GeoLite2-City.mmdb");
      DatabaseReader reader = new DatabaseReader.Builder(file).build();

      CityResponse response = reader.city(ip.toInetAddress());
      resultMap.put(GeoEnum.COUNTRY_NAME, response.getCountry().getName());
      resultMap.put(GeoEnum.STATE, response.getLeastSpecificSubdivision().getName());
      resultMap.put(GeoEnum.CITY_NAME, response.getCity().getNames().get("en"));
      resultMap.put(GeoEnum.POSTAL, response.getPostal().getCode());
      log.info("GeoIp info : " + resultMap);
      return resultMap;
    } catch (AddressNotFoundException e) {
      log.error("The address {} is not in the database.", ip);
    } catch (Exception e) {
      log.error("", e);
    }
    return null;
  }
}

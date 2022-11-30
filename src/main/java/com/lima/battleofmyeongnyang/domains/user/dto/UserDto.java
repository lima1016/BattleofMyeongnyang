package com.lima.battleofmyeongnyang.domains.user.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash(value = "user", timeToLive = 30)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "user")
public class UserDto {

  /**
   * @Id: 기본키(PK)로 지정한다
   * @GeneratedValue
   * - table 생성시 해당 필드를 PK, AUTO_INCREMENT 로 설정하였기 때문에 직접할당 방식이 아닌, 자동으로 생성되도록 하기위해서 @Gen~을 사용
   * @GenerationType.IDENTITY: 기본 키 생성을 데이터베이스에 위임하는 방식
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userNo;

  private String email;
  private String name;
  private String pw;
}

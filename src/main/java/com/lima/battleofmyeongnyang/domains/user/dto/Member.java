package com.lima.battleofmyeongnyang.domains.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "member")
public class Member {

  /**
   * @Id: 기본키(PK)로 지정한다
   * @GeneratedValue
   * - table 생성시 해당 필드를 PK, AUTO_INCREMENT 로 설정하였기 때문에 직접할당 방식이 아닌, 자동으로 생성되도록 하기위해서 @Gen~을 사용
   * @GenerationType.IDENTITY: 기본 키 생성을 데이터베이스에 위임하는 방식
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("user_no")
  private Long userNo;
  private String email;
  private String name;
  private String password;
}

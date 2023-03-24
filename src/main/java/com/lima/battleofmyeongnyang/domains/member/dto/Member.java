package com.lima.battleofmyeongnyang.domains.member.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_battle_member")
public class Member implements Serializable {


  /**
   * @Id: 기본키(PK)로 지정한다
   * @GeneratedValue
   * - table 생성시 해당 필드를 PK, AUTO_INCREMENT 로 설정하였기 때문에 직접할당 방식이 아닌, 자동으로 생성되도록 하기위해서 @Gen~을 사용
   * @GenerationType.IDENTITY: 기본 키 생성을 데이터베이스에 위임하는 방식
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("user_no")
  private long userNo;
  private String email;
  private String name;
  // password 암호화 해야함
  private String password;
//  private String isDelete;
}

package com.lima.battleofmyeongnyang.domains.history.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.hypersistence.utils.hibernate.type.basic.Inet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_battle_login_history")
public class LoginHistoryDto {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long historyNo;

  @JsonProperty("member_no")
  @JoinColumn(name = "member_member_no")
  private long memberNo;
  @JsonProperty("member_ip")
  @Column(columnDefinition = "inet")
  private Inet memberIp;
  @JsonProperty("country")
  private String country;

  @JsonProperty("city")
  private String city;
}

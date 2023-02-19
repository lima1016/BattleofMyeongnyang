package com.lima.battleofmyeongnyang.domains.geoip;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class MemberLoginHistoryDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("member_no")
  private Long memberNo;
  @JsonProperty("member_ip")
  private String memberIP;
  @JsonProperty("country")
  private String country;
}

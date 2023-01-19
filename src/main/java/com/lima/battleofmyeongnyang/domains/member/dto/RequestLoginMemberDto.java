package com.lima.battleofmyeongnyang.domains.member.dto;

import lombok.Data;


@Data
public class RequestLoginMemberDto {

    private String email;
    private String password;
}

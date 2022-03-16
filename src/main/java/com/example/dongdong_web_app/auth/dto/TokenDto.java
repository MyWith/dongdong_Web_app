package com.example.dongdong_web_app.auth.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
    private String accessToken;
    private String refreshToken;
}

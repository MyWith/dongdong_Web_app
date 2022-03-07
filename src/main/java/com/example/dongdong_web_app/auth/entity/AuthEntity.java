package com.example.dongdong_web_app.auth.entity;

import lombok.*;
import javax.persistence.*;;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userEmail;
    private String userPassword;

}

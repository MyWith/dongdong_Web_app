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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userUid;

    private String userEmail;
    private String userPassword;
    private String userNickName;
    private int userAge;
    private String animalName;
    private String animalKind;

}

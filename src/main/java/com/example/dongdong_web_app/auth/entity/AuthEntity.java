package com.example.dongdong_web_app.auth.entity;

import lombok.*;
import javax.persistence.*;;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "user")
@Table(name = "USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userEmail", "userNickName"})
})
public class AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userUid;

    private String userEmail;
    private String userPassword;
    private String userNickName;
    private int userAge;
    private String animalName;
    private String animalKind;

    private double userLat;
    private double userLon;

}

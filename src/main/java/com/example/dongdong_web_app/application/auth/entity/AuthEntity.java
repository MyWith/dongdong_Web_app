package com.example.dongdong_web_app.application.auth.entity;

import lombok.*;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.util.Date;


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
    private Date userAge;
    private String animalName;
    private String animalKind;
    private Date animalAge;

    private Date createdAt;
    private Date updatedAt;

}

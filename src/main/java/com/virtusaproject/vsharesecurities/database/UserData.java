package com.virtusaproject.vsharesecurities.database;

import com.virtusaproject.vsharesecurities.annotations.ValidEmail;
import com.virtusaproject.vsharesecurities.annotations.ValidPassword;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Data
@Entity
@NoArgsConstructor
public class UserData {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long uid;

    @Column(unique = true)
    private String email;

    private String password;

    private String firstName;
    private String lastName;
}

package com.virtusaproject.vsharesecurities.dto;

import com.virtusaproject.vsharesecurities.annotations.PasswordEquals;
import com.virtusaproject.vsharesecurities.annotations.ValidEmail;
import com.virtusaproject.vsharesecurities.annotations.ValidPassword;
import com.virtusaproject.vsharesecurities.database.UserData;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;



@Data
@NoArgsConstructor
@PasswordEquals
public class UserDto {

    @ValidEmail
    private String email;

    @ValidPassword
    private String password;
    private String confirmPassword;

    @NotBlank(message = "First name cannot be empty")
    private String firstName;
    private String lastName;

    public UserData toUser(PasswordEncoder passwordEncoder){
        UserData userData = new UserData();

        userData.setEmail(getEmail());
        userData.setFirstName(getFirstName());
        userData.setLastName(getLastName());
        userData.setPassword(passwordEncoder.encode(getPassword()));

        return userData;
    }
}

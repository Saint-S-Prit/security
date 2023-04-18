package com.espritech.security.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;



    public static UserDto fromEntity(User user)
    {
        if (user == null)
        {
            log.error("customer is null");
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                //.password(user.getPassword())
                .role(user.getRole())
                .build();
    }



    public static User toEntity(UserDto userDto)
    {
        if (userDto == null)
        {
            log.error("userDto is null");
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return user;
    }

    
}

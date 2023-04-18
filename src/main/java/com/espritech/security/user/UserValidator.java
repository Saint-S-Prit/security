package com.espritech.security.user;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public  static List<String> validate(UserDto userDto)
    {
        List<String> errors = new ArrayList<>();


        if (userDto == null) {

            errors.add("Veuillez renseignez votre prenom");
            errors.add("Veuillez renseignez votre nom");
            errors.add("Veuillez renseignez votre adresse email");
            errors.add("Veuillez renseignez une adresse email valide");
            errors.add("Veuillez renseignez votre mot de passe");
        }


        if (userDto == null || !StringUtils.hasLength(userDto.getFirstName()))
        {
            errors.add("Veuillez renseignez votre prenom");
        }

        if (userDto == null || !StringUtils.hasLength(userDto.getLastName()))
        {
            errors.add("Veuillez renseignez votre nom");
        }

        if (userDto == null || !StringUtils.hasLength(userDto.getEmail()))
        {
            errors.add("Veuillez renseignez votre adresse email");
        } else if (userDto == null || !userDto.getEmail().matches("^[a-z0-9.-]+@[a-z0-9" +
                ".-]{2,}\\.[a-z]{2,4}$")){
            errors.add("Veuillez renseignez une adresse email valide");
        }

        if (userDto == null || !StringUtils.hasLength(userDto.getPassword()))
        {
            errors.add("Veuillez renseignez votre mot de passe");
        }

        return errors;
    }
}

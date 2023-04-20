package com.espritech.security.user;


import com.espritech.security.config.exception.EntityNotFoundException;
import com.espritech.security.config.exception.ErrorCodes;
import com.espritech.security.config.exception.InvalidEntityException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    PasswordEncoder passwordEncoder;

    UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        System.out.println("test 3");
        System.out.println("test 7");
        System.out.println("test 7");
        System.out.println("test 7");
        System.out.println("test 7");

        List<String> errors = UserValidator.validate(userDto);
        if (!errors.isEmpty()) {
            log.error("User is not valid {}", userDto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide"
                    , ErrorCodes.USER_NOT_VALID, errors);
        }


        userDto.setRole(Role.USER);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return UserDto.fromEntity(userRepository.save(Objects.requireNonNull(UserDto.toEntity(userDto))));
    }

    @Override
    public UserDto findById(Long id) {
        return null;
/*
        SousCategory sousCategory = sousCategoryRepository.findByNameAndArchiveFalse(sousCategoryName).orElseThrow(
                ()-> new EntityNotFoundException(
                        "Aucun category avec l'ID = " + sousCategoryName + " ne se trouve dans la BDD",
                        ErrorCodes.SOUS_CATEGORY_NOT_FOUND)*/
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

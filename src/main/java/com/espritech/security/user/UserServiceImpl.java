package com.espritech.security.user;


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
        userDto.setRole(Role.USER);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return UserDto.fromEntity(userRepository.save(Objects.requireNonNull(UserDto.toEntity(userDto))));
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

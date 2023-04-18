package com.espritech.security.user;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);
    UserDto findById(Long id);
    List<UserDto> findAll();
    void delete(Long id);
    //UserDto findByEmail(String email);
}

package com.practice.Accounts.service;

import com.practice.Accounts.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id,UserDto userDto);

    List<UserDto> findAllUser();
}

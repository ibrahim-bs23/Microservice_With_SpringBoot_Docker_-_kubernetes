package com.practice.Accounts.service.impl;

import com.practice.Accounts.dto.UserDto;
import com.practice.Accounts.exceptions.ResourceNotFoundException;
import com.practice.Accounts.model.User;
import com.practice.Accounts.repository.UserRepo;
import com.practice.Accounts.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {
        if (Objects.isNull(userDto) || !isValidUserDto(userDto)) {
            throw new ResourceNotFoundException("Please enter valid data");
        }
       User user=convertUserDto(userDto);
        userRepo.save(user);
       return userDto;
    }

    private User convertUserDto(UserDto userDto) {
        User user=new User();
        user.setUserName(userDto.getUserName());
        user.setNid(userDto.getNid());
        user.setFullName(user.getFullName());
        return user;
    }
    private boolean isValidUserDto(UserDto userDto) {
        return userDto.getUserName() != null && !userDto.getUserName().isEmpty()
                && userDto.getNid() != null && !userDto.getNid().isEmpty();
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
       User user=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
       Updateuser(user,userDto);
       userRepo.save(user);
       return userDto;
    }

    private void Updateuser(User user, UserDto userDto) {
        user.setUserName(userDto.getUserName());
        user.setNid(userDto.getNid());
        user.setFullName(userDto.getFullName());
    }

    @Override
    public List<UserDto> findAllUser() {
        return null;
    }
}

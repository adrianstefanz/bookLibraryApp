package com.example.bookLibraryApp.mappers;

import com.example.bookLibraryApp.dtos.UserDto;
import com.example.bookLibraryApp.entities.User;

public class UserMapper {

    public static UserDto entityToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    public static User dtoToEntity(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .build();
    }

}

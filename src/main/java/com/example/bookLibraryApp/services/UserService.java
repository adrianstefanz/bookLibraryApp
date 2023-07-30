package com.example.bookLibraryApp.services;

import com.example.bookLibraryApp.dtos.UserDto;
import com.example.bookLibraryApp.exceptions.UserException;
import com.example.bookLibraryApp.mappers.UserMapper;
import com.example.bookLibraryApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto getUserById(Long userId) {
        return UserMapper.entityToDto(userRepository.findById(userId).get());
    }

    public void addNewUser(UserDto userDto) {
        if (userRepository.findUserByUsername(userDto.getUsername()) == null) {
            this.userRepository.save(UserMapper.dtoToEntity(userDto));
        } else {
            throw new UserException("An user with this username already exists");
        }
    }

}

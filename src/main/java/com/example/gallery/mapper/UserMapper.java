package com.example.gallery.mapper;

import com.example.gallery.domain.User;
import com.example.gallery.dto.UserDTO;

import java.util.List;

public interface UserMapper {

  UserDTO userToUserDTO(User user);

  List<UserDTO> usersToUsersDTO(List<User> users);

  User convertToEntity(UserDTO userDTO);
}

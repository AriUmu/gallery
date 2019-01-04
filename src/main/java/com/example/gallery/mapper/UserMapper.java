package com.example.gallery.mapper;

import com.example.gallery.domain.User;
import com.example.gallery.dto.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProfileMapper.class)
public interface UserMapper {

  UserDTO userToUserDTO(User user);

  List<UserDTO> usersToUsersDTO(List<User> users);
}

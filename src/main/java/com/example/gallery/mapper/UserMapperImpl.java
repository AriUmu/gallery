package com.example.gallery.mapper;

import com.example.gallery.domain.User;
import com.example.gallery.dto.UserDTO;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapperImpl implements UserMapper {

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public UserDTO userToUserDTO(User user) {
    return modelMapper.map(user, UserDTO.class);
  }

  @Override
  public List<UserDTO> usersToUsersDTO(List<User> users) {
    Type type = new TypeToken<List<UserDTO>>() {}.getType();
    ArrayList<UserDTO> listOfUsers = modelMapper.map(users, type);
    return listOfUsers;
  }

  @Override
  public User convertToEntity(UserDTO userDTO) {
    User user = modelMapper.map(userDTO, User.class);
    return user;
  }
}

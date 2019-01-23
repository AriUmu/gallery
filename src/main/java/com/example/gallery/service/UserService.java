package com.example.gallery.service;

import com.example.gallery.domain.User;
import com.example.gallery.dto.UserDTO;
import com.example.gallery.exceptions.UserNotFoundException;
import com.example.gallery.mapper.ProfileMapper;
import com.example.gallery.mapper.UserMapper;
import com.example.gallery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

  @Autowired
  private UserRepository userRepository;

  private UserMapper userMapper;
  private ProfileMapper profileMapper;

  public List<UserDTO> getUsers() {
    List<User> users =  userRepository.findAll();
    return userMapper.usersToUsersDTO(users);
  }

  public UserDTO findById(Long id) {
    Optional<User> user = userRepository.findById(id);
    if(user == null) {
      throw new UserNotFoundException("User '"+id+"' not found");
    }
    return userMapper.userToUserDTO(user.get());
  }

  public UserDTO updateUser(UserDTO userDTO) {
    User currentUser = userRepository.findByLogin(userDTO.getLogin());
    if(currentUser == null) {
      throw new UserNotFoundException("User '"+userDTO.getLogin()+"' not found");
    }
    currentUser.setProfile(profileMapper.ProfileDTOToProfile(userDTO.getProfile()));

    currentUser = userRepository.saveAndFlush(currentUser);

    return userMapper.userToUserDTO(currentUser);
  }

  public void saveUser(UserDTO userDTO){
    userDTO.setPassword(coderPassword(userDTO.getPassword()));
  }

  private String coderPassword(String password){

    return "";
  }

  public boolean chechParams(UserDTO userDTO){
    //todo check param before saving in db
    return true;
  }
}

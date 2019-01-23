package com.example.gallery.service;

import com.example.gallery.domain.User;
import com.example.gallery.dto.UserDTO;
import com.example.gallery.dto.validation.UserValidation;
import com.example.gallery.exceptions.UserNotFoundException;
import com.example.gallery.mapper.ProfileMapper;
import com.example.gallery.mapper.UserMapper;
import com.example.gallery.repository.UserRepository;
import com.example.gallery.rest.UsersController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.DataBinder;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class UserService {
  private final static Logger logger = LoggerFactory.getLogger( UserService.class );

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserValidation userValidation;

  private UserMapper userMapper;
  private ProfileMapper profileMapper;

  public List<UserDTO> getUsers() {
    List<User> users = userRepository.findAll();
    return userMapper.usersToUsersDTO(users);
  }

  public UserDTO findById(Long id) {
    Optional<User> user = userRepository.findById(id);
    if (user == null) {
      throw new UserNotFoundException("User '" + id + "' not found");
    }
    return userMapper.userToUserDTO(user.get());
  }

  public UserDTO updateUser(UserDTO userDTO) {
    User currentUser = userRepository.findByLogin(userDTO.getLogin());
    if (currentUser == null) {
      throw new UserNotFoundException("User '" + userDTO.getLogin() + "' not found");
    }
    currentUser.setProfile(profileMapper.ProfileDTOToProfile(userDTO.getProfile()));

    currentUser = userRepository.saveAndFlush(currentUser);

    return userMapper.userToUserDTO(currentUser);
  }

  public void saveUser(UserDTO userDTO) {
    userDTO.setPassword(coderPassword(userDTO.getPassword()));
  }

  private String coderPassword(String password) {
   //TODO
    return "";
  }

  public boolean validationParams(UserDTO userDTO) {
    final DataBinder dataBinder = new DataBinder(userDTO);
    dataBinder.addValidators(userValidation);
    dataBinder.validate();

    if (dataBinder.getBindingResult().hasErrors()) {
      dataBinder.getBindingResult().getAllErrors().stream().
              forEach(e -> logger.error(e + "   " + new Locale("ru")));
      return false;
    }
    return true;
  }
}

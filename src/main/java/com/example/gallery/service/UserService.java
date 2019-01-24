package com.example.gallery.service;

import com.example.gallery.domain.User;
import com.example.gallery.dto.UserDTO;
import com.example.gallery.dto.validation.UserValidation;
import com.example.gallery.exceptions.UserNotFoundException;
import com.example.gallery.mapper.ProfileMapper;
import com.example.gallery.mapper.UserMapper;
import com.example.gallery.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.DataBinder;

import javax.validation.constraints.AssertTrue;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class UserService {
  private final static Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserValidation userValidation;
  @Autowired
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
    userDTO.setPassword(encryptionPassword(userDTO.getPassword()));
    User user = convertToEntity(userDTO);
    //TODO Права и профили создаются заранее
    //userRepository.save(user);
    logger.info("User " + user.getId() + " was saved!");
  }

  public String encryptionPassword(String password) {
    String generatedPassword = null;
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(password.getBytes());
      byte[] bytes = md.digest();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < bytes.length; i++) {
        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
      }
      generatedPassword = sb.toString();
    }
    catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return generatedPassword;
  }

  public boolean validationParams(UserDTO userDTO) {
    final DataBinder dataBinder = new DataBinder(userDTO);
    dataBinder.addValidators(userValidation);
    dataBinder.validate();

    if (dataBinder.getBindingResult().hasErrors()) {
      dataBinder.getBindingResult().getAllErrors().stream().
              forEach(e -> logger.error(e + "  " + new Locale("ru")));
      return false;
    }
    return true;
  }

  private User convertToEntity(UserDTO userDTO) {
    User user = userMapper.convertToEntity(userDTO);
    return user;
  }
}

package com.example.gallery.rest;

import com.example.gallery.domain.Profile;
import com.example.gallery.dto.ProfileDTO;
import com.example.gallery.dto.UserDTO;
import com.example.gallery.repository.ProfileRepository;
import com.example.gallery.service.ProfileService;
import com.example.gallery.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UsersController {
  private final static Logger logger = LoggerFactory.getLogger(UsersController.class);

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  @ApiOperation(value = "return all users", notes = "return all users")
  public List<UserDTO> getAllUsers() {
    return userService.getUsers();
  }

  @GetMapping(value = "/hello")
  @ApiOperation(value = "test page", notes = "test pege return hello.jpg")
  public String getPage() {
    return "Hello World";
  }

  @GetMapping("/users/{id}")
  public UserDTO findById(@PathVariable Long id) {
    return userService.findById(id);
  }

  @PutMapping(value = "/users/{id}")
  public UserDTO update(@RequestBody @Valid UserDTO userDTO) {
    return userService.updateUser(userDTO);
  }

  @PostMapping(value = "/user")
  public void saveUser(@RequestBody UserDTO userDTO) {
    boolean noError = userService.validationParams(userDTO);
    if (noError) {
      userService.saveUser(userDTO);
    }
  }
}

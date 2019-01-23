package com.example.gallery.rest;

import com.example.gallery.domain.Profile;
import com.example.gallery.dto.UserDTO;
import com.example.gallery.repository.ProfileRepository;
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
  private final static Logger logger = LoggerFactory.getLogger( UsersController.class );
  //TODO расставить везде get/post/

  @Autowired
  private UserService userService;
  @Autowired
  private ProfileRepository profileRepository;

  public UsersController(UserService userService, ProfileRepository profileRepository) {
    this.userService = userService;
    this.profileRepository = profileRepository;
  }

  @GetMapping("/users")
  public List<UserDTO> query(){
    return userService.getUsers();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/hello")
  @ApiOperation(value = "registration attempt", notes = "Temporary register service")
  public String getPage(){
    return "Hello World";
  }

  @GetMapping("/users/{id}")
  public UserDTO findById(@PathVariable Long id){
    return userService.findById(id);
  }

  @PutMapping(value = "/users/{id}")
  public UserDTO update(@RequestBody @Valid UserDTO userDTO){
    return userService.updateUser(userDTO);
  }

  @GetMapping("/users/profiles")
  public List<Profile> getProfiles(){
    return profileRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/hello")
  public void saveUser(UserDTO userDTO){
    userService.validationParams(userDTO);
    userService.saveUser(userDTO);
  }

}

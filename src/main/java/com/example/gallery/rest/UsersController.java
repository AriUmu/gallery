package com.example.gallery.rest;

import com.example.gallery.domain.Profile;
import com.example.gallery.dto.UserDTO;
import com.example.gallery.repository.ProfileRepository;
import com.example.gallery.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UsersController {

  private UserService userService;
  private ProfileRepository profileRepository;

  public UsersController(UserService userService, ProfileRepository profileRepository) {
    this.userService = userService;
    this.profileRepository = profileRepository;
  }

  @GetMapping("/users")
  public List<UserDTO> query(){
    return userService.getUsers();
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

}

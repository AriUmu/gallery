package com.example.gallery.rest;

import com.example.gallery.dto.ProfileDTO;
import com.example.gallery.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProfileController {
  private final static Logger logger = LoggerFactory.getLogger(ProfileController.class);

  @Autowired
  private ProfileService profileService;

  @GetMapping("/profiles")
  public List<ProfileDTO> getProfiles() {
    return profileService.getAllProfiles();
  }

  @PostMapping("/profile")
  public void addProfiles(@RequestBody @Valid ProfileDTO profileDTO){

    profileService.save(profileDTO);
  }
}

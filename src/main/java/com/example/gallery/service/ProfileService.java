package com.example.gallery.service;

import com.example.gallery.domain.Profile;
import com.example.gallery.dto.ProfileDTO;
import com.example.gallery.mapper.ProfileMapper;
import com.example.gallery.mapper.ProfileMapperImpl;
import com.example.gallery.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProfileService {

  @Autowired
  private ProfileRepository profileRepository;

  @Autowired
  private ProfileMapperImpl profileMapper;

  public List<ProfileDTO> getAllProfiles(){
    List<Profile> all = profileRepository.findAll();
    List<ProfileDTO> profileDTO = profileMapper.listProfileToProfileDTO(all);
    return profileDTO;
  }
}

package com.example.gallery.mapper;

import com.example.gallery.domain.Profile;
import com.example.gallery.dto.ProfileDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileMapperImpl implements ProfileMapper {

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public ProfileDTO profileToProfileDTO(Profile profile) {
    return modelMapper.map(profile, ProfileDTO.class);
  }

  @Override
  public Profile ProfileDTOToProfile(ProfileDTO profileDTO) {
    return modelMapper.map(profileDTO, Profile.class);
  }
}

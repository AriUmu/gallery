package com.example.gallery.mapper;

import com.example.gallery.domain.Profile;
import com.example.gallery.dto.ProfileDTO;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

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

  @Override
  public List<ProfileDTO> listProfileToProfileDTO(List<Profile> list) {
    Type type = new TypeToken<List<ProfileDTO>>() {}.getType();
    List<ProfileDTO> listOfProfileDTO = modelMapper.map(list, type);
    return listOfProfileDTO;
  }
}

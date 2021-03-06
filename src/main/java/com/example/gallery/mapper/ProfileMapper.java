package com.example.gallery.mapper;

import com.example.gallery.domain.Profile;
import com.example.gallery.dto.ProfileDTO;

import java.util.List;

public interface ProfileMapper {

  ProfileDTO profileToProfileDTO(Profile profile);

  Profile ProfileDTOToProfile(ProfileDTO profile);

  List<ProfileDTO> listProfileToProfileDTO(List<Profile> list);

}

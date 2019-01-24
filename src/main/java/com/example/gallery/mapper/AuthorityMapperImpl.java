package com.example.gallery.mapper;

import com.example.gallery.domain.Authority;
import com.example.gallery.dto.AuthorityDTO;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class AuthorityMapperImpl implements AuthorityMapper {
  @Autowired
  private ModelMapper modelMapper;

  @Override
  public AuthorityDTO authorityToAuthorityDTO(Authority authority) {
    return modelMapper.map(authority, AuthorityDTO.class);
  }

  @Override
  public Authority authorityDTOToAuthority(AuthorityDTO authorityDTO) {
    return modelMapper.map(authorityDTO, Authority.class);
  }

  @Override
  public List<AuthorityDTO> authoritiesToAuthoritiesDTO(List<Authority> users) {
    Type type = new TypeToken<List<AuthorityDTO>>() {}.getType();

    List<AuthorityDTO> authorityDTOList = modelMapper.map(users, type);
    return authorityDTOList;
  }
}

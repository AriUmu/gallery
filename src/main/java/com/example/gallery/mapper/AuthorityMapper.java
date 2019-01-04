package com.example.gallery.mapper;

import com.example.gallery.domain.Authority;
import com.example.gallery.dto.AuthorityDTO;
import org.mapstruct.Mapper;

import java.util.List;

public interface AuthorityMapper {
  AuthorityDTO authorityToAuthorityDTO(Authority authority);

  Authority authorityDTOToAuthority(AuthorityDTO authority);

  List<AuthorityDTO> authoritiesToAuthoritiesDTO(List<Authority> users);

}

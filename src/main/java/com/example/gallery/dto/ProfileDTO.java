package com.example.gallery.dto;

import java.util.List;

public class ProfileDTO {

  private Long id;

  private String name;

  private List<AuthorityDTO> authorities;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<AuthorityDTO> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<AuthorityDTO> authorities) {
    this.authorities = authorities;
  }
}

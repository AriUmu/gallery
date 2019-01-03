package com.example.gallery.dto;

import java.util.List;

public class ProfileDTO {

  private Long id;

  private String login;

  private List<AuthorityDTO> authorities;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public List<AuthorityDTO> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<AuthorityDTO> authorities) {
    this.authorities = authorities;
  }
}

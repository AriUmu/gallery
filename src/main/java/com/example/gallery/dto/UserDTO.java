package com.example.gallery.dto;

import java.sql.Timestamp;

public class UserDTO {

  private Long id;

  private String login;

  private String password;

  private Timestamp lastLoginTime;

  private Long sessionId;

  private String name;

  private ProfileDTO profile;

  public ProfileDTO getProfile() {
    return profile;
  }

  public void setProfile(ProfileDTO profile) {
    this.profile = profile;
  }

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Timestamp getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Timestamp lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public Long getSessionId() {
    return sessionId;
  }

  public void setSessionId(Long sessionId) {
    this.sessionId = sessionId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

package com.example.gallery.domain;

import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user", schema = "public")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NonNull
  private String login;

  @NonNull
  private String password;

  @NonNull
  private Timestamp lastLoginTime;

  private Long sessionId;

  @ManyToOne
  private Profile profile;

  @NonNull
  private String name;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  @Transient
  public List<GrantedAuthority> getGrantedAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    if(!getProfile().getAuthorities().isEmpty()){
      for(Authority authority : getProfile().getAuthorities()){
        authorities.add(new SimpleGrantedAuthority(authority.getName()));
      }
    }
    return authorities;
  }
}

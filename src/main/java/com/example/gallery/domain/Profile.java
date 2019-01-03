package com.example.gallery.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profile", schema = "public")
public class Profile {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @NotNull
  private String login;

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

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name="PROFILE_AUTHORITY",
          joinColumns=@JoinColumn(name="profile_id", referencedColumnName="id"),
          inverseJoinColumns=@JoinColumn(name="authority_id", referencedColumnName="id"))
  private List<Authority> authorities;

  public List<Authority> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<Authority> authorities) {
    this.authorities = authorities;
  }
}

package com.example.gallery.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROFILE", schema = "PUBLIC")
public class Profile {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  private String name;

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

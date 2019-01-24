package com.example.gallery.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "authority", schema = "public")
public class Authority {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @NonNull
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
}

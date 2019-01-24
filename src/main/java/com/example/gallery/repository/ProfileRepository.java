package com.example.gallery.repository;

import com.example.gallery.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
  List<Profile> findAll();
}

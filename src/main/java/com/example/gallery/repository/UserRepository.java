package com.example.gallery.repository;

import com.example.gallery.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

  User findByLogin(String login);

  Optional<User> findById(Long id);
}

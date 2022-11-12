package com.example.javaSpringBoot.users;

// import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Optional<User> findUserBy
}

package com.proyectoAulaBD.repository;

import com.proyectoAulaBD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository< User, Long> {

    User findByEmail(String email);
}

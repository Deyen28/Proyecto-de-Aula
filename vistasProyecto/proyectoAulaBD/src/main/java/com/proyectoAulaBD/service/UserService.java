package com.proyectoAulaBD.service;

import com.proyectoAulaBD.model.User;
import com.proyectoAulaBD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    public User guardar(User usuario) {
        return userRepository.save(usuario);
    }

    public User obtenerPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        userRepository.deleteById(id);
    }

    public User obtenerPorEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

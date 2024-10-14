package com.proyectoAulaBD.service;

import com.proyectoAulaBD.model.User;
import com.proyectoAulaBD.repository.UserRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public User actualizarUsuario(User updatedUser) {
        User existingUser = userRepository.findById(updatedUser.getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + updatedUser.getId()));

        // Actualiza solo los campos que necesitas
        existingUser.setNombre(updatedUser.getNombre());
        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setDireccion(updatedUser.getDireccion());

        // Actualiza la contraseña solo si se proporciona una nueva
        if (updatedUser.getContrasena() != null && !updatedUser.getContrasena().isEmpty()) {
            existingUser.setContrasena(updatedUser.getContrasena());
        }

        // Guarda y devuelve el usuario actualizado
        return userRepository.save(existingUser);
    }

    public User obtenerPorEmail(String email) {
        return userRepository.findByEmail(email);
    }


}

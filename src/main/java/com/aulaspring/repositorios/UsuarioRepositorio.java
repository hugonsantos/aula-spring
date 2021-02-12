package com.aulaspring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}

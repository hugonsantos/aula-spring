package com.aulaspring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}

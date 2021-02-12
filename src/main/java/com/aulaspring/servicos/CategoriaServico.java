package com.aulaspring.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.entidades.Categoria;
import com.aulaspring.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio repositorio;
	
	public List<Categoria> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Categoria buscarCategoria(Long id) {
		Optional<Categoria> categoria = repositorio.findById(id);
		return categoria.get();
	}
}

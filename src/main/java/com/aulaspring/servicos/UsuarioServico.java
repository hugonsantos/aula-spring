package com.aulaspring.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.entidades.Usuario;
import com.aulaspring.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Usuario buscarUsuario(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario.get();
	}
}

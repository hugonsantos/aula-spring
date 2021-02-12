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
	private UsuarioRepositorio usuarioRepositorio;
	
	public List<Usuario> buscarTodos() {
		return usuarioRepositorio.findAll();
	}
	
	public Usuario buscarUsuario(Long id) {
		Optional<Usuario> usuario = usuarioRepositorio.findById(id);
		return usuario.get();
	}
}

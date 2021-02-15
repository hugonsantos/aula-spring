package com.aulaspring.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.entidades.Usuario;
import com.aulaspring.repositorios.UsuarioRepositorio;
import com.aulaspring.servicos.excecoes.RecursoNaoEncontradoExcecao;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Usuario buscarUsuario(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario.orElseThrow(() -> new RecursoNaoEncontradoExcecao(id));
	}
	
	public Usuario salvar(Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	
	public Usuario atualizar(Long id, Usuario usuario) {
		Usuario u = repositorio.getOne(id);
		atualizarDados(u, usuario);
		return repositorio.save(u);
	}

	private void atualizarDados(Usuario u, Usuario usuario) {
		
		u.setNome(usuario.getNome());
		u.setEmail(usuario.getEmail());
		u.setFone(usuario.getFone());
	}
}

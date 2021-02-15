package com.aulaspring.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.aulaspring.entidades.Usuario;
import com.aulaspring.repositorios.UsuarioRepositorio;
import com.aulaspring.servicos.excecoes.BancoDadosExcecao;
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
		try {
			
			repositorio.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new BancoDadosExcecao(e.getMessage());
		}
	}
	
	public Usuario atualizar(Long id, Usuario usuario) {
		try {
			
			Usuario u = repositorio.getOne(id);
			atualizarDados(u, usuario);
			return repositorio.save(u);
		}
		catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		}
	}

	private void atualizarDados(Usuario u, Usuario usuario) {
		
		u.setNome(usuario.getNome());
		u.setEmail(usuario.getEmail());
		u.setFone(usuario.getFone());
	}
}

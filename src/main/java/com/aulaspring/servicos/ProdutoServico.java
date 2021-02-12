package com.aulaspring.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.entidades.Produto;
import com.aulaspring.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repositorio;
	
	public List<Produto> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Produto buscarProduto(Long id) {
		Optional<Produto> produto = repositorio.findById(id);
		return produto.get();
	}
}

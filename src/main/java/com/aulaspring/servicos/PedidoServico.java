package com.aulaspring.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.entidades.Pedido;
import com.aulaspring.repositorios.PedidoRepositorio;

@Service
public class PedidoServico {

	@Autowired
	private PedidoRepositorio repositorio;
	
	public List<Pedido> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Pedido buscarPedido(Long id) {
		Optional<Pedido> pedido = repositorio.findById(id);
		return pedido.get();
	}
}

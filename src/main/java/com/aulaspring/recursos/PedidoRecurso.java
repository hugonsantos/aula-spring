package com.aulaspring.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.entidades.Pedido;
import com.aulaspring.servicos.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecurso {

	@Autowired
	private PedidoServico servico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodos() {
		
		List<Pedido> lista = servico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Pedido> buscarPedido(@PathVariable Long id) {
		
		Pedido p = servico.buscarPedido(id);
		return ResponseEntity.ok().body(p);
	}
}

package com.aulaspring.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.entidades.Categoria;
import com.aulaspring.servicos.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso {

	@Autowired
	private CategoriaServico servico;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos() {
		
		List<Categoria> lista = servico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Categoria> buscarCategoria(@PathVariable Long id) {
		
		Categoria c = servico.buscarCategoria(id);
		return ResponseEntity.ok().body(c);
	}
}

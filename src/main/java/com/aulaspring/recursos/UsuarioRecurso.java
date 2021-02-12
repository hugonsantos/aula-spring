package com.aulaspring.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.entidades.Usuario;
import com.aulaspring.servicos.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico usuarioServico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodos() {
		
		List<Usuario> lista = usuarioServico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
		
		Usuario u = usuarioServico.buscarUsuario(id);
		return ResponseEntity.ok().body(u);
	}
}

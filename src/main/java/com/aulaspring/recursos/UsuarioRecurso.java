package com.aulaspring.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {

	@GetMapping
	public ResponseEntity<Usuario> buscarTodos() {
		
		Usuario u = new Usuario(1L, "Maria", "maria@gmail.com", "11985487896", "1234");
		return ResponseEntity.ok().body(u);
	}
}

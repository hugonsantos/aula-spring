package com.aulaspring.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aulaspring.entidades.Usuario;
import com.aulaspring.servicos.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodos() {
		
		List<Usuario> lista = servico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
		
		Usuario u = servico.buscarUsuario(id);
		return ResponseEntity.ok().body(u);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario usuario) {
		
		usuario = servico.salvar(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
		
		servico.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
		
		usuario = servico.atualizar(id, usuario);
		return ResponseEntity.ok().body(usuario);
	}
}

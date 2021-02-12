package com.aulaspring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulaspring.entidades.Usuario;
import com.aulaspring.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "11984585236", "1234");
		Usuario u2 = new Usuario(null, "Bob Brown", "bob@gmail.com", "11984585236", "1234");
		Usuario u3 = new Usuario(null, "Alex Green", "alex@gmail.com", "11984585236", "1234");
		Usuario u4 = new Usuario(null, "Hugo Nascimento", "hugo@gmail.com", "11984585236", "1234");
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2, u3, u4));
	}
}

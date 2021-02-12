package com.aulaspring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulaspring.entidades.Pedido;
import com.aulaspring.entidades.Usuario;
import com.aulaspring.repositorios.PedidoRepositorio;
import com.aulaspring.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "11984585236", "1234");
		Usuario u2 = new Usuario(null, "Bob Brown", "bob@gmail.com", "11984585236", "1234");
		Usuario u3 = new Usuario(null, "Alex Green", "alex@gmail.com", "11984585236", "1234");
		Usuario u4 = new Usuario(null, "Hugo Nascimento", "hugo@gmail.com", "11984585236", "1234");
		
		Pedido p1 = new Pedido(null, Instant.parse("2020-02-21T19:27:08Z"), u4);
		Pedido p2 = new Pedido(null, Instant.parse("2020-03-21T10:19:35Z"), u4);
		Pedido p3 = new Pedido(null, Instant.parse("2019-10-05T13:55:00Z"), u1);
		Pedido p4 = new Pedido(null, Instant.parse("2021-01-11T14:39:58Z"), u2);
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2, u3, u4));
		pedidoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4));
	}
}

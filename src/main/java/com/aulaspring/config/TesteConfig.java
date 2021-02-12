package com.aulaspring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulaspring.entidades.Categoria;
import com.aulaspring.entidades.Pedido;
import com.aulaspring.entidades.Usuario;
import com.aulaspring.entidades.enums.PedidoStatus;
import com.aulaspring.repositorios.CategoriaRepositorio;
import com.aulaspring.repositorios.PedidoRepositorio;
import com.aulaspring.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "11984585236", "1234");
		Usuario u2 = new Usuario(null, "Bob Brown", "bob@gmail.com", "11984585236", "1234");
		Usuario u3 = new Usuario(null, "Alex Green", "alex@gmail.com", "11984585236", "1234");
		Usuario u4 = new Usuario(null, "Hugo Nascimento", "hugo@gmail.com", "11984585236", "1234");
		
		Pedido p1 = new Pedido(null, Instant.parse("2020-02-21T19:27:08Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u4);
		Pedido p2 = new Pedido(null, Instant.parse("2020-03-21T10:19:35Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u4);
		Pedido p3 = new Pedido(null, Instant.parse("2019-10-05T13:55:00Z"), PedidoStatus.ENVIADO, u1);
		Pedido p4 = new Pedido(null, Instant.parse("2021-01-11T14:39:58Z"), PedidoStatus.PAGO, u2);
		
		Categoria c1 = new Categoria(null, "Eletronicos");
		Categoria c2 = new Categoria(null, "Livros");
		Categoria c3 = new Categoria(null, "Computadores");
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2, u3, u4));
		pedidoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4));
		categoriaRepositorio.saveAll(Arrays.asList(c1, c2, c3));
	}
}

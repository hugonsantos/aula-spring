package com.aulaspring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulaspring.entidades.Categoria;
import com.aulaspring.entidades.ItemPedido;
import com.aulaspring.entidades.Pedido;
import com.aulaspring.entidades.Produto;
import com.aulaspring.entidades.Usuario;
import com.aulaspring.entidades.enums.PedidoStatus;
import com.aulaspring.repositorios.CategoriaRepositorio;
import com.aulaspring.repositorios.ItemPedidoRepositorio;
import com.aulaspring.repositorios.PedidoRepositorio;
import com.aulaspring.repositorios.ProdutoRepositorio;
import com.aulaspring.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private PedidoRepositorio pedidoRepositorio;

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private ItemPedidoRepositorio itemPedidoRepositorio;

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
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2, u3, u4));
		pedidoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4));

		Categoria c1 = new Categoria(null, "Eletronicos");
		Categoria c2 = new Categoria(null, "Livros");
		Categoria c3 = new Categoria(null, "Computadores");

		Produto pd1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pd2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pd3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pd4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pd5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoriaRepositorio.saveAll(Arrays.asList(c1, c2, c3));
		produtoRepositorio.saveAll(Arrays.asList(pd1, pd2, pd3, pd4, pd5));
		
		pd1.getCategorias().add(c2);
		pd2.getCategorias().add(c1);
		pd2.getCategorias().add(c3);
		pd3.getCategorias().add(c3);
		pd4.getCategorias().add(c3);
		pd5.getCategorias().add(c2);

		produtoRepositorio.saveAll(Arrays.asList(pd1, pd2, pd3, pd4, pd5));
		
		ItemPedido oi1 = new ItemPedido(p1, pd1, 2, pd1.getPreco());
		ItemPedido oi2 = new ItemPedido(p1, pd3, 1, pd3.getPreco());
		ItemPedido oi3 = new ItemPedido(p2, pd3, 2, pd3.getPreco());
		ItemPedido oi4 = new ItemPedido(p3, pd5, 2, pd5.getPreco()); 

		itemPedidoRepositorio.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}
}

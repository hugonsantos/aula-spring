package com.aulaspring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}

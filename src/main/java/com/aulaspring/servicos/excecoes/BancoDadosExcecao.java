package com.aulaspring.servicos.excecoes;

public class BancoDadosExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BancoDadosExcecao(String mensagem) {
		
		super(mensagem);
	}
}

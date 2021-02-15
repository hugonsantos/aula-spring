package com.aulaspring.recursos.excecoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aulaspring.servicos.excecoes.BancoDadosExcecao;
import com.aulaspring.servicos.excecoes.RecursoNaoEncontradoExcecao;

@ControllerAdvice
public class ManipuladorExcecaoRecursos {

	@ExceptionHandler(RecursoNaoEncontradoExcecao.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoExcecao e, HttpServletRequest request) {
		
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		ErroPadrao ep = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(ep);
	}
	
	@ExceptionHandler(BancoDadosExcecao.class)
	public ResponseEntity<ErroPadrao> bancoDados(BancoDadosExcecao e, HttpServletRequest request) {
		
		String erro = "Erro no banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		ErroPadrao ep = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(ep);
	}
}

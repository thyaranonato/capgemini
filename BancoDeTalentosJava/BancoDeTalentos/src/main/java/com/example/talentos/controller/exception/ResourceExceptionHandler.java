package com.example.talentos.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.talentos.service.exceptions.RecursoNaoEncontrado;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(RecursoNaoEncontrado.class)
	public ResponseEntity<StandardError> entidadeNaoEncontrada(RecursoNaoEncontrado e, HttpServletRequest req) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Recurso não encontrado");
		err.setMessage(e.getMessage());
		err.setPath(req.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
}

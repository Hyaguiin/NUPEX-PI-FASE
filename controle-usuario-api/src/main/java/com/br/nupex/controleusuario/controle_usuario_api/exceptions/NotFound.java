package com.br.nupex.controleusuario.controle_usuario_api.exceptions;

public class NotFound extends RuntimeException {
	public  NotFound(String erro, Throwable causa) {
		super(erro, causa);
	}

	public  NotFound(String erro) {
		super(erro);
	}
}
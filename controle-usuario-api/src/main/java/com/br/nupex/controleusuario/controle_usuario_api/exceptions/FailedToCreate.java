package com.br.nupex.controleusuario.controle_usuario_api.exceptions;

public class FailedToCreate extends RuntimeException {
	public FailedToCreate(String erro, Throwable causa) {
		super(erro, causa);
	}

	public FailedToCreate(String erro) {
		super(erro);
	}
}
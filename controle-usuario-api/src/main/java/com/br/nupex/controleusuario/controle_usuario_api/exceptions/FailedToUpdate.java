package com.br.nupex.controleusuario.controle_usuario_api.exceptions;

public class FailedToUpdate extends RuntimeException {
	public FailedToUpdate(String erro, Throwable causa) {
		super(erro, causa);
	}

	public FailedToUpdate(String erro) {
		super(erro);
	}
}
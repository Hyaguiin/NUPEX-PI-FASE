package com.br.nupex.controleusuario.controle_usuario_api.exceptions;

public class FailedToDelete extends RuntimeException {
	public FailedToDelete(String erro, Throwable causa) {
		super(erro, causa);
	}

	public FailedToDelete(String erro) {
		super(erro);
	}
}
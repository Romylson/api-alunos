package br.com.procode.api.exception;


public class AlunoJaExistenteException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AlunoJaExistenteException(String mensagem) {
        super("mensagem");
    }

}

package excecoes;

public class CpfCadastradoException extends Exception {
	public CpfCadastradoException() {
		super ("Cpf ja cadastrado");
	}
}
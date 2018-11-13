package pessoas;

public class ContaCliente extends ContaAbstrata {
	public ContaCliente(String cpf, String nome, int idade) {
		super (cpf, nome, idade);
	}
	
	public void creditar (double valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	
	public void debitar (double valor) {
		this.setSaldo(this.getSaldo() - valor);
	}
	
}

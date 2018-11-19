package pessoas;

public class ContaCliente extends ContaAbstrata {
	private int bonusFidelidade; // a cada compra ganha um ponto de bonusFidelidade;

	public ContaCliente(String cpf, String nome, int idade) {
		super(cpf, nome, idade);
	}

	public void creditar(double valor) { // depositando dinheiro
		this.setSaldo(this.getSaldo() + valor);
	}

	public void debitar(double valor) { // realizado uma compra ao chamado esse metodo
		if (bonusFidelidade < 10) {
			this.setSaldo(this.getSaldo() - valor);
			bonusFidelidade += 1;
		} else {
			bonusFidelidade = 0;
		}
	}

}

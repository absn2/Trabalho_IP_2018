package pessoas;

public class ContaCliente extends ContaAbstrata {
	private int bonusFidelidade; // a cada compra ganha um ponto de bonusFidelidade;

	public ContaCliente(String cpf, String nome, int idade) {
		super(cpf, nome, idade);
		this.setCliente(true);
	}

	public void creditar(double valor) { // depositando dinheiro
		this.setSaldo(this.getSaldo() + valor);
	}

	public void debitar(double valor) { // realizado uma compra ao chamado esse metodo
		this.bonusFidelidade += 1;
		if (bonusFidelidade < 10) {
			this.setSaldo(this.getSaldo() - valor);
		} else {
			bonusFidelidade = 0;
		}
	}

}

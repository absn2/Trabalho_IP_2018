package pessoas;

public class ContaFuncionario extends ContaAbstrata {
	private int bonus; // a cada venda se recebe um ponto de b√¥nus.

	public ContaFuncionario(String cpf, String nome, int idade) {
		super(cpf, nome, idade);
	}

	public void creditar(double valor) {
		this.bonus += 1;
		if (this.bonus < 10) {
			this.setSaldo(this.getSaldo() + (0.30 * valor));
		} else { // na 10™ venda o funcionario ganha um bonus
			this.setSaldo(this.getSaldo() + (0.30 * valor) + valor);
			this.bonus = 0;
		}
	}
}

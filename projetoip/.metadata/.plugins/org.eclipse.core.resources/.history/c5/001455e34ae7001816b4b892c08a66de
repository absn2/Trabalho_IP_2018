package pessoas;

public class ContaFuncionario extends ContaAbstrata {
	private int bonus;

	public ContaFuncionario(String cpf, String nome, int idade) {
		super(cpf, nome, idade);
	}

	public void creditar(double valor) {
		if (this.bonus < 10) {
			this.setSaldo(this.getSaldo() + (0.30 * valor));
			this.bonus += 1;
		} else {
			this.setSaldo(this.getSaldo() + (valor));
			this.bonus = 0;
		}
	}
	
	public void cliente () {
		this.setCliente(false);
	}
	

	
	
}

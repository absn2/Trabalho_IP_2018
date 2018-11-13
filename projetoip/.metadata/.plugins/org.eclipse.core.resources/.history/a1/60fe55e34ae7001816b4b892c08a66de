package pessoas;

public abstract class ContaAbstrata {
	private String cpf;
	private String nome;
	private int idade;
	private double saldo;
	private boolean cliente;
	
	public ContaAbstrata (String cpf, String nome, int idade) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.saldo = 0.0;
		this.cliente = true;
	}
	
	public abstract void creditar (double valor);
	
	protected void setSaldo (double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}
}

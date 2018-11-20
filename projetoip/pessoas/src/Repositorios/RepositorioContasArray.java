package Repositorios;

import pessoas.ContaAbstrata;

public class RepositorioContasArray implements RepositorioContas {
	private ContaAbstrata[] conta = new ContaAbstrata[100];
	private int quantContas;

	public RepositorioContasArray() {
		ContaAbstrata[] conta = new ContaAbstrata[100];
	}

	public void inserir(ContaAbstrata conta) {
		boolean existe = this.existe(conta.getCpf());
		if (existe == false) {
			boolean parou = false;
			for (int aux = 0; aux <= this.conta.length && parou == false; aux++) {
				if (aux == this.conta.length) {
					System.out.print("NUMERO DE CADASTRADOS EXCEDIDSOS");
				} else {
					if (this.conta[aux] != null) {
						continue;
					} else {
						this.conta[aux] = conta;
						this.quantContas = aux;
						parou = true;
					}
				}
			}
		} else {
			System.out.print("CPF JA CADASTRADO");
		}

	}

	public boolean existe(String cpf) {
		for (int aux = 0; aux < this.conta.length; aux++) {
			if (conta[aux] != null && this.conta[aux].getCpf().equals(cpf)) {
				return true;
			} else {
				continue;
			}
		}
		return false;
	}

	public void remover(String cpf) {
		boolean resultado = this.existe(cpf);
		if (resultado == true) {
			boolean parou = false;
			for (int aux = 0; aux < this.conta.length && parou == false; aux++) {
				if (this.conta[aux].getCpf().equals(cpf)) {
					this.conta[aux] = null;
					for (int auxRecolocar = aux+1; auxRecolocar < this.conta.length; auxRecolocar++) {
						this.conta[aux] = this.conta[auxRecolocar];
					}
					this.quantContas -= 1;
					parou = true;
				}
			}
		} else {
			System.out.print("CPF NAO CADASTRADO");
		}
	}

	public void atualizar(ContaAbstrata conta) {
		boolean resultado = this.existe(conta.getCpf());
		if (resultado == true) {
			boolean parou = false;
			for (int aux = 0; aux < this.conta.length && parou == false; aux++) {
				if (this.conta[aux].getCpf().equals(conta.getCpf())) {
					this.conta[aux] = conta;
					parou = true;
				}
			}
		} else {
			System.out.print("CPF NAO CADASTRADO");
		}

	}

	public ContaAbstrata procurar(String cpf) {
		boolean resultado = this.existe(cpf);
		if (resultado == true) {
			boolean parou = false;
			ContaAbstrata procurada = null;
			for (int aux = 0; aux < this.conta.length && parou == false; aux++) {
				if (this.conta[aux].getCpf().equals(cpf)) {
					procurada = conta[aux];
					parou = true;
				}
			}
			return procurada;	
		}else {
			throw new RuntimeException("CPF NAO CADASTRADO");
		}
	}
}

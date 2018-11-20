package Repositorios;

import pessoas.ContaAbstrata;

public class RepositorioContasLista implements RepositorioContas {
	private ContaAbstrata conta;
	private RepositorioContasLista contaProxima;
	private int quantContas;

	public RepositorioContasLista() {
		this.conta = null;
		this.contaProxima = null;
		this.quantContas = 1;
	}

	public void inserir(ContaAbstrata conta) { // inserir em ordem crescente de idades
		boolean resultado = this.existe(conta.getCpf());
		if (resultado == false) {
			if (this.quantContas < 100) {
				if (this.conta != null) {
					this.quantContas +=1;
					this.contaProxima.inserir(conta);
				} else {
					this.conta = conta;
					this.contaProxima = new RepositorioContasLista();
				}
			} else {
				System.out.println("NUMERO DE LIMITES DE CADASTROS EXCEDIDOS");
			}
		} else {
			System.out.println("CPF ja cadastrado");
		}
	}

	public boolean existe(String cpf) {
		if (this.conta != null) {
			if (this.conta.getCpf().equals(cpf)) {
				return true;
			} else {
				return this.contaProxima.existe(cpf);
			}
		} else {
			return false;
		}
	}

	public void remover(String cpf) {
		if (this.conta != null) {
			if (this.conta.getCpf().equals(cpf)) {
				this.conta = this.contaProxima.conta;
				this.contaProxima = this.contaProxima.contaProxima;
				this.quantContas -= 1;
			} else {
				this.contaProxima.remover(cpf);
			}
		} else {
			throw new RuntimeException("CPF NAO CADASTRADO");
		}
	}

	public void atualizar(ContaAbstrata conta) {
		if (this.conta != null) {
			if (this.conta.getCpf().equals(conta.getCpf())) {
				this.conta = conta;
			} else {
				this.contaProxima.atualizar(conta);
			}
		} else {
			throw new RuntimeException("CPF NAO CADASTRADO");
		}
	}

	public ContaAbstrata procurar(String cpf) {
		if (this.conta != null) {
			if (this.conta.getCpf().equals(cpf)) {
				return this.conta;
			} else {
				return this.contaProxima.procurar(cpf);
			}
		} else {
			throw new RuntimeException("CPF NAO CADASTRADO");
		}
	}
}

package Repositorios;

import pessoas.ContaAbstrata;

public class RepositorioContasLista implements RepositorioContas {
	private ContaAbstrata conta;
	private String aux;
	private RepositorioContasLista contaProxima;
	private int numeroDeConta;

	public RepositorioContasLista() {
		this.conta = null;
		this.aux = "";
		this.contaProxima = null;
	}

	public void inserir(ContaAbstrata conta, boolean resultado) { // inserir em ordem crescente de idades
		if (resultado == false) {
			this.numeroDeConta += 1;
			if (this.numeroDeConta <= 100) {
				if (!this.aux.equals("")) {
					this.contaProxima.inserir(conta, resultado);
				} else {
					this.conta = conta;
					this.aux = "cadastrado";
					this.contaProxima = new RepositorioContasLista();
				}
			}
			else {
				System.out.println("NUMERO DE LIMITES DE CADASTROS EXCEDIDOS");
			}
		} else {
			System.out.println("CPF ja cadastrado");
		}
	}

	public boolean existe(String cpf) {
		if (!this.aux.equals("")) {
			if (this.conta.getCpf().equals(cpf)) {
				return true;
			} else {
				return this.contaProxima.existe(cpf);
			}
		} else {
			return false;
		}
	}

	public void remover(String numero) {
		if (this.conta != null) {
			if (this.conta.getCpf().equals(numero)) {
				this.conta = this.contaProxima.conta;
				this.aux = this.contaProxima.aux;
				this.contaProxima = this.contaProxima.contaProxima;
			} else {
				this.contaProxima.remover(numero);
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

	public String imprimirRepositorio(String imprimir) {
		if (this.conta != null) {
			if (this.conta.getCliente() == false) {
				imprimir += "\n#CONTA FUNCIONARIO#";
			} else {
				imprimir += "\n#CONTA CLIENTE#";
			}
			imprimir += "\nNome : " + conta.getNome();
			imprimir += "\nIdade : " + conta.getIdade();
			imprimir += "\nCPF : " + conta.getCpf();
			imprimir += "\nSaldo : " + conta.getSaldo() + "\n";
			return this.contaProxima.imprimirRepositorio(imprimir);
		}
		return imprimir;

	}

	public String imprimirConta(ContaAbstrata conta) {
		String imprimir = "";
		if (conta.getCliente() == true) {
			imprimir = "\n#CONTA FUNCIONARIO#";
		} else {
			imprimir = "\n#CONTA CLIENTE#";
		}
		imprimir += "\nNome : " + conta.getNome();
		imprimir += "\nIdade : " + conta.getIdade();
		imprimir += "\nCPF : " + conta.getCpf();
		imprimir += "\nSaldo : " + conta.getSaldo() + "\n";
		return imprimir;
	}
}

package Repositorios;

import pessoas.ContaAbstrata;

public class RepositorioContasArray implements RepositorioContas {
	private ContaAbstrata[] repositorio = new ContaAbstrata[99];
	
	public RepositorioContasArray() {
		ContaAbstrata[] repositorio = new ContaAbstrata[100];
	}

	public void inserir(ContaAbstrata conta, boolean existe) {
		if (existe == false) {
			boolean parou = false;
			for (int aux = 0; aux <= this.repositorio.length && parou == false; aux++) {
				if (aux == this.repositorio.length) {
					System.out.print("NUMERO DE CADASTRADOS EXCEDIDSOS");
				} else {
					if (this.repositorio[aux] != null) {
						continue;
					} else {
						repositorio[aux] = conta;
						parou = true;
					}
				}
			}
		} else {
			System.out.print("CPF JA CADASTRADO");
		}

	}

	public ContaAbstrata procurar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remover(String cpf) {
		// TODO Auto-generated method stub

	}

	public void atualizar(ContaAbstrata conta) {
		// TODO Auto-generated method stub

	}

	public boolean existe(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

}

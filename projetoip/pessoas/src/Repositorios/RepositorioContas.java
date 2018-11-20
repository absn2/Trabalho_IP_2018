package Repositorios;

import pessoas.ContaAbstrata;

public interface RepositorioContas {
	void inserir(ContaAbstrata conta);
	ContaAbstrata procurar(String cpf);
	void remover (String cpf);
	void atualizar (ContaAbstrata conta);
	boolean existe (String cpf);
}

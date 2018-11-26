package Repositorios;

import ContasCliente.ContaAbstrata;
import Excecoes.CpfCadastradoException;
import Excecoes.CpfNaoCadastradoException;

public interface RepositorioContas {
	void inserir(ContaAbstrata conta) throws CpfCadastradoException, NumeroCadastroExcedidoException;
	ContaAbstrata procurar(String cpf) throws CpfNaoCadastradoException;
	void remover (String cpf) throws CpfNaoCadastradoException;
	void atualizar (ContaAbstrata conta);
	boolean existe (String cpf);
}

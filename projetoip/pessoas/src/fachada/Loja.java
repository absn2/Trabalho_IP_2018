package fachada;

import ContasCliente.*;

import Excecoes.*;
import Excecoes.NumeroCadastroExcedidoException;
import Repositorios.*;
import cadastro.CadastroClientes;

public class Loja {
	CadastroClientes pessoa;

	public Loja(boolean repositorio) {
		if (repositorio) {
			this.pessoa = new CadastroClientes (new RepositorioContasLista());
		} else {
			
		}
	}
	
	// clientes 
	public void cadastroPessoas (ContaAbstrata conta) throws CpfCadastradoException, NumeroCadastroExcedidoException {
		if (!pessoa.existe(conta.getCpf())) {
			pessoa.cadastrar(conta);
		} else {
			throw new CpfCadastradoException();
		}
	}
	
	public void removerPessoa (String cpf) throws CpfNaoCadastradoException{
		if (pessoa.existe(cpf)) {
			pessoa.remover(cpf);
		} else {
			throw new CpfNaoCadastradoException();
		}
	}
	
	public ContaAbstrata procurarPessoa (String cpf) throws CpfNaoCadastradoException {
		if (pessoa.existe(cpf)) {
			return pessoa.procurar(cpf);
		} else {
			throw new CpfNaoCadastradoException();
		}
	}
	
	public void atualizarPessoa (ContaAbstrata conta) throws CpfNaoCadastradoException {
		if (pessoa.existe(conta.getCpf())) {
			pessoa.atualizar(conta);
		} else {
			throw new CpfNaoCadastradoException();
		}
	}
	
	public boolean existePessoa (String cpf) throws CpfNaoCadastradoException {
		if (pessoa.existe(cpf)) {
			return true;
		} else {
			throw new CpfNaoCadastradoException();
		}
	}
	
	// produto
	
	
	
	
	
	
	
	// franquia
	
	
}

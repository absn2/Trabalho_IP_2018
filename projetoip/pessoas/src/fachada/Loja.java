package fachada;

import ContasCliente.*;
import Excecoes.*;
import Repositorios.*;
import cadastro.CadastroClientes;

public class Loja {
	CadastroClientes clienteC;

	public Loja(boolean repositorio) {
		if (repositorio) {
			this.clienteC = new CadastroClientes (new RepositorioContasLista());
		} else {
			
		}
	}
	
	// clientes 
	public void cadastroCliente (ContaAbstrata conta) throws CpfCadastradoException, NumeroCadastroExcedidoException {
		if (!clienteC.existe(conta.getCpf())) {
			clienteC.cadastrar(conta);
		} else {
			throw new CpfCadastradoException();
		}
	}
	
	public void removerCliente (String cpf) throws CpfNaoCadastradoException{
		if (clienteC.existe(cpf)) {
			clienteC.remover(cpf);
		} else {
			throw new CpfNaoCadastradoException();
		}
	}
	
	public ContaAbstrata procurarCliente (String cpf) throws CpfNaoCadastradoException {
		if (clienteC.existe(cpf)) {
			return clienteC.procurar(cpf);
		} else {
			throw new CpfNaoCadastradoException();
		}
	}
	
	public void atualizarCliente (ContaAbstrata conta) throws CpfNaoCadastradoException {
		if (clienteC.existe(conta.getCpf())) {
			clienteC.atualizar(conta);
		} else {
			throw new CpfNaoCadastradoException();
		}
	}
	
	public boolean existeCliente (String cpf) throws CpfNaoCadastradoException {
		if (clienteC.existe(cpf)) {
			return true;
		} else {
			throw new CpfNaoCadastradoException();
		}
	}
	
	// produto
	
	
	
	
	
	
	
	// franquia
	
	
}

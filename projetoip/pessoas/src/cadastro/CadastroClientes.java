package cadastro;

import ContasCliente.ContaAbstrata;
import Excecoes.CpfCadastradoException;
import Repositorios.NumeroCadastroExcedidoException;
import Repositorios.RepositorioContas;

public class CadastroClientes {
	private RepositorioContas clientes;
	
	public void CadastroContas(RepositorioContas rep) {
		clientes = rep;
	}
	
	public void cadastrar (ContaAbstrata conta) throws CpfCadastradoException, NumeroCadastroExcedidoException {
		if (!conta.existe(conta.getCpf())) {
			clientes.inserir(conta);
		} else {
			
		}
	}
	
}
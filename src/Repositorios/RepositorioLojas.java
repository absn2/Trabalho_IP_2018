package Repositorios;

import Lojas.Lojas;

public interface RepositorioLojas {
	boolean existe (int codigo);
	void inserir(Lojas lojas);
	void remover (int codigo);
	Lojas procurar(int codigo);
	void atualizar (Lojas lojas);	
}

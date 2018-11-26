package Repositorios;

import ExcecoesProdutos.NumeroLimiteExcedido;
import ExcecoesProdutos.ProdutoJaCadastrado;
import ExcecoesProdutos.ProdutoNaoCadastrado;
import ExcecoesProdutos.ProdutoNaoEncontrado;
import Produtos.ClasseProdutos;

public interface RepositorioProduto {
	void inserir(ClasseProdutos produto)throws NumeroLimiteExcedido, ProdutoJaCadastrado;

	void remover(String nome)throws ProdutoNaoCadastrado;

	boolean existe(String nome);

	ClasseProdutos procurar(String nome)throws ProdutoNaoEncontrado;

	void atualizar(ClasseProdutos nome)throws ProdutoNaoEncontrado;

}

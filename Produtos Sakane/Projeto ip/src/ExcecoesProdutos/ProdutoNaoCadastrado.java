package ExcecoesProdutos;

public class ProdutoNaoCadastrado extends Exception {
	public ProdutoNaoCadastrado () {
		super ("Produto nao cadastrado");
	}
}
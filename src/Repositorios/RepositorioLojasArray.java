package Repositorios;

import Lojas.Lojas;

public class RepositorioLojasArray implements RepositorioLojas {
	private Lojas[] lojas = new Lojas[20];
	private int countLojas;

	public RepositorioLojasArray() {
		Lojas[] loja = new Lojas[20];
	}

	public void inserir(Lojas lojas) {
		if (!this.existe(lojas.getCodigo())) {
			boolean stop = false;
			for (int i = 0; i <= this.lojas.length && stop == false; i++) {
				if (i == this.lojas.length) {
					// ERRO
				} else {
					if (this.lojas[i] != null) {
						continue;
					} else {
						this.lojas[i] = lojas;
						this.countLojas = i;
						stop = true;
					}
				}
			}
		} else {
			// ERRO
		}

	}

	public boolean existe(int codigo) {
		for (int i = 0; i < this.lojas.length; i++) {
			if (this.lojas[i].getCodigo() == codigo && lojas[i] != null) {
				return true;
			} else {
				continue;
			}
		}
		return false;
	}

	public void remover(int codigo) {
		boolean resultado = this.existe(codigo);
		if (resultado == true) {
			boolean stop = false;
			for (int i = 0; i < this.lojas.length && stop == false; i++) {
				if (this.lojas[i].getCodigo() == codigo) {
					this.lojas[i] = null;
					for (int j = i + 1; j < this.lojas.length; j++) {
						this.lojas[i] = this.lojas[j];
					}
					this.countLojas -= 1;
					stop = true;
				}
			}
		} else {
			// ERRO
		}
	}

	public void atualizar(Lojas lojas) {
		if (this.existe(lojas.getCodigo())) {
			boolean stop = false;
			for (int i = 0; i < this.lojas.length && stop == false; i++) {
				if (this.lojas[i].getCodigo() == lojas.getCodigo()) {
					this.lojas[i] = lojas;
					stop = true;
				}
			}
		} else {
			// ERRO
		}

	}

	public Lojas procurar(int codigo) {
		boolean resultado = this.existe(codigo);
		if (resultado == true) {
			boolean stop = false;
			Lojas procurada = null;
			for (int i = 0; i < this.lojas.length && stop == false; i++) {
				if (this.lojas[i].getCodigo() == codigo) {
					stop = true;
					procurada = lojas[i];
				}
			}
			return procurada;
		} else {
			throw new RuntimeException("erro");
		}
	}
}

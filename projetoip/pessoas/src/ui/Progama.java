package ui;

import java.util.*;
import ContasCliente.*;
import Excecoes.*;
import Repositorios.*;
import fachada.Loja;

public class Progama {
	static Loja loja = new Loja();
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Loja loja = new Loja();
		System.out.println("Escolha" + "\n" + "1 - Papai" + "\n" + "2 - Mamae");
		boolean parar = false;
		while (parar == false) {
			int escolha = in.nextInt();
			if (escolha == 1) {
				System.out.println("oi");
				parar = true;
			} else if (escolha == 2) {
				System.out.println("oi");
				parar = true;
			} else {
				try {
					throw new NumeroInvalidoException();
				} catch (NumeroInvalidoException e) {
					System.out.println("\nNumero Invalido, por digite apenas o numero que tem opcao.");
				} finally {
					System.out.println("\nEscolha" + "\n" + "1 - Papai" + "\n" + "2 - Mamae");
				}
			}
		}
	}
}

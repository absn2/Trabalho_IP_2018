package ui;

import java.util.*;

import pessoas.*;
import cadastros.*;
import fachada.*;
import produtos.*;

public class main {

	public static void main(String[] args) {
		long tempoInicio = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		Loja loja = new Loja(true);
		System.out.println("-------SEJA BEM VINDO AO ACAICIN-------");
		System.out.println("-------GELADOS E VARIEDADES------------");
		// so pode rodar com um funcionario usando
		System.out.println("-------PARA INICIALIZAR O PROGAMA------");
		System.out.println("-------CADASTRE-SE NO SISTEMA----------");
		boolean parouInicio = false;
		while (!parouInicio) {
			try {
				System.out.println("CPF: ");
				long cpf = in.nextLong();
				in.nextLine();
				System.out.println("NOME: ");
				String nome = in.nextLine();
				System.out.println("IDADE: ");
				int idade = in.nextInt();
				in.nextLine();
				ContaFuncionario funcionario = new ContaFuncionario(cpf, nome, idade);
				try {
					loja.cadastroPessoas(funcionario);
					parouInicio = true;
				} catch (CpfCadastradoException | NumeroCadastroExcedidoException e2) {
				}
			} catch (InputMismatchException e) {
				System.out.println("***SO DIGITE NUMEROS NA SESSAO DO CPF E DA IDADE***\n");
				in.nextLine();
			}
		}
		boolean parou = false;
		// inicio interface
		while (!parou) {
			System.out.println("----BEM VINDO A INTERFACE DO FUNCIONARIO----");
			System.out.println("-----SELECIONE UMA DAS OPCOES A SEGUIR------");
			System.out.println("---> 1: PESSOAS");
			System.out.println("---> 2: PRODUTOS");
			System.out.println("---> 3: FRANQUIAS");
			System.out.println("---> 4: NEGOCIOS");
			System.out.println("---> 0: FINALIZAR SESSAO\n");
			int escolha = in.nextInt();
			if (escolha == 0) {
				parou = true;
			} else if (escolha == 1) {
				boolean parouCliente = false;
				// interface Pessoa
				while (!parouCliente) {
					System.out.println("---> 1: CADASTRO DE CLIENTE");
					System.out.println("---> 2: CADASTRO DE FUNCIONARIO");
					System.out.println("---> 3: REMOVER CLIENTE");
					System.out.println("---> 4: REMOVER FUNCIONARIO");
					System.out.println("---> 5: PROCURAR CLIENTE");
					System.out.println("---> 6: PROCURAR FUNCIONARIO");
					System.out.println("---> 0: VOLTAR A PAGINA ANTERIOR");
					int escolhaPessoa = in.nextInt();
					in.nextLine();
					if (escolhaPessoa == 0) {
						parouCliente = true;
						// interface Cadastro Cliente
					} else if (escolhaPessoa == 1) {
						try {
							System.out.println("CPF: ");
							long cpf = in.nextLong();
							in.nextLine();
							System.out.println("NOME: ");
							String nome = in.nextLine();
							System.out.println("IDADE: ");
							int idade = in.nextInt();
							in.nextLine();
							try {
								loja.cadastroPessoas(loja.criarContaCliente(cpf, nome, idade, escolhaPessoa));
								System.out.println("****CADASTRADO COM SUCESSO****\n");
							} catch (CpfCadastradoException e) {
								System.out.println("****Cpf ja cadastrado****\n");
							} catch (NumeroCadastroExcedidoException e) {
								System.out.println("****Numero de Cadastros Excedido****\n");
							}
						} catch (InputMismatchException e) {
							System.out.println("***SO DIGITE NUMEROS NA SESSAO DO CPF E DA IDADE***\n");
							in.nextLine();
						}
						// interface cadastro funcionario
					} else if (escolhaPessoa == 2) {
						try {
							System.out.println("CPF: ");
							long cpf = in.nextLong();
							in.nextLine();
							System.out.println("NOME: ");
							String nome = in.nextLine();
							System.out.println("IDADE: ");
							int idade = in.nextInt();
							in.nextLine();
							try {
								loja.cadastroPessoas(loja.criarContaCliente(cpf, nome, idade, escolhaPessoa));
								System.out.println("****CADASTRADO COM SUCESSO****\n");
							} catch (CpfCadastradoException e) {
								System.out.println("****Cpf ja cadastrado****\n");
							} catch (NumeroCadastroExcedidoException e) {
								System.out.println("****Numero de Cadastros Excedido****\n");
							}
						} catch (InputMismatchException e) {
							System.out.println("***SO DIGITE NUMEROS NA SESSAO DO CPF E DA IDADE***\n");
							in.nextLine();
						}
					} else if (escolhaPessoa == 3) {
						System.out.println("DIGITE APENAS O CPF PARA REMOVER : ");
						try {
							long cpf = in.nextLong();
							in.nextLine();
							try {
								if (!loja.procurarPessoa(cpf).getCliente()) {
									try {
										throw new TipoContaErradaClienteException();
									} catch (TipoContaErradaClienteException e) {
										System.out.println(
												"\n****Voce se referiu a uma conta de funcionario, por favor insira uma de CLIENTE****\n");
									}
								} else {
									loja.removerPessoa(cpf);
									System.out.println("****CONTA DE CLIENTE REMOVIDA****\n");
								}
							} catch (CpfNaoCadastradoException e) {
								System.out.println("****Cpf nao cadastrado****\n");
							}
						} catch (InputMismatchException e) {
							System.out.println("***SO DIGITE NUMEROS NA SESSAO DO CPF***\n");
							in.nextLine();
						}
					} else if (escolhaPessoa == 4) {
						System.out.println("DIGITE APENAS O CPF PARA REMOVER : ");
						try {
							long cpf = in.nextLong();
							in.nextLine();
							try {
								if (loja.procurarPessoa(cpf).getCliente()) {
									try {
										throw new TipoContaErradaFuncionarioException();
									} catch (TipoContaErradaFuncionarioException e) {
										System.out.println(
												"\n****Voce se referiu a uma conta de cliente, por favor insira uma de FUNCIONARIO****\n");
									}
								} else {
									loja.removerPessoa(cpf);
									System.out.println("****CONTA DE FUNCIONARIO REMOVIDA****\n");
								}
							} catch (CpfNaoCadastradoException e) {
								System.out.println("****Cpf nao cadastrado****\n");
							}
						} catch (InputMismatchException e) {
							System.out.println("***SO DIGITE NUMEROS NA SESSAO DO CPF***\n");
							in.nextLine();
						}
						// interface pessoa procurar
					} else if (escolhaPessoa == 5) {
						System.out.println("DIGITE APENAS O CPF PARA PROCURAR : ");
						try {
							long cpf = in.nextLong();
							in.nextLine();
							try {
								ContaAbstrata conta = loja.procurarPessoa(cpf);
								if (conta.getCliente()) {
									String nome = conta.getNome();
									cpf = conta.getCpf();
									int idade = conta.getIdade();
									double saldo = conta.getSaldo();
									conta.creditar(125);
									System.out.printf(
											"\n--CONTA CLIENTE--\nNome: %s\nCpf: %s\nIdade: %d\nSaldo: R$%.2f\n\n",
											nome, cpf, idade, saldo);
								} else {
									try {
										throw new TipoContaErradaClienteException();
									} catch (TipoContaErradaClienteException e) {
										System.out.println(
												"\n****Voce se referiu a uma conta de funcionario, por favor insira uma de CLIENTE****\n");
									}
								}
							} catch (CpfNaoCadastradoException e) {
								System.out.println("****Cpf nao cadastrado****\n");
							}
						} catch (InputMismatchException e) {
							System.out.println("***SO DIGITE NUMEROS NA SESSAO DO CPF***\n");
							in.nextLine();
						}
					} else if (escolhaPessoa == 6) {
						System.out.println("DIGITE APENAS O CPF PARA PROCURAR : ");
						try {
							long cpf = in.nextLong();
							in.nextLine();
							try {
								ContaAbstrata conta = loja.procurarPessoa(cpf);
								if (!conta.getCliente()) {
									String nome = conta.getNome();
									cpf = conta.getCpf();
									int idade = conta.getIdade();
									double saldo = conta.getSaldo();
									System.out.printf(
											"\n--CONTA FUNCIONARIO--\nNome: %s\nCpf: %s\nIdade: %d\nSaldo: R$%.2f\n\n",
											nome, cpf, idade, saldo);
								} else {
									try {
										throw new TipoContaErradaFuncionarioException();
									} catch (TipoContaErradaFuncionarioException e) {
										System.out.println(
												"\n****Voce se referiu a uma conta de cliente, por favor insira uma de FUNCIONARIO****\n");
									}
								}
							} catch (CpfNaoCadastradoException e) {
								System.out.println("****Cpf nao cadastrado****\n");
							}
						} catch (InputMismatchException e) {
							System.out.println("***SO DIGITE NUMEROS NA SESSAO DO CPF***\n");
							in.nextLine();
						}
					} else {
						try {
							throw new NumeroInvalidoException();
						} catch (NumeroInvalidoException e) {
							System.out.println(
									"*****Numero Invalido, por favor digite apenas o numero que tem opcao.*****\n");
						}
					}
				}
				// interface produtos
			} else if (escolha == 2) {
				boolean parouProduto = false;
				while (!parouProduto) {
					System.out.println("---> 1: CADASTRAR PRODUTO");
					System.out.println("---> 2: REMOVER PRODUTO");
					System.out.println("---> 3: PROCURAR PRODUTO");
					System.out.println("---> 0: VOLTAR A PAGINA ANTERIOR");
					int escolhaProduto = in.nextInt();
					in.nextLine();
					// interface de retorno
					if (escolhaProduto == 0) {
						parouProduto = true;
						// interface cadastrar produto
					} else if (escolhaProduto == 1) {
						System.out.println("NOME: ");
						String nomeProduto = in.nextLine();
						System.out.println("PRECO: ");
						double preco = in.nextDouble();
						System.out.println("TAMANHO: ");
						int tamanho = in.nextInt();
						try {
							loja.cadastrarProduto(loja.criarContaProduto(escolhaProduto, nomeProduto, preco, tamanho));
							System.out.println("****CADASTRADO COM SUCESSO****\n");
						} catch (ProdutoJaCadastrado e) {
							System.out.println("****PRODUTO JA CADASTRADO****\n");
						} catch (NumeroLimiteExcedido e) {
							System.out.println("****NUMERO DE CADASTROS EXCEDIDOS****\n");
						}
						// interface remover produto
					} else if (escolhaProduto == 2) {
						System.out.println("DIGITE O NOME DO PRODUTO PARA REMOVER: ");
						String nomeProduto = in.nextLine();
						try {
							loja.removerProduto(nomeProduto);
							System.out.println("****PRODUTO REMOVIDO COM SUCESSO****\n");
						} catch (ProdutoNaoCadastrado e) {
							System.out.println("****PRODUTO NAO CADASTRADO****\n");
						}
						// interface procurar produto
					} else if (escolhaProduto == 3) {
						System.out.println("DIGITE O NOME DO PRODUTO PARA PROCURAR: ");
						try {
							String nomeProduto = in.nextLine();
							ClasseProduto produtoEncontrado = loja.procurarProduto(nomeProduto);
							String nome = produtoEncontrado.getNome();
							double preco = produtoEncontrado.getPreco();
							int tamanho = produtoEncontrado.getTamanho();
							System.out.printf("\n--PRODUTO--\nNome: %s\nPRECO: R$%.2f\nTAMANHO: %d\n\n", nome, preco,
									tamanho);
						} catch (ProdutoNaoEncontrado e) {
							System.out.println("****PRODUTO NAO ENCONTRADO****\n");
						}
					}
				}

			} else if (escolha == 3) {

			} else if (escolha == 4) {
				boolean parouNegocios = false;
				while (!parouNegocios) {
					System.out.println("---> 1: CREDITAR NA CONTA");
					System.out.println("---> 2: CREDITAR NA FRANQUIA");
					System.out.println("---> 3: FAZER PEDIDO");
					System.out.println("---> 0: VOLTAR A PAGINA ANTERIOR");
					int escolhaNegocios = in.nextInt();
					in.nextLine();
					if (escolhaNegocios == 1) {
						System.out.println("DIGITE APENAS O CPF PARA PROCURAR CONTA DO CLIENTE : ");
					} else if (escolhaNegocios == 2) {

					} else if (escolhaNegocios == 3) {
						System.out.println("DIGITE APENAS O CPF DO FUNCIONARIO QUE ESTA VENDENDO O PRODUTO : ");
						long cpf = in.nextLong();
						try {
							ContaAbstrata conta = loja.procurarPessoa(cpf);
						} catch (CpfNaoCadastradoException e) {
							System.out.println("****Cpf nao cadastrado****\n");
						}
					} else if (escolhaNegocios == 0) {
						parouNegocios = true;
					} else {

					}
				}
			} else {
				try {
					throw new NumeroInvalidoException();
				} catch (NumeroInvalidoException e) {
					System.out.println("*****Numero Invalido, por favor digite apenas o numero que tem opcao.*****\n");
				}
			}
		}
		System.out.println("---SESS�O ENCERRADA----");
		System.out.println("Tempo da Sess�o : " + ((System.currentTimeMillis() - tempoInicio) / 1000) + " segundos");
	}
}

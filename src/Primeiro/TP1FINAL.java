package Primeiro;

import java.util.Scanner;
import java.util.Arrays;

public class TP1FINAL {
	static public String Tema[][] = new String[49][49];
	static Scanner ler = new Scanner(System.in);
	static public int coluna = 0, linha = 0;
	static public int indice = 0;
	static public int salva = 0;
	static public int salvaIndice = 0;
	static public int salvaPosicao = 0;

	public static void main(String[] args) {
		int opcao = 0;
		int opcaoTema = 0;
		int opcaoPalavra = 0;

		do {
			//receber opcao do menu principal
			opcao = Menu(opcao);

			switch (opcao) {
				case 1:
					System.out.println("Gerenciar TEMAS!\n");
					System.out.println("\n");

					// menu temas
					opcaoTema = Menu_tema(opcaoTema);
					GerenciamentoTemas(opcaoTema);

					break;
				case 2:
					System.out.println("Gerenciar PALAVRAS!\n");
					System.out.println("\n");

					// menu palavras
					opcaoPalavra = Menu_palavra(opcaoPalavra);
					GerenciamentoPalavras(opcaoPalavra);

					break;
				case 3:
					System.out.println("JOGAR!\n");
					System.out.println("\n");

					// menu jogar
					jogar();

					break;
				case 4:
					System.out.println(". .................. .!\n");
					System.out.println(". .......Saindo..... .!\n");
					System.out.println(". .................. .!\n");
					System.out.println("\n");
					break;
				default:
					System.out.println("Opção não encontrada!\n");
					System.out.println("\n");
					break;
			}
		} while (opcao != 4);
	}

	// MENUS
	public static int Menu(int opcao) {

		System.out.println("-------Jogo da forca-------\n");
		System.out.println("1. Gerenciar Temas\n");
		System.out.println("2. Gerenciar Palavras\n");
		System.out.println("3. Jogar\n");
		System.out.println("4. Sair\n");
		System.out.println("---------------------------\n");
		opcao = ler.nextInt();

		return opcao;
	}

	public static int Menu_tema(int opcaoTema) {
		System.out.println("-------Gerenciar Temas-------\n");
		System.out.println("1. Cadastrar Temas\n");
		System.out.println("2. Excluir Temas\n");
		System.out.println("3. Buscar Temas\n");
		System.out.println("-----------------------------\n");
		opcaoTema = ler.nextInt();

		return opcaoTema;
	}

	public static int Menu_palavra(int opcaoPalavra) {
		System.out.println("-------Gerenciar Palavras-------\n");
		System.out.println("1. Cadastrar Palavra\n");
		System.out.println("2. Excluir Palavra\n");
		System.out.println("3. Buscar Palavra\n");
		System.out.println("4. Listagem de Palavras\n");
		System.out.println("--------------------------------\n");
		opcaoPalavra = ler.nextInt();

		return opcaoPalavra;
	}

	// Gerenciamento de temas
	// escolha
	public static void GerenciamentoTemas(int opcaoTema) {

		switch (opcaoTema) {

			case 1:
				System.out.println("\n1. Cadastro\n");
				cadatroTema();
				break;
			case 2:
				System.out.println("2. Excluindo\n");
				excluirTema();
				break;
			case 3:
				System.out.println("3. Busca!\n");
				buscaTema();
				break;
			default:
				System.out.println("Opcao não encontrada!\n");
				break;
		}
	}

	// cadastro
	public static void cadatroTema() {
		String newTema;
		boolean TemaIgual = false;

		System.out.println("----------Cadastrar TEMA-----------\n");
		newTema = ler.next();
		for (int d = 0; d < coluna; d++) {
			if (Tema[d][0].equals(newTema)) {
				TemaIgual = true;
			} else {
				TemaIgual = false;
			}
		}

		if (TemaIgual) {
			System.out.println("TEMA Invalido");
		} else {
			Tema[coluna][0] = newTema;
			coluna++;
		}
	}

	// excluir um tema
	public static void excluirTema() {
		String excluiTema;
		boolean TemaIgualEx = false;

		System.out.println("----------Excluir TEMA-----------\n");
		excluiTema = ler.next();

		for (int d = 0; d < coluna; d++) {
			if (Tema[d][0].equals(excluiTema)) {
				TemaIgualEx = true;
				Tema[d][0] = null;
				CorrigirPosicoes();
			}
		}
		if (!TemaIgualEx) {
			System.out.println("Tema NÃO encontrado\n");
		}
	}

	// corrigir posicoes no vetor
	public static void CorrigirPosicoes() {
		String[][] TemaCorrigido = new String[49][49];
		int corrigir = 0;

		for (int d = 0; d < Tema.length; d++) {
			if (Tema[d][0] != null && !Tema[d][0].isBlank() && !Tema[d][0].isEmpty()) {
				TemaCorrigido[corrigir][0] = Tema[d][0];
				corrigir++;
			}
		}
		coluna = corrigir;
		Tema = TemaCorrigido;
	}

	// busca
	public static void buscaTema() {
		String buscaTema;
		boolean TemaIgual = false;

		System.out.println("----------Buscar TEMA-----------\n");
		buscaTema = ler.next();
		for (int d = 0; d < coluna; d++) {
			if (Tema[d][0].equals(buscaTema)) {
				TemaIgual = true;
				System.out.println("Tema encontrado: " + Tema[d][0] + "\n");
			}
		}
		if (!TemaIgual) {
			System.out.println("Tema NÃO encontrado\n");
		}

	}

	// Gerenciamento de palavras
	// escolha
	public static void GerenciamentoPalavras(int opcaoPalavra) {
		switch (opcaoPalavra) {

			case 1:
				System.out.println("\n1. Cadastro\n");
				cadastroPalavra();
				break;
			case 2:
				System.out.println("2. Excluindo\n");
				excluirPalavra();
				break;
			case 3:
				System.out.println("3. Busca!\n");
				buscaPalavra();
				break;
			case 4:
				System.out.println("4. Listagem!");
				Listagem();
				break;
			default:
				System.out.println("Opcao não encontrada!\n");
				break;
		}
	}

	// cadastro de palavras
	public static void cadastroPalavra() {
		String TemaP;
		boolean TemaExiste = false;

		System.out.println("----------Cadastrar Palavra-----------\n");

		// mostrar os temas que existem e os indices
		for (int c = 0; c < coluna; c++) {
			System.out.println(Tema[c][0] + "\n");
		}

		System.out.println("Em qual Tema deseja cadastrar a palavra: \n");
		TemaP = ler.next();

		for (int d = 0; d < coluna; d++) {
			if (Tema[d][0].equals(TemaP)) {
				System.out.print("Tema existente\n");
				TemaExiste = true;
				salva++;
				salvaIndice = indice;

				if (d != salvaIndice) {
					salva = 1;
				}
				indice = d;

				CadastroP(indice);
				linha++;
				break;
			}
		}

		if (!TemaExiste) {
			System.out.print("Tema NÃO existente\n");
		}

	}

	// cadastrar palavra
	public static void CadastroP(int indices) {
		String newPalavra;
		boolean igualPalavra = false;

		System.out.println("\nDigite a palavra: \n");
		newPalavra = ler.next();
		igualPalavra = VerificarPalavra(newPalavra, indice, igualPalavra);

		salvaPosicao = Tema.length;
		if (!igualPalavra) {
			for (int a = 1; a <= salvaPosicao; a++) {
				if (Tema[indice][a] == null) {
					salvaPosicao = -(a) * (-1);
					Tema[indices][salvaPosicao] = newPalavra;
				}
			}
		}
	}

	// verificar palavras
	public static boolean VerificarPalavra(String newPalavra, int indice, boolean igualPalavra) {
		for (int a = 1; a <= salva; a++) {
			if (Tema[indice][a] == null) {
				igualPalavra = false;
				return igualPalavra = false;
			} else if (Tema[indice][a].equals(newPalavra)) {
				System.out.println("Palavra invalida! Essa palavra ja esta cadastrada!\n");
				return igualPalavra = true;
			}
		}
		return igualPalavra = false;
	}

	// buscar por palavra em um tema
	public static void buscaPalavra() {
		String TemaB;
		boolean palavraExiste = false;
		int indice1=0;

		System.out.println("----------Buscar Palavra-----------\n");
		System.out.println("Qual palavra deseja buscar? \n");
		TemaB = ler.next();

		for (int a = 0; a < coluna; a++) {
			for (int d = 1; d <= linha; d++) {
				if (Tema[a][d] !=null && Tema[a][d].equals(TemaB)) {
					indice1=a;
				 	palavraExiste=true;
					break;
				}
			}
		}

		//interagir com user
		if (!palavraExiste) {
			System.out.println("NÃO achei a palavra!\n");
		}
		else if(palavraExiste){
			System.out.println("A palavra: " + TemaB + " encontrada no TEMA: " + Tema[indice1][0]);
		}
	}



	//excluir palavra dentro de um tema
	public static void excluirPalavra() {
		String TemaE;
		
		boolean palavraExiste = false;
		int indiceTemaP = 0;
		int indicePalavra=0;

		// entrada de dado
		System.out.println("----------Excluir Palavra-----------\n");
		System.out.println("Qual palavra deseja buscar? \n");
		TemaE = ler.next();

		// verificacoes
		palavraExiste = VerificarPalavraE(palavraExiste, TemaE);

		// condicoes
		if (palavraExiste) {
			//excluir(TemaE, indiceTemaP);
			indiceTemaP = GetIndiceTema(TemaE, indiceTemaP);
			indicePalavra = GetIndicePalavra(TemaE, indicePalavra);
			removeElement(Tema, TemaE, indiceTemaP, indicePalavra);

			//OrganizarMatriz(indiceTemaP);
		} else if (!palavraExiste) {
			System.out.println("Palavra não existe!");
		}
	}

	public static void removeElement(String [][] Tema, String TemaE, int indiceTemaP, int indicePalavra){
		String[][] TemaCorrigido = new String[49][49];
		System.arraycopy(Tema,0,TemaCorrigido,0,indicePalavra);
		System.arraycopy(Tema[indiceTemaP],indicePalavra+1,TemaCorrigido[indiceTemaP],indicePalavra, 40);
		Tema = TemaCorrigido;
	}

	// verificar se a palavra existe
	public static boolean VerificarPalavraE(boolean palavraExiste, String TemaE) {
		for (int a = 0; a < coluna; a++) {
			for (int d = 1; d <= linha; d++) {
				if (Tema[a][d] != null) {
					if (Tema[a][d].equals(TemaE)) {
						System.out.println("Palavra Existente! Excluindo...");
						return palavraExiste = true;
					}
				}
			}
		}
		return palavraExiste = false;
	}

	//Pegar o indice do tema
	public static int GetIndiceTema(String TemaE, int indiceTemaP) {
		for (int a = 0; a < coluna; a++) {
			for (int d = 1; d <= linha; d++) {
				if (Tema[a][d] != null) {
					if (Tema[a][d].equals(TemaE)) {
						indiceTemaP=a;
						System.out.println("Palavra excluida!");
						return indiceTemaP;
					}
				}
			}
		}
		return indiceTemaP;
	}

	//pegar indice da palavra
	public static int GetIndicePalavra(String TemaE, int indicePalavra){
		for (int a = 0; a < coluna; a++) {
			for (int d = 1; d <= linha; d++) {
				if (Tema[a][d] != null) {
					if (Tema[a][d].equals(TemaE)) {
						indicePalavra=d;
						System.out.println("Palavra excluida!");
						return indicePalavra;
					}
				}
			}
		}
		return indicePalavra;
	}
	
	// listagem de palavras dentro de um tema
	public static void Listagem() {
		String TemaB;
		boolean TemaExiste = false;
		int parametro = 0;

		System.out.println("Qual TEMA deseja listar? \n");
		TemaB = ler.next();

		for (int d = 0; d < coluna; d++) {
			if (Tema[d][0].equals(TemaB)) {
				System.out.print("Tema existente\n");
				TemaExiste = true;
				parametro = d;
				break;
			}

		}
		if (!TemaExiste) {
			System.out.print("Tema NÃO existente\n");
		}

		// fazer a listagem
		if (TemaExiste) {
			System.out.println("Tema: " + Tema[parametro][0] + "\n");
			for (int a = 1; a <= salvaPosicao; a++) {
				if (Tema[parametro][a] != null) {
					System.out.println("palavra " + a + " - " + Tema[parametro][a]);
				}
			}
		}
	}

	//JOGAR
	public static void jogar() {
		String TemaB;

		int random;
		int indiceJogo = 0;
		int opcaoJogar = 0;
		int contadorNNull=0;
		String palavraJogada;

		do {
			// entrada do tema
			System.out.println("---------- JOGAR -----------\n");
			System.out.println("Qual TEMA deseja? \n");
			TemaB = ler.next();
			indiceJogo = VerificarTemaJ(indiceJogo, TemaB);


			//ver quantas palavras diferntes de null tem nesse vetor
			for(int d=1;d<48; d++){
				if(Tema[indiceJogo][d]!=null){
					contadorNNull++;
				}
			}

			// randomizar palavra escolhida e guardar o valor
			random = 1 + (int) (Math.random() * contadorNNull);
			palavraJogada = Tema[indiceJogo][random];

			// fazer toda a parte de jogar e finalizar tudo!
			jogando(palavraJogada);

			//verificar se o usuario quer continuar jogando
			continuarJogando(opcaoJogar);

		} while (opcaoJogar != 2);
	}

	// verificar existencia do tema
	public static int VerificarTemaJ(int indiceJogo, String TemaB) {
		boolean TemaIgual = false;

		for (int d = 0; d < coluna; d++) {
			if (Tema[d][0].equals(TemaB)) {
				TemaIgual = true;
				indiceJogo = d;
				System.out.println("Tema encontrado: " + Tema[d][0] + "\n");
				return indiceJogo;
			}
		}
		if (!TemaIgual) {
			System.out.println("Tema NÃO encontrado\n");
		}
		return indiceJogo;
	}

	// Verificar se o usuario deseja continuar jogando

	public static int continuarJogando(int opcaoJogar) {

		System.out.println("Digite o numero da opção de escolha: \n");
		System.out.println("1.Sim \n");
		System.out.println("2.Nao \n");

		opcaoJogar = ler.nextInt();

		do {
			if (opcaoJogar == 1) {
				return opcaoJogar = 1;
			} else if (opcaoJogar == 2) {
				return opcaoJogar = 2;
			} else if (opcaoJogar != 1 && opcaoJogar != 2) {
				System.out.println("Opção não encontrada!!\n");
			}
		} while (opcaoJogar == 1 || opcaoJogar == 2);

		return opcaoJogar;
	}

	// jogo
	public static void jogando(String palavraJogada) {
		String letra, verificaLetra="";
		int erro = 0;
		int acerto = 0;

		// entrada da letra
		do {
			//verificar letra
			System.out.println("Qual letra voce deseja tentar? \n");
			letra = ler.next();

			if(letra != verificaLetra){
				//verificar se a letra esta na palavra
				for(int a=0; a<palavraJogada.length(); a++){
					if(palavraJogada.contains(letra)){
						System.out.println("SIM. Essa letra esta na palavra!");
						acerto++;
						break;
					}
					else if(!palavraJogada.contains(letra)){
						System.out.println("Essa letra NÂO esta na palavra!");
						erro++;
						break;
					}
				}
			}
			else if(letra == verificaLetra){
				//ter a entrada da letra ate o user acertar
				do{
					System.out.println("Tente outra letra! Esta ja foi inserida\n");
					letra = ler.next();	
					verificaLetra = letra;
				}while(letra == verificaLetra);

			}

			//salvar letra para proxima rodada
			verificaLetra = letra;

			//verificar se user ja perdeus as chances ou se ganhou
			if(erro==5){
				System.out.println("Você perdeu! Deseja Deseja jogar novamente?");
				break;
			}
			else if(acerto == palavraJogada.length()){
				System.out.println("Parabéns!Você acertou a palavra! Deseja jogar novamente?");
				break;
			}
		} while (erro != 5 || acerto != palavraJogada.length());
	}
}

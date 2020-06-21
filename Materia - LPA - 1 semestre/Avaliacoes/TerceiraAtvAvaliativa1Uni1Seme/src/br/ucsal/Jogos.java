package br.ucsal;

import java.util.Arrays;
import java.util.Scanner;



public class Jogos {

	public static void main(String[] args) {
		bemVindo();
		cadastroUsuario("", 0);




	}
	//MÉTODO DE BOAS VINDAS
	public static void bemVindo() {
		imprimir("Seja bem vindo ao LPA Games 1.0"
				+ "\nAntes de irmos para o menu, Faça o login"
				+ "\n==========================================\n");
	}

	//MÉTODO QUE CADASTRA OS USUÁRIOS:
	public static void cadastroUsuario(String user, int op) {
		Scanner imput = new Scanner(System.in);
		String[] usuario = new String[2];
		usuario[0] = user;
		if(usuario[0].equals("")) {
			imprimir("Insira o nome do usuario 1: \n");
			usuario[0] = imput.next().toUpperCase();
			validaUsuario(0);
			imprimir ("Usuario1: " + usuario[0] + " - Validado com sucesso" + "\n");
			imprimir("\n ==========================="
					+ "\n Seja bem vindo: " + usuario[0]);
			usuario[1] = "";
			menu(usuario, op);
		} else {
			imprimir("Insira o nome do usuario 2\n");
			usuario[1] = imput.next().toUpperCase();
			validaUsuario(111);
			imprimir ("Usuario2: " + usuario[1] + " - Validado com sucesso" + "\n"); 
			imprimir("\n ==========================="
					+ "\n Sejam bem vindos: " + usuario[0] + " e " + usuario[1]);
			menu(usuario, op);
		}
	}

	//MÉTODO QUE IMPRIME O MENU:
	public static void menu (String[] usuario, int op) {
		String user1 = usuario[0];
		String user2 = usuario[1];
		Scanner imput = new Scanner(System.in);
		int menu = op;
		if(menu == 0) {
			imprimir("\n ==========================="
					+ "\n Escolha qual jogo deseja jogar:"
					+ "\n [1] Jogo da forca"
					+ "\n [2] Batalha naval"
					+ "\n [3] Campo minado"
					+ "\n [4] Sair\n");
			menu = imput.nextInt();
		}

		switch(menu) {
		case 1:
			if(user2.equals("")) {
				imprimir("Este jogo requer 2 usuários\n");
				cadastroUsuario(usuario[0], menu);
			} else {

				imprimir("\n ==========================="
						+ "\nIniciando Jogo da forca...\n\n");
				inicioForca(user1, user2);
			}
			break;
		case 2:
			if(user2.equals("")) {
				imprimir("Este jogo requer 2 usuários\n");
				cadastroUsuario(usuario[0], menu);
			} else {

				imprimir("\n ==========================="
						+ "\nIniciando Batalha naval...");
				inicioBatalhaNaval();
			}
			break;
		case 3: 
			imprimir("\nIniciando Campo minado");
			break;
		case 4:
			imprimir("Jogo encerrado!");
			System.exit(0);
			break;
		default:
			imprimir("Você digitou uma opção inválida, Tente novamente: \n");

			break;
		}
	}

	// MÉTODO PARA VALIDAÇÃO DA SENHA DO USUARIO:
	public static void validaUsuario (int pass) {
		Scanner imput = new Scanner(System.in);
		int[] senha = new int[2];
		senha[0] = pass;


		if(senha[0] != 111) {
			imprimir("Insira a senha do Usuario 1"
					+ "                     'A senha para o usuario 1 é: 111' \n");
			senha[0] = imput.nextInt();
			while(senha[0] != 111) {
				imprimir("Você digitou a senha errada, Tente novamente: \n");
				senha[0] = imput.nextInt();	
			}
		} else { imprimir("Insira a senha do Usuario 2 "
				+ "                     'A senha para o usuario 2 é: 222' \n");
		senha[1] = imput.nextInt();
		while(senha[1] != 222) {
			imprimir("Você digitou a senha errada, Tente novamente: \n");
			senha[1] = imput.nextInt();


		}
		}

	}
	
    //INICIO JOGO DA FORCA
	

	
	
	public static int resultForca = 0;	
	public static void inicioForca(String user1, String user2) {
		int scorep1 = 0, scorep2 = 0;
		int forcaGame = 0;
		
		imprimir("Bem vindo ao jogo da forca. "
				+ "\nVocê terá 6 tentativas para adivinhar a palavra dita pelo seu oponente\n"
				+ "\nquem obtiver menos erros ganha! \n");
		for (int i = 0; i < 1; i++) {
			
		
		if(forcaGame == 0) { //VERIFICA SE É A PRIMEIRA OU SEGUNDA PARTIDA
			
			forca(user1, user2);
			scorep2 = resultForca;
			forcaGame = 1;
		}
		if(forcaGame == 1) {
			
			forca(user2, user1);
			scorep1 = resultForca;
		}
		}
		if(scorep1 < scorep2) { //IMPRIME O RESULTADO DA PARTIDA
			imprimir(user1 + " ganhou de " + user2 + " com  " + scorep1 + " erros, contra " + scorep2 + " do jogador " + user2 );
		} else if (scorep1 > scorep2) {
			imprimir(user2 + " ganhou de " + user1 + " com  " + scorep2 + " erros, contra " + scorep1 + " do jogador " + user1 );
		} else if (scorep1 == scorep2) {
			imprimir("O jogo empatou");
		}
		
	}
	
	public static void forca(String player1, String player2) { //METODO DE EXECUÇÃO DO JOGO
		Scanner imput = new Scanner(System.in);
		imprimir("\nAgora é a vez de " + player1 + " digitar uma palavra para " + player2 + " adivinhar");
		imprimir("\nDigite a palavra: ");
		String palavra = imput.next().toUpperCase();
		
		
		imprimir("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		forcaEnforcado(0, palavra);
		resultForca = 0;
		imprimir("\n");
		String[] palavraTemp = new String[palavra.length()];
		String[] palavraTemp2 = palavra.split("");
		for (int i = 0; i < palavra.length(); i++) {
			imprimir("-");
			palavraTemp[i] = "-";
			
		}
		
		imprimir("\n");
		
		int sair = 0;
		for (int i = 0; sair < 6; i++) {
			imprimir("\n" + player2 + " Digite uma letra: \n");
			String letra = imput.next().toUpperCase();
			
			
			
			for (int j = 0; j < palavra.length(); j++) {
				
				if(letra.charAt(0) == palavra.charAt(j)) {
					imprimir(letra);
					palavraTemp[j] = letra;
				} else { 
					if(palavraTemp[j] != "-") {
						imprimir(palavraTemp[j]);
					} else {
					imprimir("-");
					
					
					
					}
				}
				if(Arrays.equals(palavraTemp, palavraTemp2)) {
					sair = 6;
					
				}
			}
			for (int j = 0, a = 0, b = 0; j < palavra.length(); j++) {
				if(letra.charAt(0) != palavra.charAt(j)) {
					a++;
				} else { 
					b++;
				}
				if(a == palavra.length()) {
					resultForca++;
					sair++;
					forcaEnforcado(resultForca, palavra);
				} else if (j == palavra.length()-1 && b>0 ) { 
					imprimir("\nParabens, você acertou a letra\n");
					if(Arrays.equals(palavraTemp, palavraTemp2)) {
						imprimir("\nParabens, você acertou a palavra completa\n");
						
					}
				}
			}
		}
	}
	
		

	public static void forcaEnforcado(int contador, String palavra) { //MÉTODO QUE IMPRIME A FORCA
		if (contador == 0) {
			System.out.println("");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           ");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 1) {
			System.out.println("\nVocê errou, Tente novamente");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 2) {
			System.out.println("\nVocê errou, Tente novamente");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 3) {
			System.out.println("\nVocê errou, Tente novamente");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |          /|");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 4) {
			System.out.println("\nVocê errou, Tente novamente");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |          /|\\");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 5) {
			System.out.println("\nVocê errou, Tente novamente");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |          /|\\");
			System.out.println("   |          /   ");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (contador == 6) {
			System.out.println("\nVocê errou pela ultima vez");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |           O");
			System.out.println("   |          /|\\");
			System.out.println("   |          / \\");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
			System.out.println("Fim de jogo, a palavra era " + palavra);
		}

	} // FIM DO JOGO DA FORCA

	public static int linhas = 11;
	public static int colunas = 11;
	public static String[][] tabJogo1 = new String[linhas][colunas];
	public static String[][] tabJogo2 = new String[linhas][colunas];
	public static String[][] tabJogoOculto1 = new String[linhas][colunas];
	public static String[][] tabJogoOculto2 = new String[linhas][colunas];
	
	public static void inicioBatalhaNaval() {

		tutorial(); // Vai mostrar a introdução + um simples tutorial do jogo (objetivo, como ganhar, etc.)
		criarTabuleiro1();		
		intrucoesPosicionamento();
		posicaoNaviosJog1();
		intrucoesPosicionamento();
		criarTabuleiro2();
		posicaoNaviosJog2();
		contadorPontos();
		
	}

	public static void tutorial() {
		System.out.println("[ B A T A L H A  N A V A L ]");
		System.out.println("");
		System.out.println(">> Bem-vindo ao jogo 'Batalha Naval', Almirante!");
		System.out.println(">> Nesse jogo, o seu objetivo é descobrir onde estão os navios inimigos e afundá-los.");
		System.out.println(">> Os navios (ambos seus e do inimigo) se encontraram num tabuleiro 10 x 10.");
		System.out.println(">> Quem conseguir afundar TODOS os 4 navios primeiro será o vencedor.");
		System.out.println(">> Você será guiado a distribuir o seus navios em alguns instantes.");
		System.out.println(">> Boa sorte!");
		System.out.println("__________________________________________________________");

	}

	public static void intrucoesPosicionamento() {

		System.out.println("\nNós iremos agora começar a fase de posicionamento dos navios.");
		System.out.println("\nLeia com ATENÇÃO as regras abaixo:");
		System.out.println("- Existem 4 navios a serem distribuidos pelo tabuleiro.");
		System.out.println("- Os navios devem estar conectados e em linha reta (horizontal ou vertical);");
		System.out.println("- Todos os segmentos do navio devem estar dentro do tabuleiro.");
		System.out.println("- Para determinar a posição, será pedido primeiramente a COLUNA e depois a LINHA.");
		System.out.println("\nOs navios e seus comprimentos são:");
		System.out.println( "  * Porta aviões --------- 5 segmentos;\r\n" + 
				"  * Navios-tanque -------- 4 segmentos;\r\n" + 
				"  * Contratorpedeiros ---- 3 segmentos;\r\n" + 
				"  * Submarinos ----------- 2 segmentos;");

		System.out.println("\n[AVISO] Uma vez posicionado, o navio NÃO PODE ser removido do tabuleiro. Escolha com cuidado a posição.");
	}

	public static void posicaoNaviosJog1() {
		
		System.out.println("\n >>> JOGADOR 1# <<<");
		posicaoSubJog1();
		posicaoCTJog1();
		posicaoNTJog1();
		posicaoPAJog1();
		
	}

	public static void posicaoSubJog1() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\nO primeiro navio será o SUBMARINO.");

		do {			
			System.out.print("Por favor, escolha onde o primeiro segmento do 'SUBMARINO' deverá ficar [COLUNA]: ");
			x = userInput.nextInt();
			System.out.print("Por favor, escolha onde o primeiro segmento do 'SUBMARINO' deverá ficar [LINHA]: ");
			y = userInput.nextInt();

			if (x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2)) {
				System.out.println("\nPosição fora do tabuleiro. Tente novamente.");
				System.out.println("");
			}

		} while(x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2));

		tabJogo1[x][y] = "O";		

		do {
		System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
		vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
		} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

		switch (vertOuHoriz) {
		case "H":
			
			do {
			System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
			dirOuEsq = userInput.next().toUpperCase().substring(0, 1);
			} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));

			switch (dirOuEsq) {
			case "D":  
					tabJogo1[x][(y + 1)] = "O";
				break;

			case "E":
					tabJogo1[x][(y - 1)] = "O";
				break;

			default:
				System.out.println("Letra digitada não corresponde a uma opção.");
				break;
			}
			break;

		case "V":
			
			do {
			System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
			cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
			} while (!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

			switch (cimaOuBaixo) {
			case "C":	
					tabJogo1[(x - 1)][y] = "O";
				break;
				
			case "B":
					tabJogo1[(x + 1)][y] = "O";
				break;

			default:				
				break;
			}
			break;

		default:			
			break;
		}		

		imprimirTabuleiro1();

	}

	public static void posicaoCTJog1() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\n O segundo navio será o CONTRATORPEDEIRO.");

		do {
			do {		
				System.out.print("Por favor, escolha onde o primeiro segmento do 'CONTRATORPEDEIRO' deverá ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'CONTRATORPEDEIRO' deverá ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2)) {
					System.out.println("\nPosição fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2));

			if (tabJogo1[x][y] == "O") {
				System.out.println("\nPosição já possui uma peça. Tente novamente.");
				System.out.println("");
			}
		} while(tabJogo1[x][y] == "O");

		tabJogo1[x][y] = "O";
			
			do {
				System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
				vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
			} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

			switch (vertOuHoriz) {
			case "H":				
				do {					
					do {
						System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
						dirOuEsq = userInput.next().toUpperCase().substring(0, 1);	
					} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));	

					switch (dirOuEsq) {
					case "D":
						if (tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~") {
							tabJogo1[x][(y + 1)] = "O";
							tabJogo1[x][(y + 2)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "E":
						if (tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~") {
							tabJogo1[x][(y - 1)] = "O";
							tabJogo1[x][(y - 2)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;					
					}
					
				} while ((tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~") || (tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~"));

				break;
				
			case "V":
				do {					
					do {
						System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
						cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
					} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

					switch (cimaOuBaixo) {
					case "C":
						if (tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~") {
							tabJogo1[(x - 1)][y] = "O";
							tabJogo1[(x - 2)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "B":
						if (tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~") {
							tabJogo1[(x + 1)][y] = "O";
							tabJogo1[(x + 2)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;
					}
					break;

				} while ((tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~") || (tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~"));
				
				break;
			}
		
		imprimirTabuleiro1();
	}

	public static void posicaoNTJog1() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\n O segundo navio será o 'NAVIO-TANQUE'.");

		do {
			do {		
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' deverá ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' deverá ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2)) {
					System.out.println("\nPosição fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2));

			if (tabJogo1[x][y] == "O") {
				System.out.println("\nPosição já possui uma peça. Tente novamente.");
				System.out.println("");
			}
		} while(tabJogo1[x][y] == "O");

		tabJogo1[x][y] = "O";
			
			do {
				System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
				vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
			} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

			switch (vertOuHoriz) {
			case "H":				
				do {					
					do {
						System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
						dirOuEsq = userInput.next().toUpperCase().substring(0, 1);	
					} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));	

					switch (dirOuEsq) {
					case "D":
						if (tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~" && tabJogo1[x][(y + 3)] == "~") {
							tabJogo1[x][(y + 1)] = "O";
							tabJogo1[x][(y + 2)] = "O";
							tabJogo1[x][(y + 3)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "E":
						if (tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~" && tabJogo1[x][(y - 3)] == "~") {
							tabJogo1[x][(y - 1)] = "O";
							tabJogo1[x][(y - 2)] = "O";
							tabJogo1[x][(y - 3)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;					
					}
					
				} while ((tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~" && tabJogo1[x][(y - 3)] == "~") || (tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~" && tabJogo1[x][(y + 3)] == "~"));

				break;
				
			case "V":
				do {					
					do {
						System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
						cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
					} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

					switch (cimaOuBaixo) {
					case "C":
						if (tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~"  && tabJogo1[(x - 3)][y] == "~") {
							tabJogo1[(x - 1)][y] = "O";
							tabJogo1[(x - 2)][y] = "O";
							tabJogo1[(x - 3)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "B":
						if (tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~" && tabJogo1[(x + 3)][y] == "~") {
							tabJogo1[(x + 1)][y] = "O";
							tabJogo1[(x + 2)][y] = "O";
							tabJogo1[(x + 3)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;
					}
					break;

				} while ((tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~" && tabJogo1[(x - 3)][y] == "~") || (tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~" && tabJogo1[(x + 3)][y] == "~"));
				
				break;
			}
		
		imprimirTabuleiro1();
	}

	public static void posicaoPAJog1() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\n O segundo navio será o 'NAVIO-TANQUE'.");

		do {
			do {		
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' deverá ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' deverá ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2)) {
					System.out.println("\nPosição fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo1.length - 2) || y > (tabJogo1.length - 2));

			if (tabJogo1[x][y] == "O") {
				System.out.println("\nPosição já possui uma peça. Tente novamente.");
				System.out.println("");
			}
		} while(tabJogo1[x][y] == "O");

		tabJogo1[x][y] = "O";
			
			do {
				System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
				vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
			} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

			switch (vertOuHoriz) {
			case "H":				
				do {					
					do {
						System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
						dirOuEsq = userInput.next().toUpperCase().substring(0, 1);	
					} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));	

					switch (dirOuEsq) {
					case "D":
						if (tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~" && tabJogo1[x][(y + 3)] == "~"  && tabJogo1[x][(y + 4)] == "~") {
							tabJogo1[x][(y + 1)] = "O";
							tabJogo1[x][(y + 2)] = "O";
							tabJogo1[x][(y + 3)] = "O";
							tabJogo1[x][(y + 4)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "E":
						if (tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~" && tabJogo1[x][(y - 3)] == "~" && tabJogo1[x][(y - 4)] == "~") {
							tabJogo1[x][(y - 1)] = "O";
							tabJogo1[x][(y - 2)] = "O";
							tabJogo1[x][(y - 3)] = "O";
							tabJogo1[x][(y - 4)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;					
					}
					
				} while ((tabJogo1[x][(y - 1)] == "~" && tabJogo1[x][(y - 2)] == "~" && tabJogo1[x][(y - 3)] == "~" && tabJogo1[x][(y - 4)] == "~") || 
						 (tabJogo1[x][(y + 1)] == "~" && tabJogo1[x][(y + 2)] == "~" && tabJogo1[x][(y + 3)] == "~" && tabJogo1[x][(y + 4)] == "~"));

				break;
				
			case "V":
				do {					
					do {
						System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
						cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
					} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

					switch (cimaOuBaixo) {
					case "C":
						if (tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~" && tabJogo1[(x - 3)][y] == "~" && tabJogo1[(x - 4)][y] == "~") {
							tabJogo1[(x - 1)][y] = "O";
							tabJogo1[(x - 2)][y] = "O";
							tabJogo1[(x - 3)][y] = "O";
							tabJogo1[(x - 4)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "B":
						if (tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~" && tabJogo1[(x + 3)][y] == "~"  && tabJogo1[(x + 4)][y] == "~") {
							tabJogo1[(x + 1)][y] = "O";
							tabJogo1[(x + 2)][y] = "O";
							tabJogo1[(x + 3)][y] = "O";
							tabJogo1[(x + 4)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;
					}
					break;

				} while ((tabJogo1[(x - 1)][y] == "~" && tabJogo1[(x - 2)][y] == "~" && tabJogo1[(x - 3)][y] == "~" && tabJogo1[(x - 4)][y] == "~") || 
						 (tabJogo1[(x + 1)][y] == "~" && tabJogo1[(x + 2)][y] == "~" && tabJogo1[(x + 3)][y] == "~" && tabJogo1[(x + 4)][y] == "~"));
				
				break;
			}
		
		imprimirTabuleiro1();
	}

	public static void criarTabuleiro1() {
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogo1.length; x++) {
			for (int y = 0; y < tabJogo1[x].length; y++) {
				if(y < 10) {
					tabJogo1[x][y] = "~";
					System.out.print("|  " + tabJogo1[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| N | = Quadrado sem nada.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}
	
	public static void imprimirTabuleiro1() {
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogo1.length; x++) {
			for (int y = 0; y < tabJogo1[x].length; y++) {
				if(y < 10) {					
					System.out.print("|  " + tabJogo1[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| N | = Quadrado sem nada.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}
	
	public static void posicaoNaviosJog2() {
		
		System.out.println("\n >>> JOGADOR 2# <<<");		
		posicaoSubJog2();
		posicaoCTJog2();
		posicaoNTJog2();
		posicaoPAJog2();

	}

	public static void posicaoSubJog2() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\nO primeiro navio será o SUBMARINO.");

		do {			
			System.out.print("Por favor, escolha onde o primeiro segmento do 'SUBMARINO' deverá ficar [COLUNA]: ");
			x = userInput.nextInt();
			System.out.print("Por favor, escolha onde o primeiro segmento do 'SUBMARINO' deverá ficar [LINHA]: ");
			y = userInput.nextInt();

			if (x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2)) {
				System.out.println("\nPosição fora do tabuleiro. Tente novamente.");
				System.out.println("");
			}

		} while(x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2));

		tabJogo2[x][y] = "O";
		
		do {
		System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
		vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
		} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

		switch (vertOuHoriz) {
		case "H":
			
			do {
			System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
			dirOuEsq = userInput.next().toUpperCase().substring(0, 1);
			} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));

			switch (dirOuEsq) {
			case "D":  
					tabJogo2[x][(y + 1)] = "O";
				break;

			case "E":
					tabJogo2[x][(y - 1)] = "O";
				break;

			default:
				System.out.println("Letra digitada não corresponde a uma opção.");
				break;
			}
			break;

		case "V":
			
			do {
			System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
			cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
			} while (!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

			switch (cimaOuBaixo) {
			case "C":	
					tabJogo2[(x - 1)][y] = "O";
				break;
				
			case "B":
					tabJogo2[(x + 1)][y] = "O";
				break;

			default:				
				break;
			}
			break;

		default:			
			break;
		}		

		imprimirTabuleiro2();

	}

	public static void posicaoCTJog2() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\n O segundo navio será o CONTRATORPEDEIRO.");

		do {
			do {		
				System.out.print("Por favor, escolha onde o primeiro segmento do 'CONTRATORPEDEIRO' deverá ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'CONTRATORPEDEIRO' deverá ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2)) {
					System.out.println("\nPosição fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2));

			if (tabJogo2[x][y] == "O") {
				System.out.println("\nPosição já possui uma peça. Tente novamente.");
				System.out.println("");
			}
		} while(tabJogo2[x][y] == "O");

		tabJogo2[x][y] = "O";
			
			do {
				System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
				vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
			} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

			switch (vertOuHoriz) {
			case "H":				
				do {					
					do {
						System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
						dirOuEsq = userInput.next().toUpperCase().substring(0, 1);	
					} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));	

					switch (dirOuEsq) {
					case "D":
						if (tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~") {
							tabJogo2[x][(y + 1)] = "O";
							tabJogo2[x][(y + 2)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "E":
						if (tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~") {
							tabJogo2[x][(y - 1)] = "O";
							tabJogo2[x][(y - 2)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;					
					}
					
				} while ((tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~") || (tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~"));

				break;
				
			case "V":
				do {					
					do {
						System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
						cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
					} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

					switch (cimaOuBaixo) {
					case "C":
						if (tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~") {
							tabJogo2[(x - 1)][y] = "O";
							tabJogo2[(x - 2)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "B":
						if (tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~") {
							tabJogo2[(x + 1)][y] = "O";
							tabJogo2[(x + 2)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;
					}
					break;

				} while ((tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~") || (tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~"));
				
				break;
			}
		
		imprimirTabuleiro2();
	}

	public static void posicaoNTJog2() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\n O segundo navio será o 'NAVIO-TANQUE'.");

		do {
			do {		
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' deverá ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' deverá ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2)) {
					System.out.println("\nPosição fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2));

			if (tabJogo2[x][y] == "S" || tabJogo2[x][y] == "C") {
				System.out.println("\nPosição já possui uma peça. Tente novamente.");
				System.out.println("");
			}
		} while(tabJogo2[x][y] == "O");

		tabJogo2[x][y] = "O";
			
			do {
				System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
				vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
			} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

			switch (vertOuHoriz) {
			case "H":				
				do {					
					do {
						System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
						dirOuEsq = userInput.next().toUpperCase().substring(0, 1);	
					} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));	

					switch (dirOuEsq) {
					case "D":
						if (tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~" && tabJogo2[x][(y + 3)] == "~") {
							tabJogo2[x][(y + 1)] = "O";
							tabJogo2[x][(y + 2)] = "O";
							tabJogo2[x][(y + 3)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "E":
						if (tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~" && tabJogo2[x][(y - 3)] == "~") {
							tabJogo2[x][(y - 1)] = "O";
							tabJogo2[x][(y - 2)] = "O";
							tabJogo2[x][(y - 3)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;					
					}
					
				} while ((tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~" && tabJogo2[x][(y - 3)] == "~") || (tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~" && tabJogo2[x][(y + 3)] == "~"));

				break;
				
			case "V":
				do {					
					do {
						System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
						cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
					} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

					switch (cimaOuBaixo) {
					case "C":
						if (tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~"  && tabJogo2[(x - 3)][y] == "~") {
							tabJogo2[(x - 1)][y] = "O";
							tabJogo2[(x - 2)][y] = "O";
							tabJogo2[(x - 3)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "B":
						if (tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~" && tabJogo2[(x + 3)][y] == "~") {
							tabJogo2[(x + 1)][y] = "O";
							tabJogo2[(x + 2)][y] = "O";
							tabJogo2[(x + 3)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;
					}
					break;

				} while ((tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~" && tabJogo2[(x - 3)][y] == "~") || (tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~" && tabJogo2[(x + 3)][y] == "~"));
				
				break;
			}
		
		imprimirTabuleiro2();
	}

	public static void posicaoPAJog2() {
		String vertOuHoriz = "", dirOuEsq = "", cimaOuBaixo = "";
		int x, y;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\n O segundo navio será o 'NAVIO-TANQUE'.");

		do {
			do {		
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' deverá ficar [COLUNA]: ");
				x = userInput.nextInt();
				System.out.print("Por favor, escolha onde o primeiro segmento do 'NAVIO-TANQUE' deverá ficar [LINHA]: ");
				y = userInput.nextInt();

				if (x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2)) {
					System.out.println("\nPosição fora do tabuleiro. Tente novamente.");
					System.out.println("");
				}

			} while(x > (tabJogo2.length - 2) || y > (tabJogo2.length - 2));

			if (tabJogo2[x][y] == "S" || tabJogo2[x][y] == "C" || tabJogo2[x][y] == "T") {
				System.out.println("\nPosição já possui uma peça. Tente novamente.");
				System.out.println("");
			}
		} while(tabJogo2[x][y] == "O");

		tabJogo2[x][y] = "O";
			
			do {
				System.out.print("\nDeseja colocar esse navio na vertical (V) ou horizontal (H)? ");
				vertOuHoriz = userInput.next().toUpperCase().substring(0, 1);
			} while (!vertOuHoriz.equals("V") && !vertOuHoriz.equals("H"));

			switch (vertOuHoriz) {
			case "H":				
				do {					
					do {
						System.out.print("\nDeseja colocar na direita (D) ou esquerda (E) da coordenada escolhida? ");
						dirOuEsq = userInput.next().toUpperCase().substring(0, 1);	
					} while (!dirOuEsq.equals("D") && !dirOuEsq.equals("E"));	

					switch (dirOuEsq) {
					case "D":
						if (tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~" && tabJogo2[x][(y + 3)] == "~"  && tabJogo2[x][(y + 4)] == "~") {
							tabJogo2[x][(y + 1)] = "O";
							tabJogo2[x][(y + 2)] = "O";
							tabJogo2[x][(y + 3)] = "O";
							tabJogo2[x][(y + 4)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "E":
						if (tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~" && tabJogo2[x][(y - 3)] == "~" && tabJogo2[x][(y - 4)] == "~") {
							tabJogo2[x][(y - 1)] = "O";
							tabJogo2[x][(y - 2)] = "O";
							tabJogo2[x][(y - 3)] = "O";
							tabJogo2[x][(y - 4)] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;					
					}
					
				} while ((tabJogo2[x][(y - 1)] == "~" && tabJogo2[x][(y - 2)] == "~" && tabJogo2[x][(y - 3)] == "~" && tabJogo2[x][(y - 4)] == "~") || 
						 (tabJogo2[x][(y + 1)] == "~" && tabJogo2[x][(y + 2)] == "~" && tabJogo2[x][(y + 3)] == "~" && tabJogo2[x][(y + 4)] == "~"));

				break;
				
			case "V":
				do {					
					do {
						System.out.print("\nDeseja colocar para cima (C) ou para baixo (B) da coordenada escolhida? ");
						cimaOuBaixo = userInput.next().toUpperCase().substring(0, 1);
					} while(!cimaOuBaixo.equals("C") && !cimaOuBaixo.equals("B"));

					switch (cimaOuBaixo) {
					case "C":
						if (tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~" && tabJogo2[(x - 3)][y] == "~" && tabJogo2[(x - 4)][y] == "~") {
							tabJogo2[(x - 1)][y] = "O";
							tabJogo2[(x - 2)][y] = "O";
							tabJogo2[(x - 3)][y] = "O";
							tabJogo2[(x - 4)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;

					case "B":
						if (tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~" && tabJogo2[(x + 3)][y] == "~"  && tabJogo2[(x + 4)][y] == "~") {
							tabJogo2[(x + 1)][y] = "O";
							tabJogo2[(x + 2)][y] = "O";
							tabJogo2[(x + 3)][y] = "O";
							tabJogo2[(x + 4)][y] = "O";
						} else {
							System.out.println("\n[ERRO] Existe um navio em uma das coordenadas a serem preenchidas. Tente novamente.");
						}
						break;
					}
					break;

				} while ((tabJogo2[(x - 1)][y] == "~" && tabJogo2[(x - 2)][y] == "~" && tabJogo2[(x - 3)][y] == "~" && tabJogo2[(x - 4)][y] == "~") || 
						 (tabJogo2[(x + 1)][y] == "~" && tabJogo2[(x + 2)][y] == "~" && tabJogo2[(x + 3)][y] == "~" && tabJogo2[(x + 4)][y] == "~"));
				
				break;
			}
		
		imprimirTabuleiro2();
	}

	public static void criarTabuleiro2() {
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogo2.length; x++) {
			for (int y = 0; y < tabJogo2[x].length; y++) {
				if(y < 10) {	
					tabJogo2[x][y] = "~";
					System.out.print("|  " + tabJogo2[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| N | = Quadrado sem nada.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}
	
	public static void imprimirTabuleiro2() {
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogo2.length; x++) {
			for (int y = 0; y < tabJogo2[x].length; y++) {
				if(y < 10) {			
					System.out.print("|  " + tabJogo2[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| N | = Quadrado sem nada.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}

	public static void criarTabuleiroOculto2() {
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogoOculto2.length; x++) {
			for (int y = 0; y < tabJogoOculto2[x].length; y++) {
				if(y < 10) {
					tabJogoOculto2[x][y] = "ssss";
					System.out.print("|  " + tabJogoOculto2[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}
			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}
	
	public static void imprimirTabuleiroOculto2() {
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogoOculto2.length; x++) {
			for (int y = 0; y < tabJogoOculto2[x].length; y++) {
				if(y < 10) {					
					System.out.print("|  " + tabJogoOculto2[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}
	
	public static void criarTabuleiroOculto1() {
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogoOculto1.length; x++) {
			for (int y = 0; y < tabJogoOculto1[x].length; y++) {
				if(y < 10) {
					tabJogoOculto1[x][y] = "ssss";
					System.out.print("|  " + tabJogoOculto1[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}
			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}
	
	public static void imprimirTabuleiroOculto1() {
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("| [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | ### |");
		System.out.println("-------------------------------------------------------------------");
		for (int x = 0; x < tabJogoOculto1.length; x++) {
			for (int y = 0; y < tabJogoOculto1[x].length; y++) {
				if(y < 10) {					
					System.out.print("|  " + tabJogoOculto1[x][y] + "  ");
				} else {
					if (x < 10) {
						System.out.print("| ["+ x + "] |");
					} else {
						System.out.print("| ["+ x + "]|");
					}
				}

			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
		}

		System.out.println("\nLEGENDA:");
		System.out.println("| ~ | = Quadrado intocado.");
		System.out.println("| O | = Quadrado com navio (do jogador).");
		System.out.println("| @ | = Quadrado com navio atingido.");
		System.out.println("__________________________________________________________");

	}
	
	public static void contadorPontos() {
		int contadorPontosMaximosP1 = 0, contadorPontosMaximosP2 = 0;
		Scanner userInput = new Scanner(System.in);

		for (int contadorTurnos = 1; (contadorPontosMaximosP1 < 14) || (contadorPontosMaximosP2 < 14); ) {
			while (contadorPontosMaximosP1 < 14 && contadorPontosMaximosP2 < 14) {
				if (contadorTurnos % 2 != 0) {					
					int x, y;

					System.out.println("\n >>> JOGADOR 1# <<<");					
					System.out.println("\nTurno: " + contadorTurnos);
					
					do {
						System.out.print("\nPor favor, escolha uma COLUNA (número entre 0 e 9) para atacar: ");		
						x = userInput.nextInt();

						if (x < 0 && x >= 10) {
							System.out.println("\n[ERRO] Número fora dos parâmetros pedidos, tente novamente.");
						}
					} while (x < 0 && x >= 10);

					do {
						System.out.print("Por favor, escolha uma LINHA (número entre 0 e 9) para atacar: ");
						y = userInput.nextInt();

						if (y < 0 && y >= 10) {
							System.out.println("\n[ERRO] Número fora dos parâmetros pedidos, tente novamente.");
						}
					} while (y < 0 && y >= 10);


					if (tabJogo2[x][y].equals("O")) {
						System.out.println("\nVocê acertou a parte de um navio!");
						tabJogoOculto2[x][y] = "@";
						contadorPontosMaximosP1++;
						System.out.println("Segmentos acertados: " + contadorPontosMaximosP1 + " de 14.");
						imprimirTabuleiroOculto2();

					} else if (!tabJogo2[x][y].equals("O")) {
						System.out.println("\nVocê errou!");
						imprimirTabuleiroOculto2();
					}
					contadorTurnos++;

					if (contadorPontosMaximosP1 == 14) {
						System.out.println("\nJogador 1 venceu!");
						System.out.println("__________________________________________________________");
					}	

				} else if (contadorTurnos % 2 == 0) {					
					int x, y;

					System.out.println("\n >>> JOGADOR 2# <<<");					
					System.out.println("\nTurno: " + contadorTurnos);

					do {
						System.out.print("\nPor favor, escolha uma COLUNA (número entre 0 e 9) para atacar: ");		
						x = userInput.nextInt();

						if (x < 0 && x >= 10) {
							System.out.println("\n[ERRO] Número fora dos parâmetros pedidos, tente novamente.");
						}
					} while (x < 0 && x >= 10);

					do {
						System.out.print("Por favor, escolha uma LINHA (número entre 0 e 9) para atacar: ");
						y = userInput.nextInt();

						if (y < 0 && y >= 10) {
							System.out.println("\n[ERRO] Número fora dos parâmetros pedidos, tente novamente.");
						}
					} while (y < 0 && y >= 10);


					if (tabJogo1[x][y].equals("O")) {
						System.out.println("\nVocê acertou a parte de um navio!");
						tabJogoOculto1[x][y] = "@";
						contadorPontosMaximosP2++;
						System.out.println("Segmentos acertados: " + contadorPontosMaximosP2 + " de 14.");
						imprimirTabuleiroOculto1();

					} else if (!tabJogo1[x][y].equals("O")) {
						System.out.println("\nVocê errou!");
						imprimirTabuleiroOculto1();
					}
					contadorTurnos++;					

					if (contadorPontosMaximosP2 == 14) {
						System.out.println("\nJogador 2 venceu!");
						System.out.println("__________________________________________________________");
					}
				}
			}
			
			userInput.close();
		}
	}






	// MÉTODOS DE IMPRESSÃO:
	public static void imprimir (String temp) {
		System.out.print(temp);
	}

	public static void imprimir (int valor) {
		System.out.print(valor + " ");
	}

}

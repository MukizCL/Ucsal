package br.ucsal;

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
		usuario[0] = imput.next();
		validaUsuario(0);
		imprimir ("Usuario1: " + usuario[0] + " - Validado com sucesso" + "\n");
		imprimir("\n ==========================="
				+ "\n Seja bem vindo: " + usuario[0]);
		usuario[1] = "";
		menu(usuario, op);
		} else {
			imprimir("Insira o nome do usuario 2\n");
			usuario[1] = imput.next();
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
							+ "\nIniciando Jogo da forca...");
					forca(user1, user2, 1, 0, 0);
					}
					break;
			case 2:
				if(user2.equals("")) {
					imprimir("Este jogo requer 2 usuários\n");
					cadastroUsuario(usuario[0], menu);
					} else {
					
					imprimir("\n ==========================="
							+ "\nIniciando Batalha naval...");
					}
					break;
			case 3: 
				imprimir("\nIniciando Campo minado...");
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
	
	//JOGO DA FORCA
	public static void forca (String user1, String user2, int jogador, int r1, int r2) {
		Scanner imput = new Scanner(System.in);
		String palavra1 = "";
		if (jogador == 1) {
		imprimir("<<< JOGO DA FORCA >>>\n");
		imprimir("\n");
		imprimir("- Para jogar, escolha 1 (uma) letra que você acredita que existe na palavra.\n");
		imprimir("- Cada letra errada irá aumentar os 'Erros' em 1 e adicionará 1 parte do corpo ao boneco.\n");
		imprimir("- Com 6 erros acumulados, o jogo acaba.\n");
		imprimir("\n");
		imprimir("Boa sorte!\n");
		imprimir("_______________________________________________________________________________\n");
		imprimir("\n");
		imprimir("============================================\n");
		imprimir("Primeiro, " + user1 + " Vai digitar uma palavra para " + user2 + " Tentar adivinhar\n");
		imprimir(user1 + ", Digite a palavra escolhida por você:\n");
		palavra1 = imput.next();
		
		for (int i = 0; i < 15; i++) {
			imprimir("\n");
		}
		} else if (jogador == 2) {
			imprimir("Agora, " + user2 + " Vai digitar uma palavra para " + user1 + " Tentar adivinhar\n");
			imprimir(user2 + ", Digite a palavra escolhida por você:\n");
			palavra1 = imput.next();
			
			for (int i = 0; i < 15; i++) {
				imprimir("\n");
			}
			} else {
				imprimir(user1 + " Teve " + r1 + " Erros \n");
				imprimir(user2 + " Teve " + r2 + " Erros ");
			}
		String palavra = palavra1.toUpperCase();
		String palavraOculta1 = new String(new char[palavra.length()]).replace("\0", "-");
		
		
		while (numErros < 6 && palavraOculta1.contains("-")) { 					
			if (jogador == 1) {
				
			imprimir(user2 + ", Adivinhe uma letra. \n"); 
			} else {
		imprimir(user1 + ", Adivinhe uma letra. \n"); 
			}
			imprimir(palavraOculta1);									
			imprimir("\nLetra: \n");					
			Scanner userInput = new Scanner(System.in);
			String tentativaUsuario = userInput.next().toUpperCase(); 			
			System.out.println();					 			
			forcaCodigo(tentativaUsuario, palavra, palavraOculta1, r1, r2, user1, user2, jogador);										
		}
		
	}
	public static int numErros = 0;
	public static void forcaCodigo(String tentativaUsuario, String palavra1, String palavraOculta1, int r1, int r2, String user1, String user2, int jogador) {
		
		String espacoTraco = ""; 
		for (int i = 0; i < palavra1.length(); i++) { 					
			if (palavra1.charAt(i) == tentativaUsuario.charAt(0)) {		
				espacoTraco += tentativaUsuario.charAt(0);						
			} else if (palavraOculta1.charAt(i) != '-') {						
				espacoTraco += palavra1.charAt(i);						
			} else {															
				espacoTraco += "-";												
			}
			
		}

		if (palavraOculta1.equals(espacoTraco)) {								
			numErros++; 
			int numErrostemp = numErros;
			//forcaDesign(numErros, palavra1, );
			if(jogador == 1){
				forcaDesign(palavra1, user1, user2, 1, numErrostemp, 0);
				} else if ( jogador == 2) {
					forcaDesign(palavra1, user1, user2, 2, r1, numErrostemp);
				}
		} else {
			palavraOculta1 = espacoTraco;										
		}
		if (palavraOculta1.equals(palavra1)) {							
			imprimir("\nParabéns, você ganhou!");
			imprimir ("\nVocê errou " + numErros + " Vezes");
			imprimir("\nA palavra escolhida era: '" + palavra1 + "'!");
			if(jogador == 1){
			forca(user1, user2, 2, numErros, 0);
			} else if ( jogador == 2) {
				forca(user1, user2, 3, r1, numErros);
			}
		}
	}
	
	public static void forcaDesign(String palavra1, String user1, String user2, int jogador, int r1, int r2) {
		switch (numErros) { 													
		case 0:
			imprimir("\n           ||======|  \r\n" +
					"           ||         \r\n" + 
					"           ||         \r\n" + 
					"           ||         \r\n" + 
					"           ||         \r\n" + 
					"        ___||___      \r\n" + 
					"       |	|" +
					"\n");
			break;
		case 1:	
			imprimir("\n           ||======|  \r\n" + 
					"           ||      0  \r\n" + 
					"           ||         \r\n" + 
					"           ||         \r\n" + 
					"           ||         \r\n" + 
					"        ___||___      \r\n" + 
					"       |	|" +
					"\n");
			break;
		case 2:	
			imprimir("\n           ||======|  \r\n" +
					"           ||      0  \r\n" + 
					"           ||      |  \r\n" + 
					"           ||         \r\n" + 
					"           ||         \r\n" + 
					"        ___||___      \r\n" + 
					"       |	|" +
					"\n");
			break;
		case 3:	
			imprimir("\n           ||======|  \r\n" +
					"           ||      0  \r\n" + 
					"           ||     /|  \r\n" + 
					"           ||         \r\n" + 
					"           ||         \r\n" + 
					"        ___||___      \r\n" + 
					"       |	|" +
					"\n");
			break;
		case 4:	
			imprimir("\n           ||======|  \r\n" +
					"           ||      0   \r\n" + 
					"           ||     /|\\ \r\n" + 
					"           ||          \r\n" + 
					"           ||          \r\n" + 
					"        ___||___       \r\n" + 
					"       |	|" +
					"\n");
			break;
		case 5:	
			imprimir("\n           ||======|  \r\n" + 
					"           ||      0    \r\n" + 
					"           ||     /|\\  \r\n" + 
					"           ||     /     \r\n" + 
					"           ||           \r\n" + 
					"        ___||___        \r\n" + 
					"       |	|" +
					"\n");
			break;

		default:
			imprimir("\n           ||======|  \r\n" + 					
					"           ||      0   \r\n" + 
					"           ||     /|\\ \r\n" + 
					"           ||     / \\ \r\n" + 
					"           ||          \r\n" + 
					"        ___||___       \r\n" + 
					"       |	| 		    \r\n" +
					"\n" +
					"Você chegou no número máximo de erros (" + numErros + "). O jogo acabou." +
					"\n" +
					"A palavra era: \"" + palavra1 + "\".");
			
			break;
		}
		if(jogador == 1 && numErros == 6){
			forca(user1, user2, 2, numErros, 0);
			} else if ( jogador == 2 && numErros == 6) {
				forca(user1, user2, 3, r1, numErros);
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

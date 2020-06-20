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


















	// MÉTODOS DE IMPRESSÃO:
	public static void imprimir (String temp) {
		System.out.print(temp);
	}

	public static void imprimir (int valor) {
		System.out.print(valor + " ");
	}

}

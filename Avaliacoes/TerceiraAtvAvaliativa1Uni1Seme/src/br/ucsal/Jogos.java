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
	

















	// MÉTODOS DE IMPRESSÃO:
	public static void imprimir (String temp) {
		System.out.print(temp);
	}

	public static void imprimir (int valor) {
		System.out.print(valor + " ");
	}

}

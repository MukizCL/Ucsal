package br.ucsal;

import java.util.Scanner;



public class Jogos {

	public static void main(String[] args) {
		Scanner imput = new Scanner(System.in);
		String[] usuario = new String[2];
		imprimir("Insira o nome do usuario 1: \n");
		usuario[0] = imput.next();
		validaUsuario(0);
		imprimir ("Usuario1: " + usuario[0] + " - Validado com sucesso" + "\n");
		imprimir("\n ==========================="
				+ "\n Seja bem vindo: " + usuario[0]);
		menu();
		int menu = imput.nextInt();
		while(menu > 4) {
			imprimir("Você digitou uma opção inválida, Tente novamente: \n");
			menu = imput.nextInt();
		}
		if(menu == 1) {
			imprimir("Este jogo requer 2 usuários"
					+ "\n Insira o nome do usuario 2: \n");
			usuario[1] = imput.next();
			validaUsuario(111);
			imprimir ("Usuario2: " + usuario[1] + " - Validado com sucesso" + "\n"); 
			imprimir("\n ==========================="
					+ "\n Sejam bem vindos: " + usuario[0] + " e " + usuario[1]);
			
			imprimir("\nIniciando Jogo da forca...");
		} else if(menu == 2) {
			imprimir("Este jogo requer 2 usuários"
					+ "\n Insira o nome do usuario 2: \n");
			usuario[1] = imput.next();
			validaUsuario(111);
			imprimir ("Usuario2: " + usuario[1] + " - Validado com sucesso" + "\n"); 
			imprimir("\n ==========================="
					+ "\n Sejam bem vindos: " + usuario[0] + " e " + usuario[1]);
			
			imprimir("\nIniciando Batalha naval...");
		} else if (menu == 3) {
			imprimir("\nIniciando Campo minado");
		} else if( menu == 4) {
			imprimir("Jogo encerrado!");
			System.exit(0);
		}



	}
	// MÉTODO PARA VALIDAÇÃO DA SENHA DO USUARIO:
	public static void validaUsuario (int pass) {
		Scanner imput = new Scanner(System.in);
		int[] senha = new int[2];
		senha[0] = pass;
		
		
		if(senha[0] != 111) {
			imprimir("Insira a senha do Usuario 1 \n");
			senha[0] = imput.nextInt();
			while(senha[0] != 111) {
				imprimir("Você digitou a senha errada, Tente novamente: \n");
				senha[0] = imput.nextInt();	
			}
		} else { imprimir("Insira a senha do Usuario 2 \n");
		senha[1] = imput.nextInt();
		while(senha[1] != 222) {
			imprimir("Você digitou a senha errada, Tente novamente: \n");
			senha[1] = imput.nextInt();


		}
		}

	}
	//MÉTODO QUE IMPRIME O MENU:
	public static void menu () {
		imprimir("\n ==========================="
				+ "\n Escolha qual jogo deseja jogar:"
				+ "\n [1] Jogo da forca"
				+ "\n [2] Batalha naval"
				+ "\n [3] Campo minado"
				+ "\n [4] Sair\n");
	}

















	// MÉTODOS DE IMPRESSÃO:
	public static void imprimir (String temp) {
		System.out.print(temp);
	}

	public static void imprimir (int valor) {
		System.out.print(valor + " ");
	}

}

package br.ucsal;

public class Questao01 {

	public static void main(String[] args) {
		int[][] temp = obterArray03(obterArray01(5, 4), obterArray02(5, 4));
		imprimir("A Sequencia fibonacci é: \n");
		imprimir(obterArray01(5, 4));
		imprimir("\n\n");
		imprimir("A Sequencia progressiva aritmética é: \n");
		imprimir(obterArray02(5, 4));
		imprimir("\n\n");
		imprimir("A Soma de todos os elementos dos arrays anteriores é: \n");
		imprimir(temp);
		imprimir("\n\n");
		imprimir("A Soma de todos os elementos + 2 do array anterior é: \n");
		imprimir(obterArray04(temp));

	}
	
	public static int[][] obterArray01(int x, int y) {
		int[][] arrayBid = new int[x][y];
		for (int i = 0, a = 0, d = 1, aux; i < arrayBid.length; i++) {
			for (int j = 0; j < arrayBid[i].length; j++) {
				arrayBid[i][j] = a;
				aux = a + d;
				a = d;
				d = aux;
			}
		}
		return arrayBid;
	}
	
	public static int[][] obterArray02(int x, int y) {
		int[][] arrayBid = new int[x][y];
		for (int i = 0, a = 4; i < arrayBid.length; i++) {
			for (int j = 0; j < arrayBid[i].length; j++) {
				arrayBid[i][j] = a;
				a = a + 3;
			}
		}
		return arrayBid;
	}
	
	public static int[][] obterArray03(int[][] x, int[][] y) {
		int[][] arrayBid = new int[x.length][x[0].length];
        for (int l = 0; l < arrayBid.length; l++) {
            for (int c = 0; c < arrayBid[l].length; c++) {
                arrayBid[l][c] = x[l][c] + y[l][c];
            }            
        }        
        return arrayBid;
		
	}
	
	public static int[] obterArray04(int[][] x) {
		 int[] arrayUni = new int[x.length * x[0].length];
	        
	        for (int l = 0, a = 0; l < x.length; l++) {
	            for (int c = 0; c < x[l].length; c++, a++) {
	                arrayUni[a] = x[l][c] + 2;
	            }

	        }        
	        return arrayUni;
	}
	
	
	
	//Métodos de impressão
	
	public static void imprimir(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void imprimir(String txt) {
		System.out.print(txt);
	}
	
	public static void imprimir(int[][] arrayBidi) {
        for (int l = 0; l < arrayBidi.length; l++) {
            for (int c = 0; c < arrayBidi[l].length; c++) {
                System.out.print(arrayBidi[l][c] + " ");
            }
        }
    }

}

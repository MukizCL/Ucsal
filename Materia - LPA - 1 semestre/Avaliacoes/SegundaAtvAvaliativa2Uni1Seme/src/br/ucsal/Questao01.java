package br.ucsal;

public class Questao01 {

	public static void main(String[] args) {
		imprimir("A Sequencia fibonacci é: \n");
		imprimir(obterArray01(5, 4));
		imprimir("\n");

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

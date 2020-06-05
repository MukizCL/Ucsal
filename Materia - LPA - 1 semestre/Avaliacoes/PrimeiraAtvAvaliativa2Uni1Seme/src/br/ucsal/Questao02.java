package br.ucsal;

public class Questao02 {

	public static void main(String[] args) {
        imprimir(obterSequencia1());
        imprimir("\n");
        imprimir(obterSequencia2());
        imprimir("\n");
        int[] valRes3 = new int[16];
        valRes3 = obterSequencia3(obterSequencia1(), obterSequencia2());
        imprimir(valRes3);
    }
 
    public static int[] obterSequencia1() {
        int[] valRes1 = new int[16];
        int valInicial = 2, valFinal, valAux;
        final int ValBase = 5;
       
        for (int i = 0; i < valRes1.length; i++) {
            valRes1[i] = valInicial;
            valAux = (int) Math.pow(2,i);
            valFinal = valInicial + (ValBase * valAux);
            valInicial = valFinal;
        }
       
        return valRes1;
    }
 
    public static int[] obterSequencia2() {
        int[] valRes2 = new int[16];
        valRes2[0] = 15;
        valRes2[1] = 4;
        for(int i = 2; i <valRes2.length; i++) {
            if(i % 2 == 0) {
                valRes2[i] = valRes2[i -2] * 5;
            } else {
                valRes2[i] = valRes2[i-2] * 3;
            }
        }
        return valRes2;
    }
 
    public static int[] obterSequencia3(int[] sequencia1, int[] sequencia2) {
        int[] valRes3 = new int[16];
        for(int i = 0; i <valRes3.length; i++) {
            valRes3[i] = sequencia1[i] + sequencia2[i];
        }
        return valRes3;
    }
 
    public static void imprimir(int[] temp) {
        for(int i = 0; i <temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }
    public static void imprimir(String txt) {
        System.out.print(txt);
    }

}

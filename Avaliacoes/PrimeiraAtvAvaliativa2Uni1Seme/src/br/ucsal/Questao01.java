package br.ucsal;

public class Questao01 {

	public static void main(String[] args) {
        double[] pesos1und = {2.5, 3.0, 4.5};
        double[] pesos2und = {3.2, 3.3, 3.5};
        double[] notas1und = {3.1, 5.1, 7.1};
        double[] notas2und = {9.1, 5.5, 7.5};
        imprimir ("A Média da primeira unidade é:  ");
        double notas1 = obterMediaUnidade(notas1und, pesos1und);
        imprimir(notas1);
        imprimir("---------------------------------");
        imprimir ("A Média da segunda unidade é:  ");
        double notas2 = obterMediaUnidade(notas2und, pesos2und);
        imprimir(notas2);
        imprimir("---------------------------------");
        imprimir ("A Média do semestre é:  ");
        double mediaSem = 0;
        mediaSem = obterMediaSemestre(notas1, notas2);
        imprimir(mediaSem);
        imprimir("---------------------------------");
        imprimir ("O Aluno foi:  ");
        String result = obterResultado(mediaSem);
        imprimir(result);
    }

    public static double obterMediaUnidade(double[] notas, double[] pesos) {
        double[] nota1 = new double[notas.length];
        double notaF = 0;
        double pesoF = 0;
        for(int i = 0; i < notas.length; i++ ) {
            nota1[i] = notas[i] * pesos[i];
            pesoF += pesos[i];
        }
        for(int i = 0; i < nota1.length; i++ ) {
            notaF += nota1[i];
        }
        notaF = notaF /pesoF;
        return notaF;
    }

    public static double obterMediaSemestre(double notas1, double notas2) {
        double mediaSemestre = (notas1 + notas2) / 2;
        return mediaSemestre;
    }

    public static String obterResultado(double mediaSemestre) {
        String resultado;
        if(mediaSemestre >= 6) {
            resultado = "APROVADO";
        } else {
            resultado = "REPROVADO";
        }
        return resultado;
    }

    public static void imprimir(double num) {
        System.out.println(num); 

    }
    public static void imprimir(String txt) {
        System.out.println(txt); 

    }

}

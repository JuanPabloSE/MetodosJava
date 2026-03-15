package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Calculadora;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // CRIANDO OBJETO CALCULADORA

        Calculadora valor1 = new Calculadora();
        Calculadora valor2 = new Calculadora();
        Calculadora operacao = new Calculadora();
        Calculadora resultado = new Calculadora();

        System.out.println("----- BEM-VINDO A CALCULADORA JAVA -----\n");

        System.out.print("DIGITE O PRIMEIRO VALOR: ");
        valor1.valor1 = sc.nextDouble();

        System.out.print("DIGITE O SEGUNDO VALOR: ");
        valor2.valor2 = sc.nextDouble();

        System.out.print("DIGITE A OPERAÇÃO DESEJADA ( +, -, /, x ): ");
        operacao.operacao = sc.next().trim();

        System.out.println(resultado.exibirResultado());

        sc.close();
    }


}
package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Calculadora;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // CRIANDO OBJETO CALCULADORA

        Calculadora calculadora = new Calculadora();

        System.out.println("----- BEM-VINDO A CALCULADORA JAVA -----\n");

        System.out.print("DIGITE O PRIMEIRO VALOR: ");
        calculadora.valor1 = sc.nextDouble();

        System.out.print("DIGITE O SEGUNDO VALOR: ");
        calculadora.valor2 = sc.nextDouble();

        System.out.print("DIGITE A OPERAÇÃO DESEJADA ( +, -, /, x ): ");
        calculadora.operacao = sc.next().trim();

        mostrarResultado(calculadora);

        sc.close();
    }

    public static void mostrarResultado(Calculadora calculadora) {
        System.out.printf("%.1f%n", calculadora.calcularResultado());
    }


}
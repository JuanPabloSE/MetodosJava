import java.util.Locale;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("----- BEM-VINDO A CALCULADORA JAVA -----\n");

        double primeiroValor = lerValor(sc, "DIGITE O PRIMEIRO VALOR: ");
        double segundoValor = lerValor(sc, "DIGITE O SEGUNDO VALOR: ");
        String operacao = operacaoLida(sc, "ESCOLHA A OPERAÇÃO DESEJADA (+, -, /, x): ");

        double resultado = calcularResultado(primeiroValor, segundoValor, operacao);

        mostrarResultado(resultado);

        sc.close();
    }

    public static double lerValor(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        return sc.nextDouble();
    }

    private static String operacaoLida(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        return sc.next().toLowerCase();
    }

    private static double calcularResultado(double primeiroValor, double segundoValor, String operacao) {
        double aux;
        switch (operacao) {
            case "+":
                aux = primeiroValor + segundoValor;
                break;

            case "-":
                aux = primeiroValor - segundoValor;
                break;

            case "/":
                if (segundoValor == 0) {
                    throw new ArithmeticException("Divisão por zero não é permitida!");
                }
                aux = primeiroValor / segundoValor;
                break;

            case "x":
                aux = primeiroValor * segundoValor;
                break;

            default:
                throw new IllegalArgumentException("OPERAÇÃO INCORRETA, TENTE NOVAMENTE!");
        }
        return aux;
    }

    public static void mostrarResultado(double resultado) {
        System.out.printf("%.1f%n", resultado);
    }

}

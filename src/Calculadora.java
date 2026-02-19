import java.util.Locale;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String opcao;
        boolean continuar = true;

        System.out.println("----- BEM-VINDO A CALCULADORA JAVA -----\n");

        while (continuar) {
            try {
                double primeiroValor = lerValor(sc, "DIGITE O PRIMEIRO VALOR: ");
                double segundoValor = lerValor(sc, "DIGITE O SEGUNDO VALOR: ");
                String operacao = operacaoLida(sc, "ESCOLHA A OPERAÇÃO DESEJADA (+, -, /, x): ");

                double resultado = calcularResultado(primeiroValor, segundoValor, operacao);

                mostrarResultado(resultado);

                System.out.print("DESEJA CONTINUAR CALCULANDO ? (S/N): ");
                opcao = sc.next().trim().toUpperCase();

                if (opcao.equals("N")) {
                    continuar = false;
                    System.out.println("SISTEMA FINALIZADO. OBRIGADO POR USAR NOSSA CALCULADORA!");
                }
            } catch (ArithmeticException e) {
                System.out.println("\nERRO ❌: " + e.getMessage()); // Receber mensagem de erro personalizada
            } catch (IllegalArgumentException ex) {
                System.out.println("\nERRO ❌: " + ex.getMessage()); // Receber mensagem de erro personalizada
            }

        }

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
                    throw new ArithmeticException("DIVISÃO POR ZERO NÃO É PERMITIDA!\n");
                }
                aux = primeiroValor / segundoValor;
                break;

            case "x":
                aux = primeiroValor * segundoValor;
                break;

            default:
                throw new IllegalArgumentException("OPERAÇÃO INCORRETA, TENTE NOVAMENTE!\n");
        }
        return aux;
    }

    public static void mostrarResultado(double resultado) {
        System.out.printf("%.1f%n", resultado);
    }

}

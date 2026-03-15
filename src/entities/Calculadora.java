package entities;

public class Calculadora {

    public double valor1;
    public double valor2;
    public String operacao;

    public Calculadora() {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.operacao = operacao;
    }

    private double calcularResultado(double valor1, double valor2, String operacao) {
        double aux;
        switch (operacao) {
            case "+":
                aux = valor1 + valor2;
                break;

            case "-":
                aux = valor1 - valor2;
                break;

            case "/":
                if (valor2 == 0) {
                    throw new ArithmeticException("DIVISÃO POR ZERO NÃO É PERMITIDA!\n");
                }
                aux = valor1 / valor2;
                break;

            case "x":
                aux = valor1 * valor2;
                break;

            default:
                throw new IllegalArgumentException("OPERAÇÃO INCORRETA, TENTE NOVAMENTE!\n");
        }
        return aux;
    }

    public boolean exibirResultado() {
        double calcularResultado = calcularResultado(valor1, valor2, operacao);
        return false;
    }

}

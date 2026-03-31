package entities;

public class Calculadora {

    public double valor1;
    public double valor2;
    public String operacao;

    public double getCalculadora() {
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

    public String toString(){
        return String.format("%.1f", getCalculadora());
    }

}

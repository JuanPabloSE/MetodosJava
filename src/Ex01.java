import java.util.Locale;
import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double nota1 = lerNota(sc, "Digite a nota 1: ");
        double nota2 = lerNota(sc, "Digite a nota 2: ");

        double media = calcularMedia(nota1, nota2);
        String resultado = calcularResultado(media);
        mostrarResultado(media, resultado);

        sc.close();
    }

    // MET - LÉR NOTAS
    public static double lerNota(Scanner sc, String mensagem){
        System.out.print(mensagem);
        return sc.nextDouble();
    }

    // CÁLCULO DA MÉDIA
    public static double calcularMedia(double nota1, double nota2){
        return (nota1 + nota2) / 2;
    }

    // CÁLCULO DO RESULTADO
    public static String calcularResultado(double media){
        if (media >= 7.0){
            return "Aprovado";
        }
        else if (media >= 5.0){
            return "Recuperação";
        }
        else{
            return "Reprovado";
        }
    }

    // MOSTRAR MÉDIA
    public static void mostrarResultado(double media, String resultado){
        System.out.printf("Média: %.2f%n", media);
        System.out.println("Situação: " + resultado);
    }

}

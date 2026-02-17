import java.util.Locale;
import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a nota 1: ");
        double nota1 = lerNota(sc);
        System.out.print("Digite a nota 2: ");
        double nota2 = lerNota(sc);

        double media = calculoMedia(nota1, nota2);
        mostrarResultado(media);

        sc.close();
    }

    // MET - LÉR NOTAS
    public static double lerNota(Scanner sc){
        return sc.nextDouble();
    }

    // CÁLCULO DA MÉDIA
    public static double calculoMedia(double nota1, double nota2){
        return (nota1 + nota2) / 2;
    }

    // MOSTRAR MÉDIA
    public static void mostrarResultado(double media){
        System.out.printf("Média: %.2f%n", media);
    }

}

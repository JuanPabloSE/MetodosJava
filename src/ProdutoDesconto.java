import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ProdutoDesconto {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String opcao;
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("Digite o preço do produto: ");
                double precoProduto = sc.nextDouble();
                System.out.print("Digite a quantidade comprada: ");
                int quantidadeComprada = sc.nextInt();
                System.out.print("Tipo de Cliente ? (C = Comum / P = Premium): ");
                String tipoCliente = sc.next().trim().toUpperCase();
                System.out.print("Região de entrega ? (N = Nacional / I = Internacional): ");
                String regiaoEntrega = sc.next().trim().toUpperCase();

                double subTotal = calcularSubtotal(precoProduto, quantidadeComprada);
                double desconto = calcularDesconto(subTotal, tipoCliente);
                double frete = calcularFrete(subTotal, regiaoEntrega);
                double total = calcularTotal(subTotal, desconto, frete);

                mostrarResultado(subTotal, desconto, frete, total);

                System.out.print("\nDeseja realizar outra compra? (S/N): ");
                opcao = sc.next().trim().toUpperCase();

                if (opcao.equalsIgnoreCase("N")) {
                    continuar = false;
                }
                System.out.println("SISTEMA FINALIZADO. OBRIGADO POR USAR NOSSO SERVIÇO!");

            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage()); // Receber mensagem de erro personalizada
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite um valor numérico correto.");
                sc.nextLine(); // Limpa o buffer do scanner
            }
        }

        sc.close();
    }

    public static double calcularSubtotal(double precoProduto, int quantidadeComprada) {
        return precoProduto * quantidadeComprada;
    }

    public static double calcularDesconto(double subTotal, String tipoCliente) {
        double percentual;

        if (tipoCliente.equals("P")) {
            percentual = 0.10; // 10% de desconto para clientes Premium
        }

        else if (tipoCliente.equals("C")) {
            percentual = 0.05; // 5% de desconto para clientes Comuns
        }

        else {
            throw new IllegalArgumentException("Tipo de cliente inválido. Use 'C' para Comum ou 'P' para Premium.");
        }

        if (subTotal > 500) {
            percentual += 0.05; // Adiciona mais 5% de desconto para compras acima de R$ 500
        }

        return subTotal * percentual;

    }

    public static double calcularFrete(double subTotal, String regiaoEntrega) {
        double frete;

        if (regiaoEntrega.equals("N")) {
            frete = 20.0; // Frete fixo para região Nacional
        }

        else if (regiaoEntrega.equals("I")) {
            frete = 100.0; // Frete fixo para região Internacional
        }

        else {
            throw new IllegalArgumentException("Região de entrega inválida. Use 'N' para Nacional ou 'I' para Internacional.");
        }

        if (subTotal > 1000.0) {
            frete = 0.0; // Frete grátis para compras acima de R$ 1000
        }

        return frete;
    }

    public static double calcularTotal(double subTotal, double desconto, double frete) {
        return (subTotal - desconto) + frete;
    }

    public static void mostrarResultado(double subTotal, double desconto, double frete, double total) {
        System.out.printf("Subtotal: R$ %.2f%n", subTotal);
        System.out.printf("Desconto: R$ %.2f%n", desconto);
        System.out.printf("Frete: R$ %.2f%n", frete);
        System.out.printf("Total a pagar: R$ %.2f%n", total);
    }
}

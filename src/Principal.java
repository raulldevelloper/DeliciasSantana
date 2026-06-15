import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Produto boloConfeitado =
                new Produto("Bolo confeitado", 70, 2);

        Produto boloTradicional =
                new Produto("Bolo tradicional", 22, 1);

        Produto tortaSalgada =
                new Produto("Torta salgada", 35, 3);

        Produto tortaDoce =
                new Produto("Torta doce", 40, 3);

        Produto miniSalgados =
                new Produto("100 mini salgados", 125, 6);

        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        Cliente cliente =
                new Cliente(nome, telefone);

        Pedido pedido =
                new Pedido(cliente);

        int opcao;

        System.out.println("\n===== CARDÁPIO =====");
        System.out.println("1 - Bolo confeitado");
        System.out.println("2 - Bolo tradicional");
        System.out.println("3 - Torta salgada");
        System.out.println("4 - Torta doce");
        System.out.println("5 - 100 mini salgados");
        System.out.println("0 - Finalizar");

        do {
            System.out.println("\nEscolha um lanche (opção 1 até a opção 5): ");
            System.out.println(" E digite 0 para finalizar o pedido!");
            opcao = sc.nextInt();

            if (opcao >= 1 && opcao <= 5) {

                System.out.print("Quantidade: ");
                int quantidade = sc.nextInt();

                switch (opcao) {

                    case 1:
                        pedido.adicionarItem(boloConfeitado, quantidade);
                        break;

                    case 2:
                        pedido.adicionarItem(boloTradicional, quantidade);
                        break;

                    case 3:
                        pedido.adicionarItem(tortaSalgada, quantidade);
                        break;

                    case 4:
                        pedido.adicionarItem(tortaDoce, quantidade);
                        break;

                    case 5:
                        pedido.adicionarItem(miniSalgados, quantidade);
                        break;
                }
            }

        } while (opcao != 0);

        pedido.mostrarResumo();

        sc.close();
    }
}

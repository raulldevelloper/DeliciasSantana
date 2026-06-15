public class Pedido {

    private Cliente cliente;

    private ItemPedido[] itens = new ItemPedido[50];
    private int quantidadeItens = 0;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(Produto produto, int quantidade) {

        ItemPedido item = new ItemPedido(produto, quantidade);

        itens[quantidadeItens] = item;
        quantidadeItens++;
    }

    public double calcularValorTotal() {

        double total = 0;

        for (int i = 0; i < quantidadeItens; i++) {
            total += itens[i].getValorTotal();
        }

        return total;
    }

    public int calcularTempoTotal() {

        int total = 0;

        for (int i = 0; i < quantidadeItens; i++) {
            total += itens[i].getTempoTotal();
        }

        return total;
    }

    public void mostrarResumo() {

        System.out.println("\n===== RESUMO DO PEDIDO =====");

        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Telefone: " + cliente.getTelefone());

        System.out.println("\nItens:");

        for (int i = 0; i < quantidadeItens; i++) {

            ItemPedido item = itens[i];

            System.out.println(item.getQuantidade() + "x "
                    + item.getProduto().getNome() + " | R$ " + item.getValorTotal());
        }

        System.out.println(
                "\nValor total: R$ " + calcularValorTotal());

        System.out.println(
                "Tempo estimado: " + calcularTempoTotal() + " horas");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }
}

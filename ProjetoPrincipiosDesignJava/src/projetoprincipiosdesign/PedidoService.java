package projetoprincipiosdesign;

// Imports das subpastas do seu projeto
import projetoprincipiosdesign.Desconto;
import projetoprincipiosdesign.TipoEntrega;
import projetoprincipiosdesign.Pagamento;

public class PedidoService {

    private final PedidoRepository repository;

    // Construtor 1: Padrão (usa arquivo por padrão)
    public PedidoService() {
        this.repository = new PedidoRepositoryArquivo();
    }

    // Construtor 2: Permite trocar o repositório (DIP)
    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    // Solução para a Lei de Demeter
    public String obterCidadeEntrega(Pedido pedido) {
        return pedido.getCliente().getCidadeEntrega();
    }

    public double calcularTotal(Pedido pedido, Desconto desconto, TipoEntrega tipoEntrega) {
        double subtotal = 0.0;

        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) {
                subtotal += item.getPreco() * item.getQuantidade();
            }
        }

        double valorDesconto = (desconto != null) ? desconto.calcular(subtotal) : 0.0;
        double valorFrete = (tipoEntrega != null) ? tipoEntrega.calcularFrete(subtotal) : 0.0;

        return (subtotal - valorDesconto) + valorFrete;
    }

    public void finalizarPedido(Pedido pedido, Desconto desconto, TipoEntrega tipoEntrega, Pagamento pagamento) {
        double total = calcularTotal(pedido, desconto, tipoEntrega);

        // Salva usando o repositório configurado
        this.repository.salvar(pedido);

        System.out.println("Gerando resumo do pedido...");
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.printf("Total: R$ %.2f%n", total);

        // Executa o pagamento via polimorfismo
        if (pagamento != null) {
            boolean sucesso = pagamento.pagar(total);
            if (sucesso) {
                System.out.println(
                        "Enviando mensagem para " + pedido.getCliente().getNome() + ": pedido finalizado."
                );
            }
        }
    }
}
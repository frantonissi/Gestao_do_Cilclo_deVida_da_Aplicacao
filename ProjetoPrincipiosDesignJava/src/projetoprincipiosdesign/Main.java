package projetoprincipiosdesign;

import projetoprincipiosdesign.Cidade;
import projetoprincipiosdesign.Cliente;
import projetoprincipiosdesign.Endereco;


import java.util.List;//teste

public class Main {
    public static void main(String[] args) {
        System.out.println("=== LOJA ACADÊMICA ===");

        Cliente cliente = new Cliente(
            "Ana",
            new Endereco(
                "Rua das Flores",
                new Cidade("Belo Horizonte")
            )
        );

        Pedido pedido = new Pedido(
            cliente,
            List.of(
                new ItemPedido("Livro de Engenharia de Software", 120.0, 1),
                new ItemPedido("Caderno", 20.0, 2)
            )
        );

        PedidoService servico = new PedidoService();

        // Instancia os objetos das estratégias que você quer aplicar
        Desconto desconto = new DescontoAluno();
        TipoEntrega entrega = new Entrega(); // Ou new EntregaRetiradaLoja()
        Pagamento pagamento = new PagamentoCartao(); // Ou new PagamentoPix() / PagamentoBoleto()

        System.out.println();
        System.out.println("Cidade de entrega:");
        System.out.println(servico.obterCidadeEntrega(pedido));

        System.out.println();
        System.out.println("Total com desconto e frete:");
        // Passa os objetos de desconto e entrega
        System.out.printf("R$ %.2f%n", servico.calcularTotal(pedido, desconto, entrega));

        System.out.println();
        System.out.println("Pagamento:");
        // Passa os objetos necessários para finalizar o pedido
        servico.finalizarPedido(pedido, desconto, entrega, pagamento);

        System.out.println();
        System.out.println("Programa executado com sucesso.");
    }
}

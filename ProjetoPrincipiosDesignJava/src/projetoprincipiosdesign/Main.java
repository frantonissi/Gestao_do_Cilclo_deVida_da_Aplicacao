package projetoprincipiosdesign;


import java.util.List;//teste

public class Main {
    public static void main(String[] args) {
        System.out.println("=== LOJA ACADÊMICA ===");

        Cliente cliente = new Cliente( //Construtor
            "Ana",
            new Endereco(
                "Rua das Flores",
                new Cidade("Belo Horizonte")
            )
        );

        Pedido pedido = new Pedido( //construtor
            cliente,
            List.of(
                new ItemPedido("Livro de Engenharia de Software", 120.0, 1),
                new ItemPedido("Caderno", 20.0, 2)
            )
        );

        PedidoService servico = new PedidoService();

        // Instancia os objetos das estratégias que você quer aplicar
        Desconto desconto = new DescontoProfessor(); //Pode ser tambem com a classe aluno ou a classe funcionario
        TipoEntrega entrega = new EntregaDomicilio(); //Pode ser tambem com a classe EntregaRetirada
        Pagamento pagamento = new PagamentoCartao(); //Pode ser com Pix ou Boleto tambem
        Parcelavel parcelas = new PagamentoCartao();
        GerarBoleto boleto = new PagamentoBoleto();

        System.out.println();
        System.out.println("Cidade de entrega:");
        System.out.println(servico.obterCidadeEntrega(pedido));

        System.out.println();

        //Se for pagamento com cartão (vai parcelar)
        if(pagamento instanceof PagamentoCartao) {
            System.out.println("Total com desconto e frete e numero de parcelas * 12:");
            // Passa os objetos de desconto e entrega
            System.out.printf("R$ %.2f%n", servico.calcularTotalComParcelas(pedido, desconto, entrega, parcelas)); //Ele vai lá na classe
            //pedido service, e busca a função calcularTotal, e usa os objetos que eu criei aqui pra fazer as contas
        }

        //Se for com boleto:
        if(pagamento instanceof PagamentoBoleto) {
            System.out.println("Código do Boleto e Total com Desconto e Frete:");
            // Passa os objetos de desconto e entrega
            System.out.println(servico.calcularTotalBoleto(pedido, desconto, entrega, boleto)); //Ele vai lá na classe
            //pedido service, e busca a função calcularTotal, e usa os objetos que eu criei aqui pra fazer as contas
        }

        //Se for sem cartão e sem boleto (nao vai parcelar)
        if(pagamento instanceof PagamentoPix) {
            System.out.println("Total com desconto e frete sem parcelas:");
            // Passa os objetos de desconto e entrega
            System.out.printf("R$ %.2f%n", servico.calcularTotal(pedido, desconto, entrega));
        }

        System.out.println();
        System.out.println("Pagamento:");
        // Passa os objetos necessários para finalizar o pedido
        servico.finalizarPedido(pedido, desconto, entrega, pagamento);



        System.out.println();
        System.out.println("Programa executado com sucesso.");
    }
}

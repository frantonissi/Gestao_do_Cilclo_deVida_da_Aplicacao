package projetoprincipiosdesign;

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
            for (ItemPedido item : pedido.getItens()) { //o : seria um para cada, ou seja, para cada pedido, pegue os itens dele
                subtotal += item.getPreco() * item.getQuantidade();
            }
        }

        double valorDesconto;

        if(desconto != null){
            valorDesconto = desconto.calcular(subtotal);
        }else{
            valorDesconto = 0.0;
        } //lógica para aplicar o desconto, depois no main iremos escolher qual vai ser o desconto (aluno, professor ou funcionario)



        double valorFrete;

        if(tipoEntrega != null){
            valorFrete = tipoEntrega.calcularFrete(subtotal);
        }else{
            return  0.0;
        }


        return (subtotal - valorDesconto) + valorFrete;

    }

    public double calcularTotalComParcelas(Pedido pedido, Desconto desconto, TipoEntrega tipoEntrega, Parcelavel parcelavel) {
        double subtotal = 0.0;

        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) { //o : seria um para cada, ou seja, para cada pedido, pegue os itens dele
                subtotal += item.getPreco() * item.getQuantidade();
            }
        }

        double valorDesconto;

        if(desconto != null){
            valorDesconto = desconto.calcular(subtotal);
        }else{
            valorDesconto = 0.0;
        } //lógica para aplicar o desconto, depois no main iremos escolher qual vai ser o desconto (aluno, professor ou funcionario)



        double valorFrete;

        if(tipoEntrega != null){
            valorFrete = tipoEntrega.calcularFrete(subtotal);
        }else{
            return  0.0;
        }

        double valorFinal = (subtotal - valorDesconto) + valorFrete;


        double parcelas = 0;
        if(parcelavel != null){
            parcelas = parcelavel.parcelar(12, valorFinal);
        }
        return parcelas;

    }


    public String calcularTotalBoleto(Pedido pedido, Desconto desconto, TipoEntrega tipoEntrega, GerarBoleto gerarBoleto) {
        double subtotal = 0.0;

        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) { //o : seria um para cada, ou seja, para cada pedido, pegue os itens dele
                subtotal += item.getPreco() * item.getQuantidade();
            }
        }

        double valorDesconto;

        if(desconto != null){
            valorDesconto = desconto.calcular(subtotal);
        }else{
            valorDesconto = 0.0;
        } //lógica para aplicar o desconto, depois no main iremos escolher qual vai ser o desconto (aluno, professor ou funcionario)



        double valorFrete;

        if(tipoEntrega != null){
            valorFrete = tipoEntrega.calcularFrete(subtotal);
        }else{
            return  "0.0";
        }

        double valorFinal = (subtotal - valorDesconto) + valorFrete;

        return gerarBoleto.gerarBoleto(valorFinal) + valorFinal;


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
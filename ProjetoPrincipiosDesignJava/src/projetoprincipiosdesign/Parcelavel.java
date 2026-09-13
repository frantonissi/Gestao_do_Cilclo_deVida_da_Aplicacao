package projetoprincipiosdesign;

public interface Parcelavel {
    double parcelar(int quantidade_parcelas, double valorTotal);
}

/*
*
*Diminui o acoplamento pois se eu mexer na classe PagamentoCartao, não afeta o pedido service, pois o PedidoService
Chama essa interface, não a classe (a interface seria a intermediária).
*
*
* */
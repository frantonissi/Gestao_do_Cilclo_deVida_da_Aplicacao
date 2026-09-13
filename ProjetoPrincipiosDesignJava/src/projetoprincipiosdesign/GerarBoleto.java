package projetoprincipiosdesign;

public interface GerarBoleto {
    String gerarBoleto(double valor);
}

/*
*
*Diminui o acoplamento pois se eu mexer na classe PagamentoBoleto, não afeta o pedido service, pois o PedidoService
Chama essa interface, não a classe (a interface seria a intermediária).
*
*
* */

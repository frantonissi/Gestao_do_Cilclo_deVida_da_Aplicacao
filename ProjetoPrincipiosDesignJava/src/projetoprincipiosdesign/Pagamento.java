package projetoprincipiosdesign;

public interface Pagamento {
    boolean pagar(double valor);
}

/*
*
* Melhor usar uma interface pagamento para diminuir o acoplamento, pois assim, mudar algo nas classes de
 pagamento nao altera o PedidoService
*
* */
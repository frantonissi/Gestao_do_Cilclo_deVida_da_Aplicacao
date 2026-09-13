package projetoprincipiosdesign;

public interface PedidoRepository {
    void salvar(Pedido pedido);
}

/*
*
* Com essa classe, eu posso adicionar novos PedidoRepository de forma que nao quebre o código
*
* */
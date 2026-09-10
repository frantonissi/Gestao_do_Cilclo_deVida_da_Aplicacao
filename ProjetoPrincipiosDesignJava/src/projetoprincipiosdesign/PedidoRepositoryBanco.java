package projetoprincipiosdesign;

public class PedidoRepositoryBanco implements PedidoRepository{
    public void salvar(Pedido pedido){
        System.out.println("Pedido salvo no banco de dados com sucesso!");
    }
}

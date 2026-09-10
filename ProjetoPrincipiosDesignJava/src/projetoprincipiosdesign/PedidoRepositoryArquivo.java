package projetoprincipiosdesign;

public class PedidoRepositoryArquivo implements PedidoRepository{
    public void salvar(Pedido pedido){
        System.out.println("Pedido salvo em arquivo com sucesso!");
    }
}

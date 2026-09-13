package projetoprincipiosdesign;

public class PagamentoCartao implements Pagamento, Parcelavel {
  /*  @Override
    public void pagar(double valor) {
        System.out.printf("Pagamento no cartão: R$ %.2f%n", valor);
    }

    @Override
    public void parcelar(double valor, int parcelas) {
        System.out.printf(
            "Cartão parcelado em %dx de R$ %.2f%n",
            parcelas,
            valor / parcelas
        );
    }

    @Override
    public void gerarBoleto(double valor) {
        System.out.println("Operação não utilizada para cartão.");
    }
   */

    @Override
    public double parcelar(int quantidade_parcelas, double valorTotal){
        if(quantidade_parcelas < 2 || quantidade_parcelas > 12){
            throw new IllegalArgumentException("Número de parcelas inválido (máx 12x e min 2).");
        }
        if(valorTotal <= 0){
            throw new IllegalArgumentException("Valor disponivel insuficiente.");
        }
        return valorTotal/quantidade_parcelas;

    }

    @Override
    public boolean pagar(double valor) {
        if(valor <= 0){
            return false;
        }else{
            System.out.println("Pagamento via cartão efetuado com sucesso.");
            return true;
        }
    }
}

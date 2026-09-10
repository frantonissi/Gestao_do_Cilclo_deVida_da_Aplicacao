package projetoprincipiosdesign.PagamentosGeral;

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
    public void parcelar(int quantidade_parcelas, double valorTotal){
        if(quantidade_parcelas < 1 || quantidade_parcelas > 12){
            throw new IllegalArgumentException("Número de parcelas inválido (máx 12x).");
        }
        if(valorTotal <= 0){
            throw new IllegalArgumentException("Valor disponivel insuficiente (máx 12x).");
        }
        double valor_Parcela = valorTotal/quantidade_parcelas;
        System.out.printf("Cartão parcelado em %dx de R$ %.2f%n", quantidade_parcelas, valor_Parcela);
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

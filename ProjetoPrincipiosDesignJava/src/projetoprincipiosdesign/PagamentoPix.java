package projetoprincipiosdesign;

public class PagamentoPix implements Pagamento {
   /* @Override
    public void pagar(double valor) {
        System.out.printf("PIX pago: R$ %.2f%n", valor);
    }

    @Override
    public void parcelar(double valor, int parcelas) {
        throw new UnsupportedOperationException("PIX não pode ser parcelado.");
    }

    @Override
    public void gerarBoleto(double valor) {
        System.out.println("Operação não utilizada para PIX.");
    }
    */
    public boolean pagar(double valor){
        if(valor <= 0){
            return false;
        }else{
            System.out.println("Pagamento via PIX efetuado com sucesso.");
            return true;
        }
    }
}

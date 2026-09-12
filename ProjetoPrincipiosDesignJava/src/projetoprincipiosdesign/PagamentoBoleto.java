package projetoprincipiosdesign;

public class PagamentoBoleto implements Pagamento, GerarBoleto {
    @Override
    public String gerarBoleto(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor para emissão do boleto deve ser maior que zero.");
        }
        return "valor aleatorio";
    }

    @Override
    public boolean pagar(double valor) {
        if(valor <= 0){
            return false;
        }else{
            System.out.println("Pagamento via Boleto efetuado com sucesso.");
            return true;
        }
    }
   /* @Override
    public void pagar(double valor) {
        System.out.printf("Boleto registrado: R$ %.2f%n", valor);
    }

    @Override
    public void parcelar(double valor, int parcelas) {
        System.out.println("Operação não utilizada para boleto.");
    }

    @Override
    public void gerarBoleto(double valor) {
        System.out.printf("Linha digitável gerada para R$ %.2f%n", valor);
    }
    */

}

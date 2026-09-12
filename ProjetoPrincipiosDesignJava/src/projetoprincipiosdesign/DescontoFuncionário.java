package projetoprincipiosdesign;

public class DescontoFuncionário implements Desconto {
    @Override
    public double calcular(double ValorTotal) {
       return ValorTotal * 0.05;
    }
}

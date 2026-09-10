package projetoprincipiosdesign.Descontos;

public class DescontoAluno implements Desconto {
    @Override
    public double calcular(double ValorTotal){
       return ValorTotal * 0.10;
    }
}

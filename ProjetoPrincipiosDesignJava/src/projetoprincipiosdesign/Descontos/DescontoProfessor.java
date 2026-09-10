package projetoprincipiosdesign.Descontos;

public class DescontoProfessor implements Desconto {
    @Override
    public double calcular(double ValorTotal) {
        return ValorTotal * 0.20;
    }
}

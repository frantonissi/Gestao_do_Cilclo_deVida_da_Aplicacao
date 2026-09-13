package projetoprincipiosdesign;

public interface TipoEntrega {
    double calcularFrete(double valorTotal);
}

/*
*
* Posso adicionar novas  classes de tipo de entrega sem quebrar o código, por isso essa interface é importante
*
* */
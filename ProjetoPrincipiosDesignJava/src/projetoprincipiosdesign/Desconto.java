package projetoprincipiosdesign;

public interface Desconto {
    double calcular(double valorTotal);
}

/*Aqui foi criado a interface Desconto, para diminuir o acoplamento, e como ela tem só uma função, a coesão
dela também é alta
*
* Ela diminui o acoplamento, pois se algum dia eu quiser adicionar mais uma forma de desconto, eu não
preciso mexer no pedidoService, pois ele está ligado a essa interface e essa interface que tem a responsabilidade
 de gerencia as suas classes
*
* */
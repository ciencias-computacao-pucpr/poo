package trabalho1;

/**
 * Classe Semaforo
 * a.Atributo:
 *     cor, representada com um valor inteiro ==>0 (verde), 1 (amarelo) ou 2 (vermelho), sendo o valor inicial igual a 2.
 *
 * b.Métodos:
 *     i.MudaProximaCor: sem parâmetros e sem retorno ==> muda a cor atual do semáforopara a próxima cor(se estiver verde, fica amarelo; se estiver amarelo, fica vermelho; se estiver vermelho, fica verde).
 *     ii.MudaCorFixa: com parâmetro inteiro, sem retorno ==> muda a cor atual do semáforo para a cor fornecida como parâmetro.
 *     iii.MostraCor: sem parâmetro, com retorno inteiro ==> retorna a cor atual do semáforo.
 */
public class Semaforo {
    public static final int VERDE=0;
    public static final int AMARELO=1;
    public static final int VERMELHO=2;

    public static int cor = VERMELHO;

    public static void mudaProximaCor() {
        cor = ++cor % 3;
    }

    public static void mudaCorFixa(int novaCor) {
        cor = novaCor;
    }

    public static int mostraCor() {
        return cor;
    }
}

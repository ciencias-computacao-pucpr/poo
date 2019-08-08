package trabalho1;

/**
 * Classe Controle
 *   a. Contém o método main com os seguintes passos:
 *       i. Imprime a cor do semáforo
 *       ii. Repete 10 vezes as seguintes operações:
 *           1. Muda a cor atual do semáforo para a próxima cor
 *           2. Imprime a cor do semáforo
 *       iii. Fixa a cor do semáforo em amarelo
 *       iv. Imprime a cor do semáforo
 */
public class Controle {
    public static void main(String[] args) {
        for (int cor = 0; cor < 10; cor++) {
            Semafaro.mudaProximaCor();
            System.out.printf("Cor do semáforo: %s%n", Semafaro.mostraCor());
        }

        Semafaro.mudaCorFixa(Semafaro.AMARELO);
        System.out.printf("Cor do semáforo: %s%n", Semafaro.mostraCor());
    }

    private static String corPorExtenso() {
        if (Semafaro.mostraCor() == Semafaro.VERDE) return "verde";
        if (Semafaro.mostraCor() == Semafaro.AMARELO) return "amarelo";
        if (Semafaro.mostraCor() == Semafaro.VERMELHO) return "vermelho";

        return "desligado";
    }
}

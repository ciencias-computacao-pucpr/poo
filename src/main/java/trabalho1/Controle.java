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
            Semaforo.mudaProximaCor();
            System.out.printf("Cor do semáforo: %s%n", Semaforo.mostraCor());
        }

        Semaforo.mudaCorFixa(Semaforo.AMARELO);
        System.out.printf("Cor do semáforo: %s%n", Semaforo.mostraCor());
    }

    private static String corPorExtenso() {
        if (Semaforo.mostraCor() == Semaforo.VERDE) return "verde";
        if (Semaforo.mostraCor() == Semaforo.AMARELO) return "amarelo";
        if (Semaforo.mostraCor() == Semaforo.VERMELHO) return "vermelho";

        return "desligado";
    }
}

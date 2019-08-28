package cli;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private List<OpcaoCLI> acoes = new LinkedList<>();
    private int quantidadeOpcoes = 1;

    public void addOpcaoCLI(String descricao, Runnable acao) {
        acoes.add(new OpcaoCLI(descricao, quantidadeOpcoes++, acao));
    }

    public String listaDeOpcoes() {
        StringBuilder builder = new StringBuilder();
        acoes.forEach(acao -> builder.append(acao).append(System.lineSeparator()));
        builder.append("(0): Sair").append(System.lineSeparator());

        return builder.toString();
    }

    private boolean executaAcao(String acaoString) {
        int acao = new ValidadorOpcoes(acaoString, quantidadeOpcoes).parseOpcao();

        if (acao == 0)
            return false;

        OpcaoCLI opcaoCLI = acoes.stream().filter(a -> a.isAcao(acao)).findFirst().orElseThrow(ValidadorOpcoes.AcaoInexistente::new);
        opcaoCLI.executa();
        return true;
    }

    public boolean executa() {
        System.out.println("Digite uma opção:");
        System.out.println(listaDeOpcoes());
        System.out.print("Opção: ");
        Scanner scanner = new Scanner(System.in);
        try {
            return executaAcao(scanner.nextLine());
        } catch (ValidadorOpcoes.AcaoInexistente acaoInexistente) {
            return true;
        }
    }

}

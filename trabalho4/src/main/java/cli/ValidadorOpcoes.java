package cli;

public class ValidadorOpcoes {
    private final String acao;
    private final int quantidade;

    public ValidadorOpcoes(String acao, int quantidade) {
        this.acao = acao;
        this.quantidade = quantidade;
    }

    public int parseOpcao() {
        if (!consegueFazerParse(acao))
            throw new AcaoInexistente();

        int opcao = Integer.parseInt(acao);

        if (exiteOpcaoCadastrada(opcao))
            throw new AcaoInexistente();

        return opcao;
    }

    private boolean exiteOpcaoCadastrada(int opcao) {
            return opcao > quantidade;
    }

    private boolean consegueFazerParse(String linha) {
        return linha.isEmpty() || isNumericoPositivo(linha);
    }

    private boolean isNumericoPositivo(String valor) {
        if (valor.charAt(0) == '-')
            return valor.substring(1).chars().allMatch(a -> a >= '0' && a <= '9');
        return valor.chars().allMatch(a -> a >= '0' && a <= '9');
    }


    protected static class AcaoInexistente extends IllegalArgumentException {}
}

import java.text.ChoiceFormat;
import java.text.MessageFormat;

public class Mensagem {
    private boolean enviada;
    private String mensagem;

    public static final boolean ENVIADA = true;
    public static final boolean RECEBIDA = false;

    public Mensagem(boolean enviada, String mensagem) {
        this.enviada = enviada;
        this.mensagem = mensagem;
    }


    @Override
    public String toString() {
        return MessageFormat.format("{0}: {1}", enviada ? "ENVIADA" : "RECEBIDA", mensagem);
    }
}

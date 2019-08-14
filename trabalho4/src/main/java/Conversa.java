import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.lineSeparator;
import static java.text.MessageFormat.format;

public class Conversa {
    private final String contato;
    private final List<String> mensagens = new LinkedList<>();

    public Conversa(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        String todasMensagens = "";
        for (String mensagen : mensagens) {
            todasMensagens = todasMensagens + mensagen + lineSeparator();
        }
        return format("Mensagem com \"{0}\"", contato);
    }
}

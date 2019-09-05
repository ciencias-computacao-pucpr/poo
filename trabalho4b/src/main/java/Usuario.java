import java.util.*;

public class Usuario {
    private final String nome;
    private final List<Conversa> conversas = new ArrayList<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    private Conversa iniciarConversa(Usuario contato) {
        Optional<Conversa> z = conversas.stream().filter(conversa -> conversa.getNomeContato().equals(contato.getNome())).findAny();
        if (z.isPresent())
            return z.get();

        Conversa e = new Conversa(contato.getNome());
        this.conversas.add(e);
        contato.conversas.add(new Conversa(nome));
        return e;
    }

    public void enviarMensagem(Usuario contato, String mensagem) {
        Conversa conversa1 = iniciarConversa(contato);
        conversa1.adicionarMensagem(mensagem, Mensagem.ENVIADA);
        contato.receberMensagem(nome, mensagem);

    }

    private void receberMensagem(String nomeContato, String mensagem) {
        Optional<Conversa> z = conversas.stream().filter(conversa -> conversa.getNomeContato().equals(nomeContato)).findAny();
        z.ifPresent(c -> c.adicionarMensagem(mensagem, Mensagem.RECEBIDA));
    }

    public List<Conversa> getConversas() {
        return Collections.unmodifiableList(conversas);
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }


}

package cli.opcoes;

import usuario.Conversa;
import usuario.Mensagem;
import usuario.Repositorio;

public class CLIListarMensagens implements Runnable {
    @Override
    public void run() {
        Repositorio.instancia().todos().forEach(usuario -> {
                    System.out.print(usuario);
                    usuario.getConversas().forEach((nomeContato, conversa) -> {
                        System.out.printf(" mensagem com %s%n", nomeContato);
                        conversa.getMensagens().stream().map(Mensagem::toString).forEach(System.out::println);
                    });
                }
        );
    }
}

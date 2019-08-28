package cli.opcoes;

import usuario.Repositorio;
import usuario.Usuario;

import java.util.Scanner;

public class CLICoversar implements Runnable{
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Digite os nomes dos usuários, ou 0 para voltar");
            System.out.print("Nome do usuário remetente: ");

            Usuario rementente = null;
            while (rementente == null) {
                try {
                    String usuario = scanner.nextLine().trim();
                    if ("0".equals(usuario)) return;
                    rementente = Repositorio.instancia().buscar(usuario);
                } catch (Repositorio.UsuarioInexistenteException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            Usuario destino = null;
            while (destino == null) {
                try {
                    System.out.print("Nome do usuário destino: ");
                    String usuario = scanner.nextLine().trim();
                    if ("0".equals(usuario)) return;
                    destino = Repositorio.instancia().buscar(usuario);
                } catch (Repositorio.UsuarioInexistenteException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            System.out.println("Digite uma mensagem ou mensagem em branco para finalizar");
            String mensagem = "";
            while (true) {
                System.out.print("Mensagem: ");
                mensagem = scanner.nextLine().trim();
                if (mensagem.isEmpty())
                    return;
                rementente.enviarMensagem(destino, mensagem);
            }
        }
    }
}

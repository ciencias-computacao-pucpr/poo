import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Inicio {

    public static List<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String valorDigitado;

        while (!(valorDigitado = mostrarMenuPrincipal()).equals("0")) {
            if (!validarOpcaoEscolhida(valorDigitado)) {
                System.out.println("Opção digitada é invalida");
            }
        }

    }

    private static boolean validarOpcaoEscolhida(String valorDigitado) {
        if ("1".equals(valorDigitado)) {
            cadastraUsuario();
        } else if ("2".equals(valorDigitado)) {
            listarUsuarios();
        } else if ("3".equals(valorDigitado)) {
            iniciarConversa();
        } else if ("4".equals(valorDigitado)) {
            listarConversa();
        } else {
            return false;
        }

        return true;
    }

    private static void listarConversa() {
        usuarios.forEach(usuario -> usuario.getConversas().forEach(conversa -> {
            System.out.printf("%s mensagem com %s%n", usuario, conversa.getNomeContato());
            conversa.getMensagens().stream().map(Mensagem::toString).forEach(System.out::println);
        }));
    }

    private static void iniciarConversa() {
        Usuario remetente = perguntaUsuario("remetente");
        if (remetente == null) return;
        Usuario destino = perguntaUsuario("destino");
        if (destino == null) return;
        while (true) {
            System.out.print(">> ");
            String mensagem = scanner.nextLine().trim();
            if (mensagem.isEmpty())
                return;
            remetente.enviarMensagem(destino, mensagem);
            System.out.print(">> ");
        }
    }

    private static Usuario perguntaUsuario(String remetente) {
        System.out.println("Digite o nome do " + remetente + " ou vazio para voltar");
        System.out.print("Nome: ");
        String s = scanner.nextLine().trim();
        while(!s.isEmpty()) {
            Optional<Usuario> first = usuarios.stream().filter(usuario -> usuario.getNome().equalsIgnoreCase(s)).findFirst();
            if (first.isPresent())
                return first.get();
        }

        return null;
    }

    private static void listarUsuarios() {
        System.out.println("Usuários:");
        int count = 1;
        for (Usuario usuario : usuarios) {
            System.out.println((count++) + " - " + usuario.getNome());
        }

        System.out.println();
    }

    private static void cadastraUsuario() {
        String nome;
        System.out.println("Digite nome em branco para voltar");
        while (true) {
            System.out.print("Nome do usuário: ");

            nome = scanner.nextLine().trim();

            if (nome.isEmpty()) return;

            if (nomeNaoCadastrado(nome)) {
                usuarios.add(new Usuario(nome));
                return;
            }
            System.out.println("Usuário já cadastrado, tente outro");
        }
    }

    private static boolean nomeNaoCadastrado(String nome) {
        return usuarios.stream().noneMatch(u -> u.getNome().equals(nome));
    }


    private static String mostrarMenuPrincipal() {
        System.out.println("(1) - Cadastrar usuário");
        System.out.println("(2) - Listar usuário");
        System.out.println("(3) - Iniciar conversa entre usuários");
        System.out.println("(4) - Listar conversas");
        System.out.println("(0) - Sair");
        System.out.println();
        System.out.print("Digite uma opção: ");

        return scanner.nextLine().trim();
    }

}

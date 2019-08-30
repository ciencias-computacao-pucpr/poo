import cli.CLI;
import cli.opcoes.CLICadastrarUsuario;
import cli.opcoes.CLICoversar;
import cli.opcoes.CLIListarMensagens;
import cli.opcoes.CLIListarUsuarios;

public class Inicio {

    public static void main(String[] args) {
        CLI cli = construirInterface();

        while (!cli.isTerminou()) {
            cli.executa();
        }
    }


    private static CLI construirInterface() {
        CLI cli = new CLI();
        cli.addOpcaoCLI("Cadastrar usuário", new CLICadastrarUsuario());
        cli.addOpcaoCLI("Listar usuários", new CLIListarUsuarios());
        cli.addOpcaoCLI("Iniciar conversa entre usuários", new CLICoversar());
        cli.addOpcaoCLI("Listar conversas de um usuário", new CLIListarMensagens());
        return cli;
    }

}

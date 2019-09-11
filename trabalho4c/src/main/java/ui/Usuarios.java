package ui;

import chat.Inicio;
import chat.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Usuarios {
    @FXML
    public ListView<Usuario> usuarioListView;

    public TextField nomeUsuario;

    public void cadastrarUsuario(ActionEvent event) {
        if (podeCadastrar())
            Main.usuarios.add(new Usuario(nomeUsuario.getText()));
    }

    private boolean podeCadastrar() {
        final String nomeDigitado = nomeUsuario.getText().trim().toLowerCase();

        if (nomeDigitado.isEmpty())
            return false;

        for (Usuario usuario : Main.usuarios) {
            if (usuario.getNome().toLowerCase().equals(nomeDigitado))
                return false;
        }
        return true;
    }

    @FXML
    public void initialize() {
        usuarioListView.setItems(Main.usuarios);
    }
}

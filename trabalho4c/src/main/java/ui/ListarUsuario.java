package ui;

import chat.Inicio;
import chat.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ListarUsuario {
    @FXML
    public ListView<Usuario> usuarioListView;

    @FXML
    public void initialize() {
        usuarioListView.setItems(Main.usuarios);
    }
}

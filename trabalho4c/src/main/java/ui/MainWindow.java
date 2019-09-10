package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {
    public void cadastrarUsuario(ActionEvent actionEvent) {

    }

    public void listarUsuario(ActionEvent actionEvent) throws IOException {
        Pane load = FXMLLoader.load(getClass().getResource("/ListarUsuario.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.show();
    }
}

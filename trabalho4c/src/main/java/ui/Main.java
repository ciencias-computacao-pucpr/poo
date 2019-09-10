package ui;

import chat.Inicio;
import chat.Usuario;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane inicioPane = FXMLLoader.load(getClass().getResource("/Inicio.fxml"));
        Scene mainScene = new Scene(inicioPane);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static final ObservableList<Usuario> usuarios = FXCollections.observableList(Inicio.usuarios);

    public static void main(String[] args) {

        Application.launch(args);
    }
}

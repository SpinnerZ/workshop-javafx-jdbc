package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Carrega o arquivo que contém a View
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));

            //Define qual será o tipo do elemento que foi carregado
            ScrollPane scrollPane = loader.load();
            //Determina que a altura e largura do palco será o tamanho da janela
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);

            //Cria uma cena
            Scene mainScene = new Scene(scrollPane);
            //Diz qual a cena principal do palco que foi recebido, o título e o exibe.
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Sample JavaFX application");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

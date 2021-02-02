package gui;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;
    @FXML
    private MenuItem menuItemDepartment;
    @FXML
    private MenuItem menuItemAbout;


    @FXML
    public void onMenuItemSellerAction() {

    }

    @FXML
    public void onMenuItemDepartmentAction() {
        loadView("/gui/DepartmentList.fxml");
    }

    @FXML
    public void onMenuItemAboutAction() {
        loadView("/gui/About.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

//    Synchronized serve para garantir que o processo será executado sem interrupções devido ao multitread
    private synchronized void loadView(String absoluteName) {
        try {
            //Carrega a Vbox
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
//          Referência para VBox da janela principal
//          getRoot pega o primeiro elemento da View.
//          getContent pega o que está dentro da tag content. Nesse caso, o VBox
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

//          Refaz o menu, copiando o conteúdo antigo e adicionando o novo.
            Node mainMenu = mainVBox.getChildren().get(0);
//            Limpa todo o conteúdo da tela. Ela será remontada
            mainVBox.getChildren().clear();
//            Faz o menu novamente
            mainVBox.getChildren().add(mainMenu);
//            Adiciona apenas o novo conteúdo. Só reaproveitou o menu da tela anterior!
            mainVBox.getChildren().addAll(newVBox.getChildren());

        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}

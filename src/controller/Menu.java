package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import model.ModelCancel;
import model.ModelTask;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class Menu {
    @FXML
    static private TextField idPlayer;
    @FXML
    static private TextField idMatch;
    @FXML
    static private TextField playerName;
    static private Stage scene;

    static  private MediaPlayer player;

    public void goMenu(Stage primaryStage) throws IOException {
        Parent root;
        scene = primaryStage;
        FXMLLoader loader = new FXMLLoader(Menu.class.getResource("menu.fxml"));
        root = loader.load();
        Map<String, Object> namespace = loader.getNamespace();
        idPlayer = (TextField) namespace.get("idPlayer");
        idMatch = (TextField) namespace.get("idMatch");
        playerName =(TextField) namespace.get("playerName");
        AnchorPane anchorPane = (AnchorPane) namespace.get("AnchorPane");
        ScrollPane scrollPane = (ScrollPane) namespace.get("ScrollPane");
        AnchorPane pane = (AnchorPane) namespace.get("Pane");
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.cacheHintProperty().bindBidirectional(anchorPane.cacheHintProperty());
       // scrollPane.contentProperty().bind(anchorPane.clipProperty());
        Media media = new Media(Paths.get("src/HeroesIcon/main.mp4").toUri().toString());
        player = new MediaPlayer(media);
        MediaView mediaView = new MediaView(player);
        mediaView.setPreserveRatio(false);
        pane.getChildren().add(mediaView);
       mediaView.fitWidthProperty().bind(pane.widthProperty());
        mediaView.fitHeightProperty().bind(pane.heightProperty());
        scene.setTitle("DotaBuff");
        scene.setScene(new Scene(root, 1280, 720));
        scene.show();
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
        player.setMute(true);
        player.setBalance(12);
    }


    public void goPlayer() throws IOException {
        WaitMenu waitMenu = new WaitMenu();
        waitMenu.waitProfile(scene, idPlayer.getText());
        ModelCancel.setCodeOfOperation(1);
    }

    public void goMatch() throws IOException {
        WaitMenu waitMenu = new WaitMenu();
        waitMenu.waitMatches(scene, idMatch.getText());
        ModelCancel.setCodeOfOperation(1);
    }

    public void goName() {
        ModelCancel.setCodeOfOperation(1);
        ModelTask modelTask = new ModelTask(new Tab());
        modelTask.taskName(scene,playerName.getText());
    }
}

package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ModelTask;

import java.io.IOException;

public class WaitMenu {

    void waitMatches(Stage primaryStage, String id) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(WaitMenu.class.getResource("menuwait.fxml"));
        root = loader.load();
        Scene scene = primaryStage.getScene();
        ScrollPane node = (ScrollPane) scene.getRoot().getChildrenUnmodifiable().get(0);
        AnchorPane pane = (AnchorPane) node.getContent();
        TabPane tabPane = (TabPane) pane.getChildren().get(0);
        Tab tab = new Tab("Загрузка", root);
        tabPane.getTabs().add(tab);
        ModelTask modelTask = new ModelTask(tab);
        modelTask.taskMatches(primaryStage,id);
    }

    void waitProfile(Stage primaryStage, String id) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(WaitMenu.class.getResource("menuwait.fxml"));
        root = loader.load();
        Scene scene = primaryStage.getScene();
        ScrollPane node = (ScrollPane) scene.getRoot().getChildrenUnmodifiable().get(0);
        AnchorPane pane = (AnchorPane) node.getContent();
        TabPane tabPane = (TabPane) pane.getChildren().get(0);
        Tab tab = new Tab("Загрузка", root);
        tabPane.getTabs().add(tab);
        ModelTask modelTask = new ModelTask(tab);
        modelTask.taskProfile(primaryStage,id);

    }
    void waitName(Stage primaryStage, String name) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(WaitMenu.class.getResource("menuwait.fxml"));
        root = loader.load();
        Scene scene= primaryStage.getScene();
        AnchorPane anchorPane =(AnchorPane) scene.getRoot();
        anchorPane.getChildren().add(root.getChildrenUnmodifiable().get(0));
       /* model.ModelTask modelTask = new model.ModelTask();
        modelTask.taskName(primaryStage,name);*/
        primaryStage.show();
    }
}

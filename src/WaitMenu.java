import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WaitMenu {

    void waitMatches(Stage primaryStage, String id) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(WaitMenu.class.getResource("menuwait.fxml"));
        root = loader.load();
        Scene scene= primaryStage.getScene();
        AnchorPane anchorPane =(AnchorPane) scene.getRoot();
        anchorPane.getChildren().add(root.getChildrenUnmodifiable().get(0));
        ModelTask modelTask = new ModelTask();
        modelTask.taskMatches(primaryStage,id);
        primaryStage.show();
    }

    void waitProfile(Stage primaryStage, String id) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(WaitMenu.class.getResource("menuwait.fxml"));
        root = loader.load();
        Scene scene= primaryStage.getScene();
        AnchorPane anchorPane =(AnchorPane) scene.getRoot();
        anchorPane.getChildren().add(root.getChildrenUnmodifiable().get(0));
        ModelTask modelTask = new ModelTask();
        modelTask.taskProfile(primaryStage,id);
        primaryStage.show();
    }
    void waitName(Stage primaryStage, String name) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(WaitMenu.class.getResource("menuwait.fxml"));
        root = loader.load();
        Scene scene= primaryStage.getScene();
        AnchorPane anchorPane =(AnchorPane) scene.getRoot();
        anchorPane.getChildren().add(root.getChildrenUnmodifiable().get(0));
        ModelTask modelTask = new ModelTask();
        modelTask.taskName(primaryStage,name);
        primaryStage.show();
    }
}

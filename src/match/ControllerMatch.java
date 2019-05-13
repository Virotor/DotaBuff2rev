package match;

import Matches.ControllerMatches;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class ControllerMatch {


    static public void show(Stage primaryStage) throws IOException {
        Parent root;// = FXMLLoader.load(ControllerMatches.class.getResource("matches.fxml"));
        FXMLLoader loader = new FXMLLoader(ControllerMatch.class.getResource("match.fxml"));
        root = loader.load();
        primaryStage.setTitle("DotaBuff");
        primaryStage.setScene(new Scene(root, 960, 540));
        primaryStage.show();
    }
}

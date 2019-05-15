import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class Menu {
    @FXML
    static private TextField idPlayer;
    @FXML
    static private TextField idMatch;
    static private Stage scene;
    static private Map<String, Object> namespace;

    static public void goMenu(Stage primaryStage) throws IOException {
        Parent root;
        scene = primaryStage;
        FXMLLoader loader = new FXMLLoader(Menu.class.getResource("menu.fxml"));
        root = loader.load();
        namespace = loader.getNamespace();
        idPlayer = (TextField) namespace.get("idPlayer");
        idMatch = (TextField) namespace.get("idMatch");
        scene.setTitle("DotaBuff");
        scene.setScene(new Scene(root, 960, 540));
        scene.show();
    }


    public void goPlayer() throws IOException, InterruptedException {
        String str = idPlayer.getText();
        PlayerStatistics playerStatistics = Client.playerStatisticsAndMatches(str);
        ControllerMatches.setPlayer(playerStatistics);
        ControllerMatches cm = new ControllerMatches();
        cm.show(scene);
    }

    public void goMatch() throws IOException {
        String str = idMatch.getText();
        PlayerMatchStatistics[] playerMatchStatistics = null;
        DataForGraphs dataForGraphs = null;
        Client.playerMatchStatistics(playerMatchStatistics,dataForGraphs,str);
        ControllerMatch cm = new ControllerMatch();
        cm.show(scene,playerMatchStatistics,dataForGraphs);
    }
}

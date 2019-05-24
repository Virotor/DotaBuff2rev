/*
//import ControllerMatches;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class Controller {

    static private Stage stage;


    public void heroMenu(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent root;
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("sample.fxml"));
        root = loader.load();
        Map<String, Object> namespace = loader.getNamespace();
        //this.setAction(namespace);
        stage.setResizable(false);
        stage.setTitle("DotaBuff");
        stage.setScene(new Scene(root, 960, 540));
        stage.show();
    }

    public void ClickOnHero(String heroName) throws IOException {
        ControllerHero ch = new ControllerHero();
        ch.ReadFile(heroName);
        ch.show(stage);
    }

    */
/*private void setAction(Map<String, Object> namespace) {
        new Thread(() -> {
            for (int i = 0; i < 116; i++) {
                ImageView imageView = (ImageView) namespace.get("image" + i);
                imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    try {
                        this.ClickOnHero(imageView.getId());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                imageView.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
                    InnerShadow innerShadow = new InnerShadow();
                    Color color = new Color(1, 0.12, 0.20, 0.90);
                    innerShadow.setColor(color);
                    innerShadow.setRadius(20);
                    imageView.setEffect(innerShadow);
                });
                imageView.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
                    InnerShadow innerShadow = new InnerShadow();
                    innerShadow.setRadius(0.0);
                    imageView.setEffect(innerShadow);
                });
            }
        }).start();
    }*//*


    public void chooseMatch() throws IOException, InterruptedException {
        ControllerMatches cm = new ControllerMatches();
        cm.show(stage);
    }
}
*/

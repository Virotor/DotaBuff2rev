import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
   /*     primaryStage.setTitle("Title");
        AnchorPane rootPane = new AnchorPane();
        Scene myScene = new Scene(rootPane, 600, 300);
        primaryStage.setScene(myScene);
        Popup popper = new Popup();
        popper.setWidth(200);
        popper.setHeight(300);
        Button BUTp = new Button("кнопка");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();

        BUTp.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        popper.show(primaryStage);
                        popper.setAutoHide(true);
                        popper.setX(350);
                        popper.setY(200);
                        tf1.setLayoutY(4);
                        tf2.setLayoutY(90);
//tf1.setLayoutX(4);
//tf2.setLayoutX(3);
                        popper.getContent().addAll(tf1, tf2);
                    }
                });

        AnchorPane.setRightAnchor(BUTp, 100.0);
        AnchorPane.setTopAnchor(BUTp, 5.0);

        rootPane.getChildren().addAll(BUTp);
        primaryStage.show();*/

       Menu menu = new Menu();
       menu.goMenu(primaryStage);/*
       ControllerMatches cm = new ControllerMatches();
       cm.show(primaryStage);
        /*NickName nickName = new NickName();
        nickName.show(primaryStage,Client.searchResponseByName("Sesta Espada"));*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
